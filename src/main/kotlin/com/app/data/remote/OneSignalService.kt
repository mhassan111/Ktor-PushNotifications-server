package com.app.data.remote

import com.app.data.remote.dto.Notification

interface OneSignalService {

    suspend fun sendNotification(notification: Notification): Boolean

    companion object {
        const val ONE_SIGNAL_APP_ID = "23892033-6eec-4264-acbc-8c17e8ed14e5"
        const val NOTIFICATIONS = "https://onesignal.com/api/v1/notifications"
    }

}