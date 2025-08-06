package com.arasmo.carrentalsales.carrentalsale_service.enums;

public enum EngineCapacityTypes {
    SMALL("< 1000cc"),
    COMPACT("1000 – 1500cc"),
    MID_SIZE("1500 – 2000cc"),
    LARGE("2000 – 3000cc"),
    LUXURY_SPORTS("> 3000cc");

    private final String description;

    EngineCapacityTypes(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
