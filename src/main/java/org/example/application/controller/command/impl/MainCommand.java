package org.example.application.controller.command.impl;

import org.example.application.controller.command.Command;
import org.example.application.model.service.SortService;
import org.example.application.view.UI;

import java.io.IOException;
import java.util.Scanner;

public class MainCommand implements Command {
    private Scanner sc = new Scanner(System.in);
    private UI ui = new UI();
    private InputPathCommand ip = new InputPathCommand();
    private ExitCommand exit = new ExitCommand();
    SortService sortService = new SortService();

    @Override
    public void execute() throws IOException {
        int choise;
        do{
            ui.chooseOption();
            choise = sc.nextInt();
            if (choise == 1) {
                ip.execute();
                sortService.sort();
            }
            if (choise == 0) {
                exit.execute();
            }
        }
        while (choise != 0);
    }
}