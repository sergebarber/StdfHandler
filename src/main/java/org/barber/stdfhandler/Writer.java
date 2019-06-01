package org.barber.stdfhandler;


import org.barber.stdfhandler.file.FileBuilder;

public class Writer {

    public static void main(String[] args) {

        FileBuilder file = new FileBuilder();

        file = new FileBuilder().setFarCpuTyp(2).setFarStdfVer(3);
    }
}
