package me.vshnv.djinnlang.runtime

import java.lang.Exception

object StateHolder {
    val scopeMap: Map<Int, Scope> = mapOf()

    fun getVariable(scope: Int, name: String): Variable<*> {
        for (i in scope downTo 0) {
            return scopeMap[scope]?.variableMap?.get(name) ?:continue
        }
        throw Exception("Variable out of scope!")
    }
}



data class Scope (val variableMap: Map<String, Variable<*>> = mapOf())


data class Variable<T>(val name: String, val value: T) where T: Type
