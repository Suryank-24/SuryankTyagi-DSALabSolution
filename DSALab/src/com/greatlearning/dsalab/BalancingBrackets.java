package com.greatlearning.dsalab;

import java.util.ArrayDeque;

public class BalancingBrackets {
	
	static boolean checkingBalancedBrackets(String bracketExpression) {
			// Using ArrayDeque
		ArrayDeque<Character> stack = new ArrayDeque<Character>();
		for(int i = 0; i < bracketExpression.length(); i++) {
			char character = bracketExpression.charAt(i);
			if(character == '(' || character == '[' || character =='{') 
				{
				stack.push(character);
				continue;
				}
			
			if(stack.isEmpty()) 
				return false;
			
			char c;
			switch(character)
			{
			case '}':
				c = stack.pop();
				if(c == '(' || c == '[')
					return false;
				break;
				
			case ')':
				c = stack.pop();
				if(c == '[' || c == '{')
					return false;
				break;
				
				case ']':
					c = stack.pop();
					if(c == '(' || c == '{')
						return false;	
					break;
		}
	}
		return (stack.isEmpty());
}

	public static void main(String[] args) {
		String bracketExpresssion = "([[{}]]))";
		boolean result;
		result = checkingBalancedBrackets(bracketExpresssion);
		if(result)
		{
		System.out.println("Entered String is containing balanced brackets.. :) ");
		}
		else
		{
		System.out.println("Entered String doesn't contains balanced brackets.. :( ");
		}
	}
}