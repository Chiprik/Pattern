package com.PatternCompany;

public class DelegateAppMy {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setCount(new Sum());
        calculator.count();

        calculator.setCount(new Difference());
        calculator.count();

        calculator.setCount(new Multiplication());
        calculator.count();
    }
}

interface Count{
    default void count(){

    }
}

class Sum implements Count{
    public void count(){
        System.out.println("Суммируем");
    }
}
class Difference implements Count{
    public void count(){
        System.out.println("Вычитаем");
    }
}

class Multiplication implements Count{
    public void count(){
        System.out.println("Умножаем");
    }
}

class Calculator{
    Count count;
    void setCount(Count c){
        count = c;
    }
    void count(){
        count.count();
    }

}
