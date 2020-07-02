package me.vshnv.djinnlang.lexer

class Token(private val type: TokenType, private val value: String) {

    override fun toString(): String {
        return "(${type.name} $value)"
    }
}

enum class TokenType(val pattern: Regex) {
    COMMENT(
        "/\\*[\\S\\s]*\\*/(\n|(\r\n))?".toRegex()
    ) {
        override fun evaluate(input: String): Collection<Token> {
            return emptySet() //Ignoring Comments
        }
    },
    VARDEF(
      "var".toRegex()
    ),
    FUNDEF(
        "fun".toRegex()
    ),
    DEFINER(
        ":".toRegex()
    ),
    LPAREN(
        "\\(".toRegex()
    ),
    RPAREN(
        "\\)".toRegex()
    ),
    LBRACKET(
        "\\[".toRegex()
    ),
    RBRACKET(
        "]".toRegex()
    ),
    LBRACE(
      "\\{".toRegex()
    ),
    RBRACE(
        "}".toRegex()
    ),
    STRING(
        "\"[A-Za-z_]+\"".toRegex()
    ),
    IDENTIFIER(
        "[A-Za-z]+".toRegex()
    ),
    DECIMAL(
      "[0-9]+\\.[0-9]+".toRegex()
    ),
    INTEGER(
        "[0-9]+".toRegex()
    ),
    CALL(
        "\\.".toRegex()
    ),
    OPERATOR(
        "[*|/|+|-]".toRegex()
    ),
    ASSIGN(
        "=".toRegex()
    ),
    ENDLINE(
      "[\\n|\\r\\n]".toRegex()
    ) {
        override fun evaluate(input: String): Collection<Token> {
            return setOf(
                Token(
                    this,
                    "endLine"
                )
            )
        }
    },
    WHITESPACE(
        "[ \\t\\f\\r\\n]+".toRegex()
    ) {
        override fun evaluate(input: String): Collection<Token> {
            return emptySet() //Ignoring White Spaces
        }
    };

    /**
     * Default evaluation function
     */
    open fun evaluate(input: String): Collection<Token> {
        return setOf(
            Token(
                this,
                input
            )
        )
    }

}