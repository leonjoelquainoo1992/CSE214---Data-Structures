/*
 * Name: Joel Quainoo
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
	private char[] infix_2;
	Stacks<Character> stack = new Stacks<>();
	public String convert(char[] infix) throws Exception{
		infix_2 = new char[infix.length];
		String postFixString = ""; Character ch, chr; 
		int countRight = 0;  //counts right parenthesis
		int countLeft = 0;  //counts left parenthesis
		int countOperand = 0; //counts operands
		int countOperator = 0; //counts operators 
		for(int i = 0; i < infix.length; i++){
			chr = infix[i];
			infix_2[i] = infix[i];
			if(chr == '*' || chr == '+' || chr == '-' || chr == '/')
				countOperator++;
		}
		for(int i = 0; i < infix.length; i++){
			ch = infix[i];
			 if(Character.isDigit(ch)){
				postFixString += ch;
				countOperand++;
			}
			else if(ch == '(' || ch == '[' || ch == '{'){
				stack.push(ch);
				countLeft++;
			}
			else if(ch == '+' || ch == '*' || ch == '/' || ch == '-'){
				while(!stack.isEmpty() && Prec(ch) <= Prec(stack.peek()) && (stack.peek() != '(' || stack.peek() != '[' || stack.peek() != '{'))
					postFixString += stack.pop();
				stack.push(ch);
			}	
			else if(ch == ')' || ch == ']' || ch == '}'){
				countRight++;
				while(!stack.isEmpty()){
					if(stack.peek() != '(' || stack.peek() != '[' || stack.peek() != '{')
						if(stack.peek() == '(' || stack.peek() == '[' || stack.peek() == '{')
							stack.pop();
						else
							postFixString += stack.pop();
					else
						System.out.println("Expression not valid");
				}
			}
			else
				System.err.println("Invalid Expression");
				
		}
		while (!stack.isEmpty()){
			if(stack.peek() != '(' || stack.peek() != '[' || stack.peek() != '{')
		        postFixString += stack.pop();
		}
		
		if(countRight > countLeft || countRight < countLeft || countOperand <= countOperator){
			toString();
			System.exit(0);
		}
		
		return postFixString;
	}
	
	
	public String toString(){
		String str = "";
		for(int i = 0; i < infix_2.length; i++){
			str += infix_2[i];
		}
		return "Expression is not valid\nCan not convert" + str + " to postfix";
	}
	
	public static int Prec(char ch){
		int val = -1;
		switch (ch)
	    {
	    case '+':
	    case '-':
	        val = 1;
	 
	    case '*':
	    case '/':
	        val = 2;
	    }
		return val;
	}
	
	public static void main(String[] args) throws Exception{
		char[] infix = "((BO)(XK)(DQ)(CP)(NA)(GT)(RE)(TG)(QD)(FS)(JW)(HU)(VI)(AN)(OB)(ER)(FS)(LY)(PC)(ZM))".toCharArray();
		InfixToPostfixConverter converts = new InfixToPostfixConverter();
		System.out.println(converts.convert(infix));
	}
}
