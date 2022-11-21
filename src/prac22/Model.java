package prac22;

import java.util.Stack;

public class Model {
    private Stack<Integer> calculatorState = new Stack<Integer>();
    private float result = 0;
    private static Model instance = new Model();
    private Model(){

    }
    public static Model getInstance(){
        return instance;
    }
    public void addNumberToStack(int number){
        calculatorState.push(number);
    }
    public void addSignToStack(String sign){
        int[] operationElements = {calculatorState.pop(), calculatorState.pop()};
        switch (sign) {
            case "+":
                calculatorState.push(operationElements[0] + operationElements[1]);
                break;
            case "-":
                calculatorState.push(operationElements[1] - operationElements[0]);
                break;
            case "*":
                calculatorState.push(operationElements[0] * operationElements[1]);
                break;
            case "/":
                calculatorState.push(operationElements[1] / operationElements[0]);
                break;
            default:
                break;
        }
    }
    public void calculateResult(){
        instance.result = (float)calculatorState.get(0);
    }
    public String getResult(){
        return Float.toString(this.result);
    }
}
