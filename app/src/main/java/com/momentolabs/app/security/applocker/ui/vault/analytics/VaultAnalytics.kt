package com.momentolabs.app.security.applocker.ui.vault.analytics

import android.content.Context
import android.os.Bundle

object VaultAnalytics {

    fun addedImageVault(context: Context, size: Int) {
    }

    fun addedVideoVault(context: Context, size: Int) {
    }

    fun removedImageVault(context: Context) {
    }

    fun removedVideoVault(context: Context) {
    }

    private const val EVENT_NAME_ADDED_IMAGE_VAULT_1_5 = "event_name_added_image_vault_1_5"
    private const val EVENT_NAME_ADDED_IMAGE_VAULT_5_10 = "event_name_added_image_vault_5_10"
    private const val EVENT_NAME_ADDED_IMAGE_VAULT_10_MORE = "event_name_added_image_vault_10_more"
    private const val EVENT_NAME_ADDED_VIDEO_VAULT_1_5 = "event_name_added_video_vault_1_5"
    private const val EVENT_NAME_ADDED_VIDEO_VAULT_5_10 = "event_name_added_video_vault_5_10"
    private const val EVENT_NAME_ADDED_VIDEO_VAULT_10_MORE = "event_name_added_video_vault_10_more"
    private const val EVENT_NAME_REMOVED_IMAGE_VAULT = "event_name_removed_image_vault"
    private const val EVENT_NAME_REMOVED_VIDEO_VAULT = "event_name_removed_image_vault"
}