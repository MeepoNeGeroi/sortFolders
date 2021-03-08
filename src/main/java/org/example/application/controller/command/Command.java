package org.example.application.controller.command;

import java.io.IOException;

public interface Command {
    void execute() throws IOException;
}
