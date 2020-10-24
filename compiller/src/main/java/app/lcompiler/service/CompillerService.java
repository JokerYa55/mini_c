package app.lcompiler.service;

import app.compiler.Expression;
import app.compiler.LexTree;
import app.compiler.ProgramBlock;
import app.lexer.Token;
import app.lexer.TokenType;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author vasil
 */
public class CompillerService {

    /**
     * Выбирает из потока токенов выражение вида ident = ident oper ident;
     *
     * @param tokenList
     * @param blockName
     * @return
     */
    public static List<Expression> getExp(List<Token> tokenList, String blockName) {
        List<Expression> result = new ArrayList<>();
        Queue<Token> tokenQueue = new ArrayDeque<>();
        tokenQueue.addAll(tokenList);
        Token nextToken = tokenQueue.poll();
        List<Token> expTokenList = new ArrayList<>();
        int expNum = 0;
        while (nextToken != null) {
            if (nextToken.getType() != TokenType.SEMICOLON) {
                expTokenList.add(nextToken);
            } else {
                expTokenList.add(nextToken);
                result.add(new Expression(String.join(":", blockName, String.valueOf(expNum)), expNum, expTokenList));
                expTokenList = new ArrayList<>();
                expNum++;
            }
            nextToken = tokenQueue.poll();
        }
        return result;
    }

    /**
     * Получает из потока токенов програм block {}
     *
     * @param tokenList
     * @return
     */
    public static ProgramBlock getBlock(List<Token> tokenList, String blockName) {
        ProgramBlock resilt = new ProgramBlock();
        Queue<Token> tokenQueue = new ArrayDeque<>();
        tokenQueue.addAll(tokenList);
        Queue<Token> braStack = new ArrayDeque();
        Token tempToken = tokenQueue.poll();
        List<Token> expTokenList = new ArrayList<>();
        if (tempToken.getType() != TokenType.LBRA) {
            throw new RuntimeException("Не хватает закрывающей скобки");
        }

        do {

            switch (tempToken.getType()) {
                case LBRA:
                    braStack.add(tempToken);
                    break;
                case RBRA:
                    braStack.poll();
                    break;
                default:
                    expTokenList.add(tempToken);
            }
            tempToken = tokenQueue.poll();
        } while (tempToken != null);
        if (braStack.size() != 0) {
            throw new RuntimeException("Не хватает скобки" + braStack.poll().getType().value());
        }
        resilt.setExpList(getExp(expTokenList, blockName));
        return resilt;
    }

    /**
     *
     * @param exp
     * @return
     */
    public static LexTree getLex(Expression exp) {
        LexTree result = new LexTree();
        Queue<Token> tokenList = new ArrayDeque();
        tokenList.addAll(exp.getExpression());
        Token nextToken = tokenList.poll();
        if (nextToken.getType() == TokenType.EQUAL){
            
        }
        return result;
    }
}
