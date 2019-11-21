package com.eranis;

public enum Operation {
  ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, UNKNOWN;

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
      return Operation.UNKNOWN;
    }
  }
}
