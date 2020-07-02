package me.vshnv.djinnlang.lexer

import java.util.*


fun main() {
    val input = """
        fun test(a , b) : (String, Integer) {
            var a = 5
        }
    """.trimIndent()
    val tokens: List<Token> = input.tokenize();
    for (token in tokens) println(token)
}

/*Tokenizer*/
fun String.tokenize(): List<Token> {
    val tokens = ArrayList<Token>()
    val tokenPatternsBuffer = StringBuffer()
    for (tokenType in TokenType.values()) tokenPatternsBuffer.append(
        "|(?<${tokenType.name}>${tokenType.pattern})"
    )
    val tokenPatterns = tokenPatternsBuffer.substring(1).toRegex().toPattern()
    val matcher = tokenPatterns.matcher(this)
    val a = mutableMapOf<String, String>()
    while (matcher.find()) {
        for (tokenType in TokenType.values()) {
            if (matcher.group(tokenType.name) != null) {
                tokens.addAll(
                    tokenType.evaluate(matcher.group(tokenType.name))
                )
            }
        }
    }
    return tokens
}