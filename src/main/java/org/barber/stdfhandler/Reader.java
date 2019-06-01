package org.barber.stdfhandler;

import org.barber.stdfhandler.file.FileImage;
import org.barber.stdfhandler.file.FileReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Reader {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("test.std");
        FileReader reader = new FileReader();
        FileImage image = reader.read(inputStream);
        System.out.println(image);

    }
}
