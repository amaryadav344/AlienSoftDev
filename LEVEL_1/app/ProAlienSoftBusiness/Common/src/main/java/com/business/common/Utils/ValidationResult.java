package com.business.common.Utils;

public class ValidationResult {
    public static enum TYPE {
        INFO,
        WARNING,
        DANGER,
        ERROR,
        PRIMARY,
        SECONDARY,
        SUCCESS
    }

    private TYPE type;
    private String message;

    public ValidationResult(TYPE type, String message) {
        this.type = type;
        this.message = message;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
