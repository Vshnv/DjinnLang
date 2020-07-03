package me.vshnv.djinnlang.runtime

abstract class Type(val type: Int) {
    companion object {
        const val INTEGER = 1
        const val DECIMAL = 2
        const val STRING = 3
    }
    abstract override fun toString(): String
}

class IntegerType(val value: Int): Type(INTEGER) {
    override fun toString(): String = value.toString()
}

class DecimalType(val value: Double): Type(DECIMAL) {
    override fun toString(): String = value.toString()
}

class StringType(val value: String): Type(STRING) {
    override fun toString(): String = value
}