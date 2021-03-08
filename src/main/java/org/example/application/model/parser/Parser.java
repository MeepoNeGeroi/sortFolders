package org.example.application.model.parser;


import java.io.File;
import java.io.IOException;

public interface Parser<T> {
    T parse(File file) throws IOException;
}
