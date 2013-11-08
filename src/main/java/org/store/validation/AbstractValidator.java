package org.store.validation;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractValidator {
    private Map<String, String> errorMessages = new HashMap<String, String>();

    public final boolean hasErrors() {
        return !errorMessages.isEmpty();
    }

    public final Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    protected void addMessage(String fieldCode, String message) {
        errorMessages.put(fieldCode, message);
    }

    public abstract void validate(Object obj);
}
