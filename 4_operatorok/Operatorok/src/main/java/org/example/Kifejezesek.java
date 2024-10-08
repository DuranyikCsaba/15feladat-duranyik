package org.example;

public class Kifejezesek {
    private int operandus1;
    private String operator;
    private int operandus2;


    public Kifejezesek(int operandus1, String operator, int operandus2) {
        this.operandus1 = operandus1;
        this.operator = operator;
        this.operandus2 = operandus2;
    }

    public Kifejezesek(String[] adatok){

        this.operandus1 = Integer.parseInt(adatok[0]);
        this.operator = adatok[1];
        this.operandus2 = Integer.parseInt(adatok[2]);
    }

    public int getOperandus1() {
        return operandus1;
    }

    public void setOperandus1(int operandus1) {
        this.operandus1 = operandus1;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getOperandus2() {
        return operandus2;
    }

    public void setOperandus2(int operandus2) {
        this.operandus2 = operandus2;
    }
}
