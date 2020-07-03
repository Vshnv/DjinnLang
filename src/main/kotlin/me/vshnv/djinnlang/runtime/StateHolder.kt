package me.vshnv.djinnlang.runtime

object StateHolder {
    val scopeMap: Map<Int, Scope> = mapOf()

    fun getVariable(scope: Int, name: String): Variable<*> {
        for (i in scope downTo 0) {
            return scopeMap[scope]?.variableMap?.get(name) ?:continue
        }
    }
}