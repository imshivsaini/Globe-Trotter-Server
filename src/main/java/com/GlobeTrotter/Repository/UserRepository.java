package com.GlobeTrotter.Repository;

import com.GlobeTrotter.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);

    @Query("SELECT u.username, u.correctAnswers, u.totalAnswers FROM User u ORDER BY u.correctAnswers DESC")
    List<Object[]> getLeaderboard();
}
