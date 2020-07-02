package me.vshnv.djinnlang.lexer


fun main() {
    val input = """
        /*Test comment*/
        fun test(a , b): (String, Integer) {
            var a[] = 5.5, 4
        }
    """.trimIndent()
    val tokens: List<Token> = input.tokenize();
    tokens.forEach {
        println(it)
    }
}