package com.app.data.remote.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Notification(
    @SerialName("included_segments")
    val includedSegments: List<String>,
    val contents: NotificationMessage,
    val headings: NotificationMessage,
    @SerialName("app_id")
    val appId: String
)
