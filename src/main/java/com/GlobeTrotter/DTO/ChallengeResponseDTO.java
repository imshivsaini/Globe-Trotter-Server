package com.GlobeTrotter.DTO;

public class ChallengeResponseDTO {
    private String username;
    private String score;
    private Integer correctAnswers;
    private Integer totalAnswers;

    public ChallengeResponseDTO( Integer totalAnswers, Integer correctAnswers, String score, String username) {

        this.totalAnswers = totalAnswers;
        this.correctAnswers = correctAnswers;
        this.score = score;
        this.username = username;
    }

    public ChallengeResponseDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getTotalAnswers() {
        return totalAnswers;
    }

    public void setTotalAnswers(Integer totalAnswers) {
        this.totalAnswers = totalAnswers;
    }

    public Integer getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(Integer correctAnswers) {
        this.correctAnswers = correctAnswers;
    }
}
