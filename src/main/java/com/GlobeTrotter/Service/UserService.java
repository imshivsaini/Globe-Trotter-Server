package com.GlobeTrotter.Service;

import com.GlobeTrotter.DTO.LeaderboardDTO;
import com.GlobeTrotter.Exception.DuplicateResourceException;
import com.GlobeTrotter.Exception.ResourceNotFoundException;
import com.GlobeTrotter.Repository.UserRepository;
import com.GlobeTrotter.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username) {
        // Validate input
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        // Check if username already exists
        if (userRepository.existsByUsername(username)) {
            return userRepository.findByUsername(username)
                    .orElseThrow();
        }

        User user = new User();
        user.setUsername(username);
        user.setLastPlayed(LocalDateTime.now());
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    public User updateUserScore(Long userId, boolean correct) {
        User user = getUserById(userId);

        if (correct) {
            user.incrementCorrectAnswers();
        } else {
            user.incrementTotalAnswers();
        }

        user.setLastPlayed(LocalDateTime.now());
        return userRepository.save(user);
    }


    public List<LeaderboardDTO> getLeaderboard() {
        List<Object[]> results = userRepository.getLeaderboard();
        return results.stream()
                .map(obj -> new LeaderboardDTO(
                        (String) obj[0],   // username
                        (Integer) obj[1], // correctAnswers
                        (Integer) obj[2]  // totalAnswers
                ))
                .collect(Collectors.toList());
    }
}
