package org.example.application.model.entity;

import java.io.File;
import java.util.Objects;

public class LocalFile {
    private String folder;
    private File fullName;

    public LocalFile(){}

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public File getFullName() {
        return fullName;
    }

    public void setFullName(File fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalFile file = (LocalFile) o;
        return Objects.equals(folder, file.folder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(folder);
    }

    @Override
    public String toString() {
        return "LocalFile{" +
                "folder='" + folder + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
