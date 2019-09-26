package com.poktest.spring.restapi.validate.error;

import java.util.Set;

public class BookUnSupportedFieldPatchException extends RuntimeException {
    public BookUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }
}
