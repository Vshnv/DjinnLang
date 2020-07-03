package me.vshnv.djinnlang.lexer


fun main() {
    val input = """
       var a = 5
       a += 20
    """.trimIndent()
    val tokens: List<Token> = input.tokenize();
    tokens.forEach {
        println(it)
    }
}


class Lexer(input: String) {
    private val tokens: List<Token> = input.tokenize();


}