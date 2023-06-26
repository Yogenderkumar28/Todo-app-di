package com.example.todoappdi.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "todo")
data class Todo(
    val title: String,
    val description: String,
//    val lastUpdated: String = "",
    val isDone: Boolean = false,
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null
)
