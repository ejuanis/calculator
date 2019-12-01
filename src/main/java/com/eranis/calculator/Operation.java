package com.eranis.calculator;

public enum Operation {

  MULTIPLICATION(4), DIVISION(4), ADDITION(1), SUBTRACTION(1), NONE(0);

  private int priority;

  Operation(int priority) {
    this.priority = priority;
  }

  public static Operation parse(String operator) {
    if ("+".equals(operator)) {
      return Operation.ADDITION;
    } else if ("-".equals(operator)) {
      return Operation.SUBTRACTION;
    } else if ("*".equals(operator)) {
      return Operation.MULTIPLICATION;
    } else if ("/".equals(operator)) {
      return Operation.DIVISION;
    } else {
      return Operation.NONE;
    }
  }

  public boolean isGreater(Operation nextOperation) {
    return nextOperation == null ? false : priority > nextOperation.priority;
  }
}
