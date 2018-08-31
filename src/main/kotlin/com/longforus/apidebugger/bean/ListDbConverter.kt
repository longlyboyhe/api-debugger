package com.longforus.apidebugger.bean

import com.google.gson.reflect.TypeToken
import com.longforus.apidebugger.MyValueHandler
import io.objectbox.converter.PropertyConverter

/**
 * Created by XQ Yang on 8/30/2018  5:48 PM.
 * Description :
 */
class ListDbConverter : PropertyConverter<List<String>, String> {

    override fun convertToEntityProperty(databaseValue: String?): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return MyValueHandler.gson.fromJson(databaseValue, type)
    }

    override fun convertToDatabaseValue(entityProperty:List<String>?): String {
      return MyValueHandler.gson.toJson(entityProperty)
    }

}