package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by username
    Optional<User> findByUsername(String username);

    // Find user by email
    Optional<User> findByEmail(String email);

    // Find user by username or email
    Optional<User> findByUsernameOrEmail(String username, String email);

    // Check if username exists
    boolean existsByUsername(String username);

    // Check if email exists
    boolean existsByEmail(String email);

    // Find all active users
    List<User> findByIsActiveTrue();

    // Find all inactive users
    List<User> findByIsActiveFalse();

    // Find users by first name containing (case insensitive)
    List<User> findByFirstNameContainingIgnoreCase(String firstName);

    // Find users by last name containing (case insensitive)
    List<User> findByLastNameContainingIgnoreCase(String lastName);

    // Find users by full name search
    @Query("SELECT u FROM User u WHERE " +
            "LOWER(u.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(u.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(u.username) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<User> findByFullNameSearch(@Param("searchTerm") String searchTerm);

    // Count active users
    long countByIsActiveTrue();

    // Count inactive users
    long countByIsActiveFalse();
}
