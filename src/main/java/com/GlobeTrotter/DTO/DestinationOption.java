package com.GlobeTrotter.DTO;

public class DestinationOption {
    private Long id;
    private String name;
    private String country;

    public DestinationOption() {
    }

    public DestinationOption(Long id, String country, String name) {
        this.id = id;
        this.country = country;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
