package com.developers.sprintsync.parameters.dataStorage.repository

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesKeys {
    val GENDER = stringPreferencesKey("gender")
    val BIRTH_DATE = longPreferencesKey("birth_date_timestamp")
    val WEIGHT = floatPreferencesKey("weight")
    val WELLNESS_GOAL = stringPreferencesKey("wellness_goal")
    val USE_STATS_PERMISSION = booleanPreferencesKey("use_stats_permission")
}
