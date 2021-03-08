package org.example.application.model.parser.impl;

import org.example.application.model.Field;
import org.example.application.model.entity.LocalFile;
import org.example.application.model.parser.Parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExtensionParser implements Parser<LocalFile> {
    public static ExtensionParser instance;

    private ExtensionParser(){}

    public static ExtensionParser getInstance(){
        if(instance == null){
            instance = new ExtensionParser();
        }
        return instance;
    }
    @Override
    public LocalFile parse(File file) throws IOException {
        FileInputStream in = new FileInputStream(Field.propertyPath);
        Properties ex = new Properties();
        ex.load(in);
        LocalFile localFile = new LocalFile();
        String fullFileName = file.getName();
        String[] wordsByDot = fullFileName.split("\\.");
        String extension = wordsByDot[wordsByDot.length - 1];
        localFile.setFullName(file);
        localFile.setFolder(ex.getProperty(extension));

        return localFile;
    }
}