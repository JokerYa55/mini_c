package app;

import app.lexer.Token;
import app.lexer.TokenType;
import app.service.LexerService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import lombok.extern.java.Log;

/**
 *
 * @author vasil
 */
@Log
public class App {
    
    private static final Queue CHAR_FLOW = (new ArrayDeque<>());

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        List<Token> tokenList = new ArrayList<>();
        if (args.length > 0) {
            // Открываем файл
            List charList = Files.lines(Paths.get(args[0]), Charset.defaultCharset())
                    .filter((t) -> {
                        return !t.trim().matches("^//.{1,}$");
                    })
                    .peek(System.out::println)
                    .map((t) -> {
                        return t.chars()
                                .filter((value) -> {
                                    return (value != 32) && (value != 9);
                                })
                                .mapToObj(c -> (char) c)
                                .collect(Collectors.toList());
                    })
                    .flatMap(t -> t.stream())
                    .collect(Collectors.toList());
            
            CHAR_FLOW.addAll(charList);
            char ch = getChar();
            while (ch != 0) {
                //log.info("ch = " + ch);
                // Выбираем цифу
                if (LexerService.isDigits(ch)) {
                    // Формируем цифру
                    String digit = "";
                    // пока цифра выбираем символы из очереди и добавляем к digit
                    while (LexerService.isDigits(ch)) {
                        digit = digit.concat(String.valueOf(ch));
                        ch = getChar();
                    }
                    tokenList.add(new Token(digit, TokenType.NUM));
                } else if (LexerService.isSymbol(ch)) {
                    // Выбираем идентификатор
                    String ident = "";
                    // пока символ выбираем символы из очереди и добавляем к ident 
                    while (LexerService.isSymbol(ch)) {
                        ident = ident.concat(String.valueOf(ch));
                        ch = getChar();
                    }
                    tokenList.add(new Token(ident, TokenType.IDENT));
                } else if (LexerService.isOper(ch)) {
                    tokenList.add(new Token(String.valueOf(ch), TokenType.getByValue(String.valueOf(ch))));
                    ch = getChar();
                } else {
                    ch = getChar();
                }
            }
            
        }
        List<String> listString = tokenList.stream()
                .map(t -> (new GsonBuilder().create())
                .toJson(t))
                .collect(Collectors.toList());
        Gson gson = new GsonBuilder().create();
        Files.write(Paths.get("out.lex"), listString, Charset.forName("UTF-8"));
    }
    
    private static char getChar() {
        char result;
        try {
            return (char) CHAR_FLOW.poll();
        } catch (Exception e) {
            return 0;
        }
    }
    
}
