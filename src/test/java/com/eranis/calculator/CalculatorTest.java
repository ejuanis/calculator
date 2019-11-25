package com.eranis.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

  @Test
  public void addTwoNumberTest() {
    double expected = 1 + 1;
    double result = Calculator.calculate("1 + 1");

    assertEquals("Adding two numbers should return the correct value", expected, result, 0);
  }

  @Test
  public void multiplyTwoNumberTest() {
    double expected = 2 * 2;
    double result = Calculator.calculate("2 * 2");

    assertEquals("Multiplying two numbers should return the correct value", expected, result, 0);
  }

  @Test
  public void addingThreeNumberTest() {
    double expected = 1 + 2 + 3;
    double result = Calculator.calculate("1 + 2 + 3");

    assertEquals("Adding 3 numbers should return the correct value", expected, result, 0);
  }

  @Test
  public void divisionTest() {
    double expected = 6 / 2;
    double result = Calculator.calculate("6 / 2");

    assertEquals("Division of 2 numbers should return the correct value", expected, result, 0);
  }

  @Test
  public void addTwoBiggerNumberTest() {
    double expected = 11 + 23;
    double result = Calculator.calculate("11 + 23");

    assertEquals("Adding two bigger numbers should return the correct value", expected, result, 0);
  }

  @Test
  public void addDecimalAndIntegerNumberTest() {
    double expected = 11.1 + 23;
    double result = Calculator.calculate("11.1 + 23");

    assertEquals("Adding a decimal and integer should return the correct value", expected, result, 0);
  }

  @Test
  public void multiplyThenAdditionTest() {
    double expected = 1 + 1 * 3;
    double result = Calculator.calculate("1 + 1 * 3");

    assertEquals("Multiply two numbers then add should return the correct value", expected, result, 0);
  }

  @Test
  public void additionWithBracketTest() {
    double expected = (11.5 + 15.4) + 10.1;
    double result = Calculator.calculate("( 11.5 + 15.4 ) + 10.1");

    assertEquals("Adding 3 numbers with bracket should return the correct value", expected, result, 0);
  }

  @Test
  public void subtractionWithBracketTest() {
    double expected = 23 - (29.3 - 12.5);
    double result = Calculator.calculate("23 - ( 29.3 - 12.5 )");

    assertEquals("Subtraction 3 numbers with bracket should return the correct value", expected, result, 0);
  }

  @Test
  public void subtractionThenMultiplyThenAddThenSubtractWithBracketTest() {
    double expected = 10 - (2 + 3 * (7 - 5));
    double result = Calculator.calculate("10 - ( 2 + 3 * ( 7 - 5 ) )");

    assertEquals("Subtract then multiply then add then subtract with bracket should return the correct value", expected, result, 0);
  }

}