package com.example.base_android.extention

fun MutableList<String>.generate24HourTimeList():MutableList<String> {
    for (hour in 0..23) {
        val hourString = if (hour < 10) "0$hour" else hour.toString()
        this.add("$hourString:00")
    }
    return this
}