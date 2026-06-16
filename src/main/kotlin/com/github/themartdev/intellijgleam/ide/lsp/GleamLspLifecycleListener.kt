package com.github.themartdev.intellijgleam.ide.lsp

import com.github.themartdev.intellijgleam.GleamBundle
import com.intellij.notification.Notification
import com.intellij.notification.NotificationAction
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.project.Project
import com.redhat.devtools.lsp4ij.LanguageServerWrapper
import com.redhat.devtools.lsp4ij.ServerStatus
import com.redhat.devtools.lsp4ij.lifecycle.LanguageServerLifecycleListener
import org.eclipse.lsp4j.jsonrpc.MessageConsumer
import org.eclipse.lsp4j.jsonrpc.messages.Message
import java.util.concurrent.atomic.AtomicReference

/**
 * Detects when the `gleam lsp` process dies unexpectedly and surfaces an actionable notification
 * with a one-click restart, so a wedged server doesn't silently kill navigation/completion until
 * the user restarts the whole IDE (see issue #105 / #153).
 *
 * The server commonly crashes when its `build/` cache goes stale (e.g. the gleam compiler failing
 * to canonicalise a now-missing artifact), so the notification also points at `gleam clean` as the
 * likely cure when a bare restart isn't enough.
 */
class GleamLspLifecycleListener(private val project: Project) : LanguageServerLifecycleListener {
    /** The most recent crash notification, kept so we can retire it on recovery/dispose instead of stacking duplicates. */
    private val activeNotification = AtomicReference<Notification?>()

    override fun handleStatusChanged(server: LanguageServerWrapper) {
        if (server.serverDefinition.id != GleamLanguageServerManager.SERVER_ID) return

        when (server.serverStatus) {
            // The server is healthy again — retire any stale crash notification.
            ServerStatus.started -> expireNotification()
            // A crash carries a server error; a user-initiated stop/disable does not, so this
            // doesn't fire when the user turns the LSP off in settings.
            ServerStatus.stopped -> if (server.serverError != null) notifyCrash()
            else -> {}
        }
    }

    override fun handleError(server: LanguageServerWrapper, throwable: Throwable) {
        // Crash detection is handled via status changes. Errors raised while the server is still
        // running are typically transient and would only spam the user.
    }

    override fun handleLSPMessage(message: Message, consumer: MessageConsumer, server: LanguageServerWrapper) {
        // Not interested in individual protocol messages.
    }

    override fun dispose() {
        expireNotification()
    }

    private fun notifyCrash() {
        if (project.isDisposed) return

        val notification = Notification(
            "intellij-gleam.gleam-ls",
            GleamBundle.message("gleam.lsp.crashed.title"),
            GleamBundle.message("gleam.lsp.crashed.content"),
            NotificationType.ERROR
        )
        notification.addAction(
            NotificationAction.createSimpleExpiring(GleamBundle.message("gleam.lsp.restart.action")) {
                GleamLanguageServerManager.restart(project)
            }
        )

        expireNotification()
        activeNotification.set(notification)
        Notifications.Bus.notify(notification, project)
    }

    private fun expireNotification() {
        activeNotification.getAndSet(null)?.expire()
    }
}
