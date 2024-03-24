package ecommerce.sports.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ecommerce.sports.model.UserModel;
import ecommerce.sports.services.UserService; // Correct import for UserService
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

   @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserModel userModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Return validation errors in the response body with status code 400 Bad Request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }

        UserModel createdUser = userService.createUser(userModel);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserModel> getUserByEmail(@PathVariable String email) {
        UserModel user = userService.getUserByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
