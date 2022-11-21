package prac22;

abstract class Controller {
    private static Model modelInstance = Model.getInstance();
    public static void addSignOrNumberToRuntimeStack(String el){
        try{
            modelInstance.addNumberToStack(Integer.parseInt(el));
        } catch (RuntimeException e){
            modelInstance.addSignToStack(el);
        }
    }
    public static void calculateResult(){
        modelInstance.calculateResult();
    }
}