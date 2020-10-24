package app.compiler;

import app.lexer.Token;
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
@NoArgsConstructor
@AllArgsConstructor
public class LexTreeNode {

    Token node;
    Token keftNode;
    Token rigthNode;
}
