package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;

public interface UserService {

    // Create a new user
    User createUser(User user);

    // Get user by ID
    Optional<User> getUserById(Long id);

    // Get user by username
    Optional<User> getUserByUsername(String username);

    // Get user by email
    Optional<User> getUserByEmail(String email);

    // Get all users
    List<User> getAllUsers();

    // Get all active users
    List<User> getAllActiveUsers();

    // Get all inactive users
    List<User> getAllInactiveUsers();

    // Update user
    User updateUser(Long id, User user);

    // Delete user by ID
    void deleteUser(Long id);

    // Activate user
    User activateUser(Long id);

    // Deactivate user
    User deactivateUser(Long id);

    // Search users by name
    List<User> searchUsersByName(String searchTerm);

    // Check if username exists
    boolean isUsernameExists(String username);

    // Check if email exists
    boolean isEmailExists(String email);

    // Get total user count
    long getTotalUserCount();

    // Get active user count
    long getActiveUserCount();

    // Get inactive user count
    long getInactiveUserCount();

    // Change password
    User changePassword(Long id, String newPassword);
}
