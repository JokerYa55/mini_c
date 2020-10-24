package app.compiler;

import app.lexer.Token;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author vasil
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expression {
    String name;
    long number;
    List<Token> expression;

}
