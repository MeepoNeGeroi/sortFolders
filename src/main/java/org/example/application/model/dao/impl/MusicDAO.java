package org.example.application.model.dao.impl;

import org.example.application.model.Field;
import org.example.application.model.dao.DAO;
import org.example.application.model.entity.LocalFile;
import org.example.application.model.parser.impl.ExtensionParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MusicDAO implements DAO<LocalFile> {
    public static MusicDAO instance;

    private MusicDAO(){}

    public static MusicDAO getInstance(){
        if(instance == null){
            instance = new MusicDAO();
        }

        return instance;
    }

    @Override
    public List<LocalFile> read() throws IOException {
        List<LocalFile> music = new ArrayList<>();
        ExtensionParser parser = ExtensionParser.getInstance();
        File[] listOfFiles = Field.getFiles();
        for(File file:listOfFiles){
            LocalFile localFile = parser.parse(file);
            if(localFile.getFolder() != null && file.isFile() && localFile.getFolder().equals("music")){
                music.add(localFile);
            }
        }

        return music;
    }
}
