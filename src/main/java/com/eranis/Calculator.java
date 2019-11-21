package com.eranis;

public class Calculator {

  public static double calculate(String expression) {

    String[] values = expression.split(" ");
    Operation operator = Operation.parse(values[1]);
    double result = Double.NaN;

    switch (operator) {
      case ADDITION:
        result = Double.parseDouble(values[0]) + Double.parseDouble(values[2]);
        break;

      case SUBTRACTION:
        result = Double.parseDouble(values[0]) - Double.parseDouble(values[2]);
        break;

      case MULTIPLICATION:
        result = Double.parseDouble(values[0]) * Double.parseDouble(values[2]);
        break;

      case DIVISION:
        result = Double.parseDouble(values[0]) / Double.parseDouble(values[2]);
        break;
    }

    return result;
  }

}
