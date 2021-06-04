package com.thymeleaf.roomwebapp.models;

public enum Position {

    HOUSEKEEPING, FRONT_DESK, SECURITY, MANAGER;

    public String toString() {
        switch (this) {
            case MANAGER:
                return "Manager";
            case SECURITY:
                return "Security";
            case FRONT_DESK:
                return "Front Desk";
            case HOUSEKEEPING:
                return "House Keeping";
        }
        return "";
    }
}
