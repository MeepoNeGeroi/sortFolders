package org.example.application.model.dao.impl;

import org.example.application.model.Field;
import org.example.application.model.dao.DAO;
import org.example.application.model.entity.LocalFile;
import org.example.application.model.parser.impl.ExtensionParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageDAO implements DAO<LocalFile> {
    public static ImageDAO instance;

    private ImageDAO(){}

    public static ImageDAO getInstance(){
        if(instance == null){
            instance = new ImageDAO();
        }

        return instance;
    }

    @Override
    public List<LocalFile> read() throws IOException {
        List<LocalFile> images = new ArrayList<>();
        ExtensionParser parser = ExtensionParser.getInstance();
        File[] listOfFiles = Field.getFiles();
        for(File file:listOfFiles){
            LocalFile localFile = parser.parse(file);
            if(localFile.getFolder() != null && file.isFile() && localFile.getFolder().equals("image")){
                images.add(localFile);
            }
        }

        return images;
    }
}
