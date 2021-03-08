package org.example.application.model.dao.impl;

import org.example.application.model.Field;
import org.example.application.model.dao.DAO;
import org.example.application.model.entity.LocalFile;
import org.example.application.model.parser.impl.ExtensionParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocDAO implements DAO<LocalFile> {
    public static DocDAO instance;

    private DocDAO(){}

    public static DocDAO getInstance(){
        if(instance == null){
            instance = new DocDAO();
        }

        return instance;
    }

    @Override
    public List<LocalFile> read() throws IOException {
        ExtensionParser parser = ExtensionParser.getInstance();
        List<LocalFile> docs = new ArrayList<>();
        File[] listOfFiles = Field.getFiles();
        for(File file:listOfFiles){
            LocalFile localFile = parser.parse(file);
            if(localFile.getFolder() != null && file.isFile() && localFile.getFolder().equals("doc")){
                docs.add(localFile);
            }
        }

        return docs;
    }
}