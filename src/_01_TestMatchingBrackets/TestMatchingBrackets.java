package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
	/*
	 * Use a Stack to complete the method for checking if every opening bracket has
	 * a matching closing bracket
	 */
	public static boolean doBracketsMatch(String b) {

		Stack<Character> stack = new Stack<Character>();
		for (char c : b.toCharArray()) {

			if (c == '{') {
				stack.push(c);
			}
			if (c == '}') {
				if (stack.isEmpty()) {
					return false;
				} else {
					stack.pop();
				}

			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}
}