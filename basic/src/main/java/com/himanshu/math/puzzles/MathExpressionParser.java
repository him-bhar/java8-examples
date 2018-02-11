package com.himanshu.math.puzzles;

import java.util.Stack;

/**
 * @implNote http://www.geeksforgeeks.org/expression-evaluation/
 * <p>
 * 1. While there are still tokens to be read in,
 * 1.1 Get the next token.
 * 1.2 If the token is:
 * 1.2.1 A number: push it onto the value stack.
 * 1.2.2 A variable: get its value, and push onto the value stack.
 * 1.2.3 A left parenthesis: push it onto the operator stack.
 * 1.2.4 A right parenthesis:
 * 1 While the thing on top of the operator stack is not a
 * left parenthesis,
 * 1 Pop the operator from the operator stack.
 * 2 Pop the value stack twice, getting two operands.
 * 3 Apply the operator to the operands, in the correct order.
 * 4 Push the result onto the value stack.
 * 2 Pop the left parenthesis from the operator stack, and discard it.
 * 1.2.5 An operator (call it thisOp):
 * 1 While the operator stack is not empty, and the top thing on the
 * operator stack has the same or greater precedence as thisOp,
 * 1 Pop the operator from the operator stack.
 * 2 Pop the value stack twice, getting two operands.
 * 3 Apply the operator to the operands, in the correct order.
 * 4 Push the result onto the value stack.
 * 2 Push thisOp onto the operator stack.
 * 2. While the operator stack is not empty,
 * 1 Pop the operator from the operator stack.
 * 2 Pop the value stack twice, getting two operands.
 * 3 Apply the operator to the operands, in the correct order.
 * 4 Push the result onto the value stack.
 * 3. At this point the operator stack should be empty, and the value
 * stack should have only one value in it, which is the final result.
 */
public class MathExpressionParser {
  private int evaluateExpression(String expression) {
    char[] tokens = expression.toCharArray();
    Stack<Integer> values = new Stack<>();
    Stack<Character> ops = new Stack<>();

    for(int i=0;i<tokens.length;i++) {
      if (tokens[i] == ' ') {
        continue;
      }
      if (isNumber(tokens[i])) {
        //values.push(Integer.parseInt(parseNumber(tokens[i])));
        StringBuilder sb = new StringBuilder();

        while (i < tokens.length && isNumber(tokens[i])) {
          sb.append(tokens[i++]);
          if (i == tokens.length) {
            break;
          }
        }
        i--; //Removing the last wrong increment in while loop
        values.push(Integer.parseInt(sb.toString()));
      } else if(isOpeningBrace(tokens[i])) {
        ops.push(tokens[i]);
      } else if (isClosingBraces(tokens[i])) {
        //If it is closing braces, we need to calculate the value till we don't get a opening brace.
        // So pop one operator and 2 values from stack and calculate the result.
        while (!isOpeningBrace(ops.peek())) {
          int operand2 = values.pop();
          int operand1 = values.pop();
          char operator = ops.pop();
          //push the result on top of stack
          values.push(performOperation(operand1, operand2, operator));
        }
        ops.pop();
      } else if(isOperator(tokens[i])) {
        // While top of 'ops' has same or greater precedence to current
        // token, which is an operator. Apply operator on top of 'ops'
        // to top two elements in values stack
        while (!ops.isEmpty() && hasPrecedence(tokens[i], ops.peek())) {
          values.push(performOperation(values.pop(), values.pop(), ops.pop()));
        }
        ops.push(tokens[i]);
      }
    }
    // Entire expression has been parsed at this point, apply remaining
    // ops to remaining values
    while (!ops.empty()) {
      int operand2 = values.pop();
      int operand1 = values.pop();
      values.push(performOperation(operand1, operand2, ops.pop()));
    }

    // Top of 'values' contains result, return it
    return values.pop();
  }

  // Returns true if 'operatorFromStack' has higher or same precedence as 'operatorToken',
  // otherwise returns false.
  private boolean hasPrecedence(char operatorToken, char operatorFromStack) {
    if (operatorFromStack == '(' || operatorFromStack == ')') {
      return false;
    } else if ((operatorToken == '*' || operatorToken == '/') && (operatorFromStack == '+' || operatorFromStack == '-')) {
      return false;
    } else {
      return true;
    }
  }


  private boolean isOperator(char token) {
    return (token == '+' || token == '-' || token == '*' || token == '/');
  }

  private boolean isClosingBraces(char token) {
    return token == ')';
  }

  private boolean isOpeningBrace(char token) {
    return token == '(';
  }

  private boolean isNumber(char token) {
    return (token >= '0') && (token <= '9');
  }

  private Integer performOperation(int operand1, int operand2, char operator) {
    if(operator == '+') {
      return operand1+operand2;
    } else if(operator == '-') {
      return operand1-operand2;
    } else if(operator == '*') {
      return operand1*operand2;
    } else if(operator == '/') {
      return operand1/operand2;
    }
    throw new RuntimeException("Invalid  operator found: "+operator);
  }

  // Driver method to test above methods
  public static void main(String[] args) {
    System.out.println(new MathExpressionParser().evaluateExpression("10 + 2 * 6"));
    System.out.println(new MathExpressionParser().evaluateExpression("100 * 2 + 12"));
    System.out.println(new MathExpressionParser().evaluateExpression("100 * ( 2 + 12 )"));
    System.out.println(new MathExpressionParser().evaluateExpression("100 * ( 2 + 12 ) / 14"));
  }
}
