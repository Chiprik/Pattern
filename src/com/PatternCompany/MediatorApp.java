package com.PatternCompany;

import java.util.ArrayList;
import java.util.List;

public class MediatorApp {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        UserMed admin = new Admin(chat);
        UserMed u1 = new SimpleUser(chat);
        UserMed u2 = new SimpleUser(chat);

        chat.setAdmin(admin);
        chat.addUser(u1);
        chat.addUser(u2);

        u1.sendMassage("Привет, я пользователь.");
        admin.sendMassage("АДМИН зашел в чат!!!");
    }
}

interface UserMed {
    void sendMassage(String massage);

    void getMassage(String massage);
}

class Admin implements UserMed {
    Chat chat;

    public Admin(Chat chat) {
        this.chat = chat;
    }

    public void sendMassage(String massage) {
        chat.sendMessage(massage, this);
    }

    public void getMassage(String massage) {
        System.out.println("Администрация получает сообщение '" + massage + "'");
    }
}

class SimpleUser implements UserMed {
    Chat chat;

    public SimpleUser(Chat chat) {
        this.chat = chat;
    }

    public void sendMassage(String massage) {
        chat.sendMessage(massage, this);
    }

    public void getMassage(String massage) {
        System.out.println("Пользователь получает сообщение '" + massage + "'");
    }
}

interface Chat {
    void sendMessage(String message, UserMed user);
}

class TextChat implements Chat {
    UserMed admin;
    List<UserMed> users = new ArrayList<>();

    public void setAdmin(UserMed admin) {
        this.admin = admin;
    }

    public void addUser(UserMed u) {
        users.add(u);
    }

    public void sendMessage(String message, UserMed user) {
        for (UserMed u : users) {
            u.getMassage(message);
        }
        admin.getMassage(message);
    }
}