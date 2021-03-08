package org.example.application.controller;

import org.example.application.controller.command.Command;
import org.example.application.controller.command.impl.MainCommand;
import org.example.application.model.dao.impl.DocDAO;
import org.example.application.model.dao.impl.ImageDAO;
import org.example.application.model.dao.impl.MusicDAO;
import org.example.application.model.dao.impl.UnknownFileDAO;
import org.example.application.model.service.SortService;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        Command main = new MainCommand();
        main.execute();
    }
}
