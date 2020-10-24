package app.compiler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Дерево синтаксического разбора
 *
 * @author vasil
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LexTree {

    LexTreeNode top;
}
