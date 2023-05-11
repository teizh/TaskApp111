package com.example.taskapp.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.taskapp.model.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task ORDER BY id DESC")
    fun getAll(): List<Task>

    @Insert
    fun insert(task: Task)

    @Delete
    fun delete(task: Task)



/*    @Query("UPDATE task set title=:titleUpdated,desc1=:descUpdated WHERE id LIKE :idUpdated")
    fun update(titleUpdated:String, descUpdated:String, idUpdated:Int)*/
   @Update
   fun update(  task: Task)

}