package com.app.models;

public class CalcModel {
  private int a;
  private int b;
  private String operation;
  private int result;
  private String message;

  public CalcModel() {
  }

  public CalcModel(int a, int b, String operation) {
    this.a = a;
    this.b = b;
    this.operation = operation;
  }

  public int getA() {
    return a;
  }

  public void setA(int a) {
    this.a = a;
  }

  public int getB() {
    return b;
  }

  public void setB(int b) {
    this.b = b;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "CalcModel{" +
        "a=" + a +
        ", b=" + b +
        ", operation='" + operation + '\'' +
        ", result=" + result +
        ", message='" + message + '\'' +
        '}';
  }
}