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
    companion object {
        const val PREF_NAME = "pref.name"
        const val SHOWED_KEY = "showed.key"
    }
}