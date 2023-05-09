package com.example.taskapp.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Pref(private val context: Context) {
    private val pref: SharedPreferences = context.getSharedPreferences(TASK_PREF_NAME, MODE_PRIVATE)
    fun isUserSeen(): Boolean {
        return pref.getBoolean(USER_SEEN_KEY, false)
    }

    fun saveUserSeen() {
        pref.edit().putBoolean(USER_SEEN_KEY, true).apply()
    }

    fun saveUserName(name:String){
        pref.edit().putString(USER_NAME_KEY, name).apply()
    }

    fun getUserName ():String?= pref.getString(USER_NAME_KEY, "")

    fun saveProfileImage (pic: String){
        pref.edit().putString(USER_PIC_KEY, pic).apply()
    }
    fun getUserProfilePic ():Int?=pref.getInt(   USER_PIC_KEY, 1)


    companion object {
        const val TASK_PREF_NAME = "TaskPref"
        const val USER_SEEN_KEY = "UserSeen"
        const val USER_NAME_KEY = "UserName"
        const val USER_PIC_KEY = "UserPic"
    }


}


