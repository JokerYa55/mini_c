package app.service;

import lombok.extern.java.Log;

/**
 *
 * @author vasil
 */
@Log
public class LexerService {

    private static final String DIGIT_REGEXP = "[0-9]";
    private static final String SYMBOL_REGEXP = "[a-zA-Z]";
    private static final String OPER_REGEXP = "[\\+\\-\\<\\=;\\*\\{\\}\\(\\)]";
    private static final String WORD_REGEXP = "^(if)|(else)$";

    // Определяет является ли символ цифрой
    public static boolean isDigits(char ch) {
        return String.valueOf(ch).matches(DIGIT_REGEXP);
    }
    
    // Определяет является ли символ буквой
    public static boolean isSymbol(char ch) {
        return String.valueOf(ch).matches(SYMBOL_REGEXP);
    }
    
    // Определяет является ли символ операцией
    public static boolean isOper(char ch) {
        return String.valueOf(ch).matches(OPER_REGEXP);
    }
    
    // Определяет является ли строка ключквым словом
    public static boolean wordSymbol(String str) {
        return str.matches(WORD_REGEXP);
    }
}
