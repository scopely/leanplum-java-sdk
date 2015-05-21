package com.scopely.integration.leanplum;

public class LeanplumError {
    public String message;

    public static LeanplumError createLeanplumError(String message) {
        LeanplumError error = new LeanplumError();
        error.message = message;
        return error;
    }

    @Override
    public String toString() {
        return "LeanplumError{" +
                "message='" + message + '\'' +
                '}';
    }
}
