package com.example.taskapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Task(

    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    var title:String?=null,
    var desc1:String?=null



):java.io. Serializable
