package me.vshnv.djinnlang.lexer

import java.util.ArrayList

fun String.tokenize(): List<Token> {
    val tokens = ArrayList<Token>()
    val tokenPatternsBuffer = StringBuffer()
    // Creating regex to capture tokens
    TokenType.values().forEach {
        tokenPatternsBuffer.append(
            "|(?<${it.name}>${it.pattern})"
        )
    }


    val tokenPatterns = tokenPatternsBuffer.substring(1).toRegex().toPattern()
    val matcher = tokenPatterns.matcher(this)

    // Loop through matcher till all tokens are found
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