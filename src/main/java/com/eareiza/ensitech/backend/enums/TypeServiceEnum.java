package com.eareiza.ensitech.backend.enums;

public enum TypeServiceEnum {
    SERVICEALL("getCharactersService"),
    SERVICEBYID("getCharacterById");

    private String state;

    TypeServiceEnum(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
