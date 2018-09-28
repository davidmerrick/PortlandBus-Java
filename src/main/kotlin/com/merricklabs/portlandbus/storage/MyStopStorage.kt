package com.merricklabs.portlandbus.storage

import java.util.*

interface MyStopStorage {
    fun saveStop(userId: String, stopId: Int)
    fun queryStopId(userId: String): OptionalInt
}
