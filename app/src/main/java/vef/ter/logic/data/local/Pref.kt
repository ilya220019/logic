package vef.ter.logic.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(private val context: Context) {
    private val pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

    fun isOnBoardingShowed(): Boolean {
        return pref.getBoolean(SHOWED_KEY, false)
    }

    fun onOnBoardingShowed() {
        pref.edit().putBoolean(SHOWED_KEY, true).apply()
    }
    fun alertShow(): Boolean {
        return pref.getBoolean(SHOWED_KEY1, false)
    }

    fun alertShowed() {
        pref.edit().putBoolean(SHOWED_KEY1, true).apply()
    }
    fun count(progress: Int){
        pref.edit().putInt("key", progress).apply()
    }
    fun getCount(): Int{
        return pref.getInt("key", 0)
    }

    companion object {
        const val PREF_NAME = "pref.name"
        const val SHOWED_KEY = "showed.key"
        const val SHOWED_KEY1 = "showed.key1"
    }
}