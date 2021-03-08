package org.example.application.model.service;

import org.example.application.model.Field;
import org.example.application.model.dao.impl.DocDAO;
import org.example.application.model.dao.impl.ImageDAO;
import org.example.application.model.dao.impl.MusicDAO;
import org.example.application.model.dao.impl.UnknownFileDAO;
import org.example.application.model.entity.LocalFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.util.List;

public class SortService {
    public void sort() throws IOException {
        List<LocalFile> docs = DocDAO.getInstance().read();
        List<LocalFile> images = ImageDAO.getInstance().read();
        List<LocalFile> music = MusicDAO.getInstance().read();
        List<LocalFile> unknowns = UnknownFileDAO.getInstance().read();

        if(docs.size() > 1){
            new File(Field.directoryPath + "/docs").mkdirs();
            for(LocalFile doc : docs){
                moveToDir(doc.getFullName(), new File(Field.directoryPath + "/docs"));
            }
        }
        if(images.size() > 1){
            new File(Field.directoryPath + "/images").mkdirs();
            for(LocalFile image : images){
                moveToDir(image.getFullName(), new File(Field.directoryPath + "/images"));
            }
        }
        if(music.size() > 1){
            new File(Field.directoryPath + "/music").mkdirs();
            for(LocalFile m : music){
                moveToDir(m.getFullName(), new File(Field.directoryPath + "/music"));
            }
        }
        if(unknowns.size() > 1){
            new File(Field.directoryPath + "/unknowns").mkdirs();
            for(LocalFile unknown : unknowns){
                moveToDir(unknown.getFullName(), new File(Field.directoryPath + "/unknowns"));
            }
        }
    }

    private void moveToDir(File fileToMove, File dir) throws FileSystemException {
        boolean isMoved = fileToMove.renameTo(new File(dir, fileToMove.getName()));
//        if (!isMoved) {
//            throw new FileSystemException("fail!");
//        }
    }
}
