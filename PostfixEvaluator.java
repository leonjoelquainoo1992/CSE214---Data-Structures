

/**
 * @author leonjoel
 *
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

	public static void main(String[] args) throws Exception {
		InfixToPostfixConverter fix = new InfixToPostfixConverter();
		java.util.Scanner input = new java.util.Scanner(System.in);
		String in;
		do{
			System.out.print("Enter an infix expression to evaluate <Enter 'q' to quit: ");
			in = input.nextLine();
			if(in.equalsIgnoreCase("Q")){
				System.exit(0);
			}
			else{
			char[] infix = "((B O)(X K)(D Q)(C P)(N A)(G T)(R E)(T G)(Q D)(F S)(J W)(H U)(V I)(A N)(O B)(E R)(F S)(L Y)(P C)(Z M))".toCharArray();
			String postfix = fix.convert(infix);
			System.out.println("Post-fix from infix is "+ postfix);
			//System.out.println("Evaluated postfix expression = "+ evaluate.evaluate(postfix.toCharArray()));
			}
		}
		while(!in.equalsIgnoreCase("q") || !in.equalsIgnoreCase("Q"));
		input.close();
	}

}
