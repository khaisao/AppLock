package com.momentolabs.app.security.applocker.data.database.callblocker.calllog

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "call_log")
data class CallLogItemEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "log_id") var logId: Int = 0,
    @ColumnInfo(name = "call_log_time") var logDate: Date = Date(),
    @ColumnInfo(name = "user_name") var userName: String = "",
    @ColumnInfo(name = "phone_number") var phoneNumber: String = ""
)