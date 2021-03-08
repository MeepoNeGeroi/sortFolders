package org.example.application.model.dao.impl;

import org.example.application.model.Field;
import org.example.application.model.dao.DAO;
import org.example.application.model.entity.LocalFile;
import org.example.application.model.parser.impl.ExtensionParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UnknownFileDAO implements DAO<LocalFile> {
    public static UnknownFileDAO instance;

    private UnknownFileDAO(){}

    public static UnknownFileDAO getInstance(){
        if(instance == null){
            instance = new UnknownFileDAO();
        }

        return instance;
    }

    @Override
    public List<LocalFile> read() throws IOException {
        List<LocalFile> unknowns = new ArrayList<>();
        ExtensionParser parser = ExtensionParser.getInstance();
        File[] listOfFiles = Field.getFiles();
        for(File file:listOfFiles){
            LocalFile localFile = parser.parse(file);
            if(localFile.getFolder() == null && !localFile.getFullName().isDirectory()){
                unknowns.add(localFile);
            }
        }

        return unknowns;
    }
}
