package app.compiler;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Блок операторов заключенный между {}
 *
 * @author vasil
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProgramBlock {

    private String name;
    private List<Expression> expList;

}
