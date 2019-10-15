package com.cdkm.kata;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class KataParenthese {
	
	public static void main(String[] args) {
		test(true, "[()]"); // true
		test(true, "(()[])"); // true
		test(false, "([)]"); // false
		test(false, "(("); // false
		test(false, "[(()])"); // false
 
		test(true, "([(([[(([]))]]))])"); // true
		test(true, "[](()()[[]]) ()[]([])"); // true
		test(false, "([((([(([]))])))))])"); // false
		test(false, "[](()()[[]])[][[([])"); // false
	}
 
	private static void test(boolean expected, String string) {
		System.out.printf("Test sur %s: %s%n", string, verification(string)==expected?"OK":"KO");
	}
 
	public static boolean verification(String string) {
		Deque<Character> stack = new ArrayDeque<>();
		for(char c : string.toCharArray()) {
			switch(c) {
			case '(':
				// cas ouvrant
				stack.push(')');
				break;
			case '[':
				// cas ouvrant
				stack.push(']');
				break;
			case ')':
			case ']':
				// cas fermant
				if ( stack.isEmpty())
					return false;
				System.out.printf("Test sur "+stack.poll()) ; 
				if (stack.pop()!=c ) {
					System.out.printf("Test sur "+stack.poll()) ; 
					return false;
				}
					
				break;
			}
		} 
		return stack.isEmpty();
	}
	
	public static boolean verificationLinkedList(String string) {
		List<Character> stack = new LinkedList<>();
		for(char c : string.toCharArray()) {
			switch(c) {
			case '(':
				// cas ouvrant
				stack.add(')');
				break;
			case '[':
				// cas ouvrant
				stack.add(']');
				break;
			case ')':
			case ']':
				// cas fermant
				if (stack.isEmpty() || stack.remove(0)!=c ) return false;
				break;
			}
		} 
		return stack.isEmpty();
	}

}
