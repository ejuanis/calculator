package com.eranis.calculator;

public class Equation {
  private Equation left;
  private Equation right;
  private Operation operation;
  private double value;

  public Equation() {
  }

  public Equation(Equation left) {
    this.left = left;
  }

  public Equation getLeft() {
    return this.left;
  }

  public void setLeft(final Equation left) {
    this.left = left;
  }

  public Equation getRight() {
    return this.right;
  }

  public void setRight(final Equation right) {
    this.right = right;
  }

  public Operation getOperation() {
    return this.operation;
  }

  public void setOperation(final Operation operation) {
    this.operation = operation;
  }

  public double getValue() {
    return this.value;
  }

  public void setValue(final double value) {
    this.value = value;
  }

  public Equation getHead() {
    return getLeft() == null ? this : getLeft().getHead();
  }
}
