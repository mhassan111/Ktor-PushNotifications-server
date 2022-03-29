package com.app.plugins

import com.app.data.remote.OneSignalService
import com.app.data.remote.dto.Notification
import com.app.data.remote.dto.NotificationMessage
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*

fun Application.configureRouting(service: OneSignalService) {
    routing {
        get("/sendNotification") {
            val title = call.parameters["title"] ?: "Test"
            val description = call.parameters["description"] ?: "Test"
            val successful = service.sendNotification(
                Notification(
                    includedSegments = listOf("All"),
                    headings = NotificationMessage(en = title),
                    contents = NotificationMessage(en = description),
                    appId = OneSignalService.ONE_SIGNAL_APP_ID
                )
            )
            if (successful) {
                call.respond(HttpStatusCode.OK)
            } else {
                call.respond(HttpStatusCode.InternalServerError)
            }
        }
    }
}

