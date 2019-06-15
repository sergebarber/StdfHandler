package org.barber.stdfhandler;

import org.barber.stdfhandler.file.FileImage;
import org.barber.stdfhandler.file.FileHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Reader {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("test.std");
        FileHandler reader = FileHandler.newInstance();
        FileImage image = reader.read(inputStream);
        System.out.println(image);

    }
}
