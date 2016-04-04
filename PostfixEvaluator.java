/*
 * Name: Joel Quainoo
 * CSE_214 Homework 2;
 */
public class PostfixEvaluator {
	Stacks<Double> operand = new Stacks<>();
	@SuppressWarnings("unused")
	/**
	 * evaluate(char[] postfix)
	 * Mathod evaluates a postfix expression.
	 * @param postfix
	 * @return int
	 */
	public int evaluate(char[] postfix){
		Character ch; double sum = 0; double value1, value2;
		for(int i = 0; i < postfix.length; ++i){
			ch = postfix[i];
			if(Character.isDigit(ch))
				operand.push((double)Character.getNumericValue(ch));
	
			else if(Character.isLetter(ch))
				operand.push((double)Character.valueOf(ch));
			
			else{
				value1 = (double)operand.pop();
				value2 = (double)operand.pop();
				switch(ch) {
				case '*':
					operand.push(value1 * value2);
					break;
				case '+':
					operand.push(value1 + value2);
					break;
				case '-':
					operand.push(value2 - value1);
					break;
				case '/':
					operand.push(value2 / value1);
					break;
				}
			}
		}
		return ((int)(sum = operand.pop()));
	}

	public static void main(String[] args) {
		PostfixEvaluator evaluate = new PostfixEvaluator();
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("Enter a postfix expression to evaluate: ");
		char[] postfix = input.nextLine().toCharArray();
		System.out.println("Evaluated postfix expression = "+evaluate.evaluate(postfix));
		input.close();
	}

}
