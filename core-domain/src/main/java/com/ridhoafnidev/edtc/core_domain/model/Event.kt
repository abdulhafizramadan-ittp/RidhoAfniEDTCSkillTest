package com.ridhoafnidev.edtc.core_data.domain

data class Event(
    val id: Int, val name: String, val location: String, val startDate: String,
    val startTime: String, val endDate: String, val endTime: String, val image: Int,
    val description: String, val poweredBy: String)

typealias ListEvents = List<Event>

@Suppress("MagicNumber")
enum class MenuStatus(val value: Int){
    CreateEvent(1), MyEvent(2), ListEmployers(3), MeetingReservasion(4),
    PaidLeave(5), Attendance(6);

    operator fun invoke() = value
}