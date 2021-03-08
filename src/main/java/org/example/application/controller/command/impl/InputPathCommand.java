package org.example.application.controller.command.impl;

import org.example.application.controller.command.Command;
import org.example.application.model.Field;
import org.example.application.model.dao.DAO;

import java.util.Scanner;

public class InputPathCommand implements Command {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите путь:");
        String path = sc.nextLine();
        Field.directoryPath = path;
    }
}
