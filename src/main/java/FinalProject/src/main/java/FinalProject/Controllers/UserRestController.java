package FinalProject.Controllers;


import FinalProject.Models.UserModel;
import FinalProject.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class UserRestController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/api/register")
    public Object userRegistration(@RequestBody @Valid UserModel userModel) {
        if (!(userModel.getSurname()).equals(userRepository.userDuplicateCheck(userModel.getSurname()))) {
            userRepository.save(userModel);
            return userModel.getUserId();
        } else
            return new ResponseStatusException(HttpStatus.IM_USED);
    }

    @GetMapping("/api/user/profiles")
    public List<UserModel> getAllUserProfiles() {
        return (List<UserModel>) userRepository.findAll();
    }

    @GetMapping("/api/user/profile/{userId}")
    public UserModel getUserProfile(@PathVariable UUID userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }


    @PutMapping("/api/user/profile/{userId}/{currentPassword}")
    public Object updateUserProfile(@RequestBody @Valid UserModel userModel,
                                    @PathVariable UUID userId, @PathVariable String currentPassword) {
        String currentEncryptedPassword = userRepository.passwordEncryption(currentPassword);
        if (currentEncryptedPassword.equals(userRepository.passwordCheck(currentEncryptedPassword)))
            if (!(userModel.getSurname()).equals(userRepository.userDuplicateCheck(userModel.getSurname()))) {
                userRepository.deleteById(userId);
                userRepository.save(userModel);
                return userRepository.findUserBySurname(userModel.getSurname());
            } else
                return new ResponseStatusException(HttpStatus.IM_USED);
        return new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/api/user/password/{userId}/{currentPassword}/{newPassword}")
    public ResponseStatusException updateUserPassword(@PathVariable String currentPassword,
                                                      @PathVariable UUID userId, @PathVariable String newPassword) {
        String currentEncryptedPassword = userRepository.passwordEncryption(currentPassword);
        if (userRepository.existsById(userId) &&
                currentEncryptedPassword.equals(userRepository.passwordCheck(currentEncryptedPassword))) {
            String newEncryptedPassword = userRepository.passwordEncryption(newPassword);
            userRepository.updatePassword(newEncryptedPassword, currentEncryptedPassword);
            return new ResponseStatusException(HttpStatus.OK);
        }
        return new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/api/user/profile/{userId}/{currentPassword}")
    public ResponseStatusException deleteUserProfile(@PathVariable UUID userId, @PathVariable String currentPassword) {
        String currentEncryptedPassword = userRepository.passwordEncryption(currentPassword);
        if (currentEncryptedPassword.equals(userRepository.passwordCheck(currentEncryptedPassword))) {
            userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
            userRepository.deleteById(userId);
            return new ResponseStatusException(HttpStatus.OK);
        }
        return new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

}
