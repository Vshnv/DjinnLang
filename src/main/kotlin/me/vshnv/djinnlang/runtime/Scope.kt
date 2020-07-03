package me.vshnv.djinnlang.runtime

data class Scope (val variableMap: Map<String, Variable<*>> = mapOf())


data class Variable<T>(val name: String, val value: T) where T: Type
