package org.barber.stdfhandler.file;

abstract class TypeInt extends Type<Integer> {

    static final Class<Integer> TYPE = Integer.class;

    static Integer cast(Object value) {
        return TYPE.cast(value);
    }

    @Override
    public String asString() {
        return String.valueOf(value);
    }
}
