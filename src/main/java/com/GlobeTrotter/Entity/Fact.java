package com.GlobeTrotter.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@Entity
@Table
public class Fact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String text;

    private Boolean isTrivia; // Trivia or fun fact

    @ManyToOne
    @JoinColumn(name = "destination_id")
    @JsonIgnore
    private Destination destination;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getIsTrivia() {
        return isTrivia;
    }

    public void setIsTrivia(Boolean isTrivia) {
        this.isTrivia = isTrivia;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
