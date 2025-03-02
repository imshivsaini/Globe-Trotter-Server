package com.GlobeTrotter.Entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "app_user") // avoiding reserved word 'user'
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private Integer correctAnswers = 0;
    private Integer totalAnswers = 0;
    private LocalDateTime lastPlayed;

    public User() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(Integer correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public Integer getTotalAnswers() {
        return totalAnswers;
    }

    public void setTotalAnswers(Integer totalAnswers) {
        this.totalAnswers = totalAnswers;
    }

    public LocalDateTime getLastPlayed() {
        return lastPlayed;
    }

    public void setLastPlayed(LocalDateTime lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    // Helper methods
    public void incrementCorrectAnswers() {
        this.correctAnswers++;
        this.totalAnswers++;
    }

    public void incrementTotalAnswers() {
        this.totalAnswers++;
    }

    public double getScorePercentage() {
        if (totalAnswers == 0) return 0.0;
        return (double) correctAnswers / totalAnswers * 100.0;
    }
}