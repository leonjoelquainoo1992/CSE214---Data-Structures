/*
 * Name: Joel Quainoo
 * ID: 110688594
 * CSE_214 Homework 2;
 */
/**
 * Methods: convert(char[] infix)
 * Precondition: takes an char array arguments
 * Post-Condition:  returns a string of a postfix expression.
 * /**
	 * Prec(char ch)
	 * @param ch
	 * @returns an integer <int>
 */
public class InfixToPostfixConverter {
	Stacks<Character> stack = new Stacks<>();
	public String convert(char[] infix){
		String postFixString = ""; Character ch, chr; 
		int countRight = 0;  //counts right parenthesis
		int countLeft = 0;  //counts left parenthesis
		int countOperand = 0; //counts operands
		int countOperator = 0; //counts operators 
		for(int i = 0; i < infix.length; i++){
			chr = infix[i];
			if(chr == '*' || chr == '+' || chr == '-' || chr == '/')
				countOperator++;
		}
		for(int i = 0; i < infix.length; i++){
			ch = infix[i];
			if(Character.isDigit(ch) || Character.isLetter(ch)){
				postFixString += ch;
				countOperand++;
			}
			else if(ch == '('){
				countLeft++;
				stack.push(ch);
			}
			else if(ch == ')'){
				countRight++;
				while(!stack.isEmpty() && stack.peek() != '('){
					postFixString += stack.pop();
					if(!stack.isEmpty() && stack.peek() != '(')
						System.out.println("Incorrect input");
					else
						stack.pop();
				}
			}
			else{
				while(!stack.isEmpty() && Prec(ch) < Prec(stack.peek())){
					postFixString += stack.pop();
				}
				stack.push(ch);
			}	
				
		}
		while (!stack.isEmpty())
		        postFixString += stack.pop();
		if(countRight > countLeft || countRight < countLeft || countOperand <= countOperator)
			System.err.println("Wrong Expression.");
		else
			return postFixString;
		return "";
	}
	
	public int Prec(char ch){
		switch (ch)
	    {
	    case '+':
	    case '-':
	        return 1;
	 
	    case '*':
	    case '/':
	        return 2;
	    }
		return -1;
	}

}
