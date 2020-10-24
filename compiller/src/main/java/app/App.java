package app;

import app.compiler.Program;
import app.lcompiler.service.CompillerService;
import app.lexer.Token;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author vasil
 */
public class App {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // Загружаем файл с лексемами
        if (args.length > 0) {
            // Открываем файл
            List<Token> tokenList = Files.lines(Paths.get(args[0]), Charset.defaultCharset())
                    .map((t) -> {
                        Gson gson = new GsonBuilder().create();
                        return gson.fromJson(t, Token.class);
                    })
                    .collect(Collectors.toList());
            Program program = new Program();
            program.setName("program");
            program.setMainBlock(CompillerService.getBlock(tokenList, "mail"));
            System.out.println("program struct = " + program);
            program.getMainBlock()
                    .getExpList()
                    .forEach((t) -> {
                        System.out.println("t = " + t.getExpression());
                    });
        }
    }
}
