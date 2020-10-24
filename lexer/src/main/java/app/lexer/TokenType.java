package app.lexer;

import java.util.stream.Stream;

/**
 *
 * @author vasil
 */
public enum TokenType {
    LBRA("{"), // {
    RBRA("}"), // }
    EQUAL("="), // =
    SEMICOLON(";"), // ;
    LPAR("("), // (
    RPAR(")"), // )
    PLUS("+"), // +
    MINUS("-"), // -
    LESS("<"), // <
    IDENT(""), // Идентификатор
    NUM(""), // цифра
    IF("if"), // if
    ELSE("else"); // else

    private final String name;

    private TokenType(String name) {
        this.name = name;
    }

    public String value() {
        return this.name;
    }

    /**
     *
     * @param value
     * @return
     */
    public static TokenType getByValue(String value) {
        return Stream.of(TokenType.values())
                .filter(t -> t.value().equals(value))
                .findFirst()
                .get();
    }

}
