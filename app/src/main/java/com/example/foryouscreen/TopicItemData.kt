package com.example.foryouscreen

data class TopicItemData(
    val icon: Int,
    val name: String,
    var isAdded: Boolean = false // Trạng thái isAdded của từng mục
)