package org.example.application.model;

import org.example.application.model.entity.LocalFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Field {
    public static String propertyPath = "src/main/java/org/example/application/model/property/extension";
    public static String directoryPath = "/Users/zaher/Desktop";
    public static File[] getFiles(){
        File folder = new File(directoryPath);
        List<LocalFile> docs = new ArrayList<>();
        File[] listOfFiles = folder.listFiles();

        return listOfFiles;
    }

}
