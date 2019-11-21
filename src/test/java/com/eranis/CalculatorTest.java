package com.eranis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

  @Test
  public void addTwoNumberTest() {
    double result = Calculator.calculate("1 + 1");
    assertEquals("Adding two numbers should return the correct value", 2, result, 0);
  }

  @Test
  public void multiplyTwoNumberTest() {
    double result = Calculator.calculate("2 * 2");
    assertEquals("Multiplying two numbers should return the correct value", 4, result, 0);
  }

  @Test
  public void addingThreeNumberTest() {
    double result = Calculator.calculate("1 + 2 + 3");
    assertEquals("Adding 3 numbers should return the correct value", 6, result, 0);
  }

  @Test
  public void divisionTest() {
    double result = Calculator.calculate("6 / 2");
    assertEquals("Division of 2 numbers should return the correct value", 3, result, 0);
  }

  @Test
  public void addTwoBiggerNumberTest() {
    double result = Calculator.calculate("11 + 23");
    assertEquals("Adding two bigger numbers should return the correct value", 2, result, 0);
  }

  @Test
  public void addDecimalAndIntegerNumberTest() {
    double result = Calculator.calculate("11.1 + 23");
    assertEquals("Adding a decimal and integer should return the correct value", 34.1, result, 0);
  }

  @Test
  public void multiplyThenAdditionTest() {
    double result = Calculator.calculate("1 + 1 * 3");
    assertEquals("Multiply two numbers then add should return the correct value", 2, result, 0);
  }

  @Test
  public void additionWithBracketTest() {
    double result = Calculator.calculate("( 11.5 + 15.4 ) + 10.1");
    assertEquals("Adding 3 numbers with bracket should return the correct value", 37, result, 0);
  }

  @Test
  public void subtractionWithBracketTest() {
    double result = Calculator.calculate("23 - ( 29.3 - 12.5 )");
    assertEquals("Subtraction 3 numbers with bracket should return the correct value", 6.2, result, 0);
  }

  @Test
  public void subtractionThenMultiplyThenAddThenSubtractWithBracketTest() {
    double result = Calculator.calculate("10 - ( 2 + 3 * ( 7 - 5 ) )");
    assertEquals("Subtract then multiply then add then subtract with bracket should return the correct value", 2, result, 0);
  }

}