package app.lexer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * лексема
 * @author vasil
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Token {
    String value;
    TokenType type;

}
