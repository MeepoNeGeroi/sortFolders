package org.example.application.controller.command.impl;

import org.example.application.controller.command.Command;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("До пабачення)");
    }
}
