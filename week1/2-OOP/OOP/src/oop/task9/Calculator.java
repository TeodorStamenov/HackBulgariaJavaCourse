package task9;

import java.util.Scanner;
import java.util.Stack;

public class Calculator {
	private String input;
	private final char[] charOperators = {'_','^','?','/','+','-','(',')'};
	private char[] operatorsMashup = {'_','^','?','/','+','-'};
	private char[] wrongStart = {'_','?','/','^'};
	private char[] wrongEnd = {'?','/','^'};
	private Stack<Character> operators = new Stack<Character>();
	private Stack<Float> numbers = new Stack<Float>();
	private StringBuilder numberBuilder = new StringBuilder();
	private char[] inExp;
	private boolean isExpressionTrue = true;
	private Scanner fromConsole = new Scanner(System.in);
	private boolean flag = true;

	public Calculator () {
	}
	
	public void Calculate () {
		while (flag) {
			System.out.print("Please enter expression:> ");
			input = fromConsole.nextLine();
			
			if (input.equals("exit")) {
				System.out.println("Bye");
				fromConsole.close();
				flag = false;
				break;
			}
			
			inExp = toCharArray(input);
			
			if (checkFirstLastForException(inExp)) {
				printWrongMessage();
			} else if (checkForException(inExp)) {
				printWrongMessage();
			} else {	
				for (int i = 0; i < inExp.length; i++) {
					if ((numberBuilder.length() == 0 && numbers.isEmpty()) && (inExp[i] == '-' || inExp[i] == '+')) {
						setNumber(inExp[i], i);
					} else if (isNumberOrDot(inExp[i])) {
						setNumber(inExp[i], i);
					} else if (isOperator(inExp[i]) != 'e' && inExp[i] != '(' && inExp[i] != ')') {
						setNumStack();
						setOperatorsStack(inExp[i], i);
						if (inExp[i] == '_' && isLastIndex(i) && !operators.isEmpty())
							calcToTheEnd();
					} else if (inExp[i] == '(') {
						operators.push(inExp[i]);
					} else if (inExp[i] == ')') {
						setNumStack();
						calcInBrackets();
						if (isLastIndex(i) && !operators.isEmpty())
							calcToTheEnd();
					} else {
						printWrongMessage();
						break;			
					}
				}
			}
			if (isExpressionTrue)
				System.out.print("Output:> " + printResult() + "\n");
		}
	}
	
	private char[] toCharArray(String input) {
		return input.replace('*','?').replace('!','_').replaceAll("\\s","").trim().toCharArray();
	}
	
	private char isOperator(char c) {
		for (int i = 0; i < charOperators.length; i++) {
			if(c == charOperators[i])
				return charOperators[i];
		}
		return 'e';
	}
	
	private boolean isCorrect(char c) {
		for (int i = 0; i < operatorsMashup.length; i++) {
			if (c == operatorsMashup[i])
				return true;
		}
		return false;
	}
	
	private boolean isNumberOrDot(char c) {
		if (47 < c && c < 58 || c == '.') 
			return true;
		return false;
	}
	
	private void setNumber(char c, int index) {
		numberBuilder.append(c);
		if (isLastIndex(index)) {
			setNumStack();
			calcToTheEnd();
		}
	}
	
	private void calcToTheEnd() {
		while (!operators.isEmpty())
			calculateStack();
	}
	
	private void setNumStack() {
		if (numberBuilder.length() != 0) {
			numbers.push(Float.parseFloat(numberBuilder.toString()));
			numberBuilder.setLength(0);
		} 
	}
	
	private void setOperatorsStack(char c, int index) {
		if (isLastIndex(index) && c != '_') {
			printWrongMessage();
		} else if (operators.isEmpty()) {
			operators.push(c);
		} else if (operators.peek() <= c) {
			operators.push(c);
		} else if (operators.peek() > c) {
			calculateStack();
			setOperatorsStack(c, index);
		}
	}
	
	private void calcInBrackets() {
		while (operators.peek() != '(') {
			calculateStack();
		}
		operators.pop();
	}
	
	private void calculateStack() {
		float a = 0;
		float b = 0;
		
		if (operators.peek() == '_')
			a = numbers.pop();
		else {
			a = numbers.pop();
			b = numbers.pop();
		}
		
		switch (operators.pop()) {
			case '_':
				numbers.push(fac(a));
				break;
			case '^':
				numbers.push((float)Math.pow(b, a));
				break;
			case '?':
				numbers.push(a * b);
				break;
			case '/':
				numbers.push(b / a);
				break;
			case '+':
				numbers.push(a + b);
				break;
			case '-':
				numbers.push(b - a);
				break;
		}
	}
	
	private boolean isLastIndex(int index) {
		if (index + 1 == inExp.length)
			return true;
		return false;
	}
	
	private float printResult() {
		return numbers.pop();
	}
	
	private void printWrongMessage() {
		System.out.println("Wrong Expression!");
		isExpressionTrue = false;
	}
	
	private boolean checkForException (char[] inExp) {
		int cntOpenBrackets = 0;
		int cntClosedBrackets = 0;
		
		for (int i = 1; i <= inExp.length; i++) {
			if (inExp[i - 1] == '(') {
				cntOpenBrackets++;
			} else if (inExp[i - 1] == ')') {
				cntClosedBrackets++;
			} else if (!isNumberOrDot(inExp[i - 1]) && isOperator(inExp[i - 1]) == 'e') {
				return true;
			} else if (i < inExp.length) {
				if (isCorrect(inExp[i]) && isCorrect(inExp[i-1]) && inExp[i] != '_' && inExp[i - 1] != '_') {
					return true;
				} else if (isNumberOrDot(inExp[i - 1]) && inExp[i] == '(') {
					return true;
				} 	
			}
		}
		
		if (cntOpenBrackets - cntClosedBrackets != 0)
			return true;
		
		return false;
	}
	
	private boolean checkFirstLastForException(char[] inExp) {
		if (inExp.length == 0) {
			return true;
		} else if (isOperator(inExp[0]) == 'e' && !isNumberOrDot(inExp[0]))
			return true;
		
		for (int i = 0; i < wrongStart.length; i++) {
			if (inExp[0] == wrongStart[i]) {
				return true;
			}
		}
		
		for (int i = 0; i < wrongEnd.length; i++) {
			if (inExp[inExp.length - 1] == wrongEnd[i]) 
				return true;
			}
		
		return false;
	}
	
	private float fac(float n) {
		if (n == 1)
			return 1;
		else
			return n*fac(n - 1);
	}
}
