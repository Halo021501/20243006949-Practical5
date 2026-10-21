package com.example.practicalfive;

public class TextProcessor {
    public String processMunicipality(String municipality) {
        if (municipality == null) {
            return null;
        }

        municipality = municipality.trim();
        if (municipality.isEmpty()) {
            return null;
        }

        if (municipality.equalsIgnoreCase("Beijing")) {
            return "Beijing";
        } else if (municipality.equalsIgnoreCase("Shanghai")) {
            return "Shanghai";
        } else if (municipality.equalsIgnoreCase("Chongqing")) {
            return "Chongqing";
        } else if (municipality.equalsIgnoreCase("Tianjin")) {
            return "Tianjin";
        }

        return null;
    }
}
