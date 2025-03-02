package com.GlobeTrotter.DTO;

public class ChallengeRequestDTO {
    private String username;


    public ChallengeRequestDTO(String username) {
        this.username = username;
    }

    public ChallengeRequestDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
