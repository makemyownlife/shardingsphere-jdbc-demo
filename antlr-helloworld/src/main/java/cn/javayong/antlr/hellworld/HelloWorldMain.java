package cn.javayong.antlr.hellworld;

import cn.javayong.antlr.hellworld.autogen.HelloWorldBaseListener;
import cn.javayong.antlr.hellworld.autogen.HelloWorldLexer;
import cn.javayong.antlr.hellworld.autogen.HelloWorldParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.Scanner;

/**
 * Basic ANTLR4 grammar
 */
public class HelloWorldMain {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入参数值：");
        String input = scanner.nextLine();

        HelloWorldLexer lexer = new HelloWorldLexer(new ANTLRInputStream(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HelloWorldParser parser = new HelloWorldParser(tokens);
        ParseTree tree = parser.r();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new HelloWalker(), tree);
    }

    public static class HelloWalker extends HelloWorldBaseListener {
        public void enterR(HelloWorldParser.RContext ctx) {
            System.out.println("Entering R : " + ctx.ID().getText());
        }

        public void exitR(HelloWorldParser.RContext ctx) {
            System.out.println("Exiting R");
        }
    }

}
