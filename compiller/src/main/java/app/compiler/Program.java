package app.compiler;

import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Содержит структуру программы
 *
 * @author vasil
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Program {

    private String name;
    private ProgramBlock mainBlock;

    @Override
    public String toString() {
        return (new GsonBuilder().create()).toJson(this);
    }

}
