package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDTO>> createUser(@Valid @RequestBody UserRequestDTO userRequest) {
        try {
            User user = new User();
            user.setUsername(userRequest.getUsername());
            user.setEmail(userRequest.getEmail());
            user.setPassword(userRequest.getPassword());
            user.setFirstName(userRequest.getFirstName());
            user.setLastName(userRequest.getLastName());
            user.setPhoneNumber(userRequest.getPhoneNumber());

            User createdUser = userService.createUser(user);
            UserResponseDTO responseDTO = UserResponseDTO.fromUser(createdUser);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ApiResponse.success("User created successfully", responseDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error("Failed to create user", e.getMessage()));
        }
    }

    // Get all users
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponseDTO>>> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            List<UserResponseDTO> userDTOs = users.stream()
                    .map(UserResponseDTO::fromUser)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(ApiResponse.success("Users retrieved successfully", userDTOs));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Failed to retrieve users", e.getMessage()));
        }
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> getUserById(@PathVariable Long id) {
        try {
            Optional<User> user = userService.getUserById(id);
            if (user.isPresent()) {
                UserResponseDTO responseDTO = UserResponseDTO.fromUser(user.get());
                return ResponseEntity.ok(ApiResponse.success("User retrieved successfully", responseDTO));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error("User not found with id: " + id));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Failed to retrieve user", e.getMessage()));
        }
    }

    // Update user
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> updateUser(@PathVariable Long id,
            @Valid @RequestBody UserRequestDTO userRequest) {
        try {
            User user = new User();
            user.setUsername(userRequest.getUsername());
            user.setEmail(userRequest.getEmail());
            user.setFirstName(userRequest.getFirstName());
            user.setLastName(userRequest.getLastName());
            user.setPhoneNumber(userRequest.getPhoneNumber());

            User updatedUser = userService.updateUser(id, user);
            UserResponseDTO responseDTO = UserResponseDTO.fromUser(updatedUser);

            return ResponseEntity.ok(ApiResponse.success("User updated successfully", responseDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error("Failed to update user", e.getMessage()));
        }
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity
                    .ok(ApiResponse.success("User deleted successfully", "User with id " + id + " has been deleted"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error("Failed to delete user", e.getMessage()));
        }
    }

    // Get active users
    @GetMapping("/active")
    public ResponseEntity<ApiResponse<List<UserResponseDTO>>> getActiveUsers() {
        try {
            List<User> activeUsers = userService.getAllActiveUsers();
            List<UserResponseDTO> userDTOs = activeUsers.stream()
                    .map(UserResponseDTO::fromUser)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(ApiResponse.success("Active users retrieved successfully", userDTOs));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Failed to retrieve active users", e.getMessage()));
        }
    }

    // Get inactive users
    @GetMapping("/inactive")
    public ResponseEntity<ApiResponse<List<UserResponseDTO>>> getInactiveUsers() {
        try {
            List<User> inactiveUsers = userService.getAllInactiveUsers();
            List<UserResponseDTO> userDTOs = inactiveUsers.stream()
                    .map(UserResponseDTO::fromUser)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(ApiResponse.success("Inactive users retrieved successfully", userDTOs));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Failed to retrieve inactive users", e.getMessage()));
        }
    }

    // Activate user
    @PatchMapping("/{id}/activate")
    public ResponseEntity<ApiResponse<UserResponseDTO>> activateUser(@PathVariable Long id) {
        try {
            User activatedUser = userService.activateUser(id);
            UserResponseDTO responseDTO = UserResponseDTO.fromUser(activatedUser);
            return ResponseEntity.ok(ApiResponse.success("User activated successfully", responseDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error("Failed to activate user", e.getMessage()));
        }
    }

    // Deactivate user
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<ApiResponse<UserResponseDTO>> deactivateUser(@PathVariable Long id) {
        try {
            User deactivatedUser = userService.deactivateUser(id);
            UserResponseDTO responseDTO = UserResponseDTO.fromUser(deactivatedUser);
            return ResponseEntity.ok(ApiResponse.success("User deactivated successfully", responseDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error("Failed to deactivate user", e.getMessage()));
        }
    }

    // Search users
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<UserResponseDTO>>> searchUsers(@RequestParam String query) {
        try {
            List<User> users = userService.searchUsersByName(query);
            List<UserResponseDTO> userDTOs = users.stream()
                    .map(UserResponseDTO::fromUser)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(ApiResponse.success("Search results retrieved successfully", userDTOs));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Failed to search users", e.getMessage()));
        }
    }

    // Get user statistics
    @GetMapping("/stats")
    public ResponseEntity<ApiResponse<UserStatsDTO>> getUserStats() {
        try {
            UserStatsDTO stats = new UserStatsDTO();
            stats.setTotalUsers(userService.getTotalUserCount());
            stats.setActiveUsers(userService.getActiveUserCount());
            stats.setInactiveUsers(userService.getInactiveUserCount());

            return ResponseEntity.ok(ApiResponse.success("User statistics retrieved successfully", stats));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Failed to retrieve user statistics", e.getMessage()));
        }
    }

    // Change password
    @PatchMapping("/{id}/change-password")
    public ResponseEntity<ApiResponse<String>> changePassword(@PathVariable Long id,
            @RequestBody PasswordChangeDTO passwordChange) {
        try {
            userService.changePassword(id, passwordChange.getNewPassword());
            return ResponseEntity.ok(ApiResponse.success("Password changed successfully", "Password has been updated"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error("Failed to change password", e.getMessage()));
        }
    }

    // Inner classes for DTOs
    public static class UserStatsDTO {
        private long totalUsers;
        private long activeUsers;
        private long inactiveUsers;

        // Getters and Setters
        public long getTotalUsers() {
            return totalUsers;
        }

        public void setTotalUsers(long totalUsers) {
            this.totalUsers = totalUsers;
        }

        public long getActiveUsers() {
            return activeUsers;
        }

        public void setActiveUsers(long activeUsers) {
            this.activeUsers = activeUsers;
        }

        public long getInactiveUsers() {
            return inactiveUsers;
        }

        public void setInactiveUsers(long inactiveUsers) {
            this.inactiveUsers = inactiveUsers;
        }
    }

    public static class PasswordChangeDTO {
        private String newPassword;

        public String getNewPassword() {
            return newPassword;
        }

        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }
    }
}
