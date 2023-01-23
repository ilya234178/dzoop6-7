package org.example.Note.view;


import org.example.Note.controllers.UserController;
import org.example.Note.model.User;

import java.util.List;
import java.util.Scanner;

import static com.sun.tools.javac.resources.CompilerProperties.Notes.Note;

public class ViewUser {
    private UserController userController;

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command.toUpperCase());
            if (com == Commands.EXIT) return;
            try {
                switch (com) {
                    case CREATE:
                        String id = prompt("Введите Id: ");
                        String heading = prompt("Введите заголовок: ");
                        String text = prompt("Введите текст: ");
                        userController.saveUser(new User(id, heading, text));
                        break;
                    case READ:
                        id = prompt("Идентификатор пользователя: ");
                        User user = userController.readUser(id);
                        heading = prompt("Заголовок: ");
                        text = prompt("Текст: ");
                        System.out.println(user);
                        break;
                    case LIST:
                        List<User> lst = userController.readList();
                        lst.forEach(i -> System.out.println(i + "\n"));
                        break;
                    case UPDATE:
                        String numId = prompt("Какой индификатор редактировать? Введите номер ID: ");
                        userController.idPresenceValidation(numId);
                        userController.updUser(numId, createAGuy());
                        break;
                    case DELETE:
                        String delId = prompt("Какой ID удалить?");
                        userController.deleteByID(delId);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Oopsie!\n" + e.getMessage());
            }
        }
    }
    //

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private User createAGuy() {
        String id = prompt("Id: ");
        String heading = prompt("Заголовок: ");
        String text = prompt("Текст: ");
        User newGuy = new User(id, heading, text);
        return newGuy;
    }
}
