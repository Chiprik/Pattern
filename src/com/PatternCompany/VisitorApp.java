package com.PatternCompany;

public class VisitorApp {
    public static void main(String[] args) {
        Element body = new BodyElement();
        Element engine = new EngineElement();
        Visitor mechanic = new MechanicVisitor();

        body.accept(mechanic);
        engine.accept(mechanic);
    }
}

//Посетитель (Visitor)

interface Visitor {
    void visit(EngineElement engine);

    void visit(BodyElement body);
}

//Элемент - Автозапчасть

interface Element {
    void accept(Visitor visitor);
}

//Кузов

class BodyElement implements Element {
    public void accept (Visitor visitor) {
        visitor.visit(this);
    }
}

//Двигатель

class EngineElement implements Element{
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor{
    public void visit(EngineElement element){
        System.out.println("Завел двигатель");
    }
    public void visit(BodyElement body){
        System.out.println("Постучал по корпусу");
    }
}

class MechanicVisitor implements Visitor{
    public void visit(EngineElement element){
        System.out.println("Провери двигатель");
    }
    public void visit(BodyElement body){
        System.out.println("Отполировал кузов");
    }
}
