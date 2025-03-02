package com.GlobeTrotter.Controller;

import com.GlobeTrotter.DTO.*;
import com.GlobeTrotter.Entity.User;
import com.GlobeTrotter.Exception.InvalidInputException;
import com.GlobeTrotter.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserRegistrationDTO request) {

        // Validate input
        if (request == null || request.getUsername() == null || request.getUsername().trim().isEmpty()) {
            throw new InvalidInputException("Username is required");
        }

        User user = userService.createUser(request.getUsername());

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setCorrectAnswers(user.getCorrectAnswers());
        userDTO.setTotalAnswers(user.getTotalAnswers());
        userDTO.setScorePercentage(user.getScorePercentage());

        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {

        // Validate input
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidInputException("Username is required");
        }

            User user = userService.getUserByUsername(username);
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setCorrectAnswers(user.getCorrectAnswers());
            userDTO.setTotalAnswers(user.getTotalAnswers());
            userDTO.setScorePercentage(user.getScorePercentage());

            return ResponseEntity.ok(userDTO);

    }

    @PostMapping("/challenge")
    public ResponseEntity<ChallengeResponseDTO> createChallenge(@RequestBody ChallengeRequestDTO request) {
        // Validate input
        if (request == null || request.getUsername() == null || request.getUsername().trim().isEmpty()) {
            throw new InvalidInputException("Username is required");
        }
        User user = userService.getUserByUsername(request.getUsername());

        ChallengeResponseDTO response = new ChallengeResponseDTO();
        response.setUsername(user.getUsername());
        response.setScore(String.format("%.1f%%", user.getScorePercentage()));
        response.setCorrectAnswers(user.getCorrectAnswers());
        response.setTotalAnswers(user.getTotalAnswers());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/leaderboard")
    public List<LeaderboardDTO> getLeaderboard() {
        return userService.getLeaderboard();
    }
}
