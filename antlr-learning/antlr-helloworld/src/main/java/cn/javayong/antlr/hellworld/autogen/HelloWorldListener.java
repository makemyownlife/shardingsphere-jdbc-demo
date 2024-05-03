// Generated from HelloWorld.g4 by ANTLR 4.8

 package cn.javayong.antlr.hellworld.autogen;
 
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloWorldParser}.
 */
public interface HelloWorldListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloWorldParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(HelloWorldParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloWorldParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(HelloWorldParser.RContext ctx);
}