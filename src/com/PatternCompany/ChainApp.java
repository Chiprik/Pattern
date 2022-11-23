package com.PatternCompany;

public class ChainApp {
    public static void main(String[] args) {
        Logger logger0 = new SMSLogger(Level1.ERROR);
        Logger logger1 = new FileLogger(Level1.DEBUG);
        logger0.setNext(logger1);
        Logger logger2 = new EmailLogger(Level1.INFO);
        logger1.setNext(logger2);

        logger0.writeMassage("Все хорошо", Level1.INFO);
        logger0.writeMassage("Идет отладка", Level1.DEBUG);
        logger0.writeMassage("Система упала", Level1.ERROR);
    }
}

class Level1 {
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

abstract class Logger {
    int priority;

    public Logger(int priority) {
        this.priority = priority;
    }

    Logger next;

    public void setNext(Logger next) {
        this.next = next;
    }

    abstract void write(String massage);

    public void writeMassage(String massage, int level) {
        if (level <= priority) {
            write(massage);
        }
        if (next != null) {
            next.writeMassage(massage, level);
        }
    }

}

class SMSLogger extends Logger {
    public SMSLogger(int priority) {
        super(priority);
    }

    public void write(String massage) {
        System.out.println("СМС: " + massage);
    }
}

class FileLogger extends Logger {
    public FileLogger(int priority) {
        super(priority);
    }

    public void write(String massage) {
        System.out.println("Записываем в файл: " + massage);
    }
}

class EmailLogger extends Logger {
    public EmailLogger(int priority) {
        super(priority);
    }

    public void write(String massage) {
        System.out.println("E-mail сообщение: " + massage);
    }
}