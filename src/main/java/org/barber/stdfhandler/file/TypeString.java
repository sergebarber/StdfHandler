package org.barber.stdfhandler.file;

public abstract class TypeString extends Type<String> {

    static final Class<String> TYPE = String.class;

    static String cast(Object value) {
        return TYPE.cast(value);
    }

    @Override
    String asString() {
        return value;
    }
}
