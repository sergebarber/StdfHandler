package org.barber.stdfhandler.file;

public class Field<T> {

    private Type<T> type;
    private String name;

    Field(String name, Type<T> type) {
        this.type = type;
        this.name = name;
    }

    public Type<T> getType() {
        return type;
    }

    String getName() {
        return name;
    }
}
