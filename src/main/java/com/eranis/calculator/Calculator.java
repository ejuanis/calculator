package com.eranis.calculator;

/**
 * A string calculator
 */
public class Calculator {

  /**
   * Evaluate given input of mathematical equation. The value number and operator are separated by SPACE.
   *
   * @param expression
   * @return Result in Type: double
   *
   * @throws CalculatorException
   */
  public static double calculate(String expression) {
    StringBuilder sb = new StringBuilder(expression);

    Parentheses parentheses = findFirstParenthesesPair(expression);

    if (parentheses.hasIncompleteParentheses) {
      throw new CalculatorException("Found bracket without pair");
    }

    if (parentheses.hasParentheses) {
      String subExpression = sb.substring(parentheses.start + 1, parentheses.end);
      double result = calculate(subExpression.trim());

      String value = Double.toString(result);
      expression = sb.replace(parentheses.start, parentheses.end + 1, value).toString();

      return calculate(expression);

    } else {
      final String[] values = expression.split(" ");

      Equation equation = buildEquation(values);

      return evaluate(equation);
    }
  }

  private static Parentheses findFirstParenthesesPair(String expression) {
    int start = expression.lastIndexOf("(");
    int end = expression.indexOf(")", start);

    return new Parentheses(start, end);
  }

  private static Equation buildEquation(String[] values) {
    Equation equation = new Equation();
    for (int i = 0; i < values.length; i++) {
      if ((i % 2) == 0) {
        equation.setValue(Double.parseDouble(values[i]));
      } else {
        Operation operation = Operation.parse(values[i]);
        equation.setOperation(operation);

        Equation tail = new Equation();
        tail.setLeft(equation);

        equation.setRight(tail);
        equation = tail;
      }
    }

    return equation;
  }

  private static double evaluate(Equation equation) {
    if (equation.getLeft() == null && equation.getRight() == null) {
      return equation.getValue();
    }

    Equation head = equation.getHead();
    Equation cursor = head.getRight();

    if (cursor.getOperation() != null && cursor.getOperation().isGreater(head.getOperation())) {
      double result = evaluateAtCurrentCursor(cursor);

      Equation tail = cursor.getRight();
      tail.setValue(result);
      tail.setLeft(cursor.getLeft());
      cursor.getLeft().setRight(tail);

      return evaluate(tail);

    } else {
      double result = evaluateAtCurrentCursor(head);

      Equation now = head.getRight();
      now.setLeft(head.getLeft() != null ? head.getLeft().getLeft() : null);
      now.setValue(result);

      return evaluate(now);
    }
  }

  private static double evaluateAtCurrentCursor(Equation cursor) {
    double a = cursor.getValue();
    double b = cursor.getRight().getValue();
    Operation operation = cursor.getOperation();

    return calculate(operation, a, b);
  }

  private static double calculate(Operation operation, double a, double b) {
    double result = Double.NaN;

    switch (operation) {
      case ADDITION:
        result = a + b;
        break;

      case SUBTRACTION:
        result = a - b;
        break;

      case MULTIPLICATION:
        result = a * b;
        break;

      case DIVISION:
        result = a / b;
        break;
    }

    return result;
  }

  static class Parentheses {
    private final int start;
    private final int end;
    private final boolean hasParentheses;
    private final boolean hasIncompleteParentheses;

    public Parentheses(int start, int end) {
      this.start = start;
      this.end = end;
      hasParentheses = start >= 0 || end > 0;
      hasIncompleteParentheses = (start >= 0 && end < 0) || (start < 0 && end > 0);
    }
  }
}
