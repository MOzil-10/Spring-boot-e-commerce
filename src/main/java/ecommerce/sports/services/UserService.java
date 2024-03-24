package ecommerce.sports.services;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import ecommerce.sports.model.UserModel;
import ecommerce.sports.repository.UserRepository;

@Service
public class UserService {

   
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel createUser(UserModel userModel) {
        if (!isPasswordConfirmed(userModel)) {
            throw new IllegalArgumentException("Password confirmation does not match");
        }

        try {
            return userRepository.save(userModel);
        } catch (DataIntegrityViolationException e) {
            // Check if the exception is due to duplicate email
            if (e.getMessage().contains("unique constraint or index violation")) {
                throw new IllegalStateException("User with this email already exists");
            } else {
                // Handle other integrity violations
                throw new IllegalStateException("Data integrity violation occurred");
            }
        }
    }

    private boolean isPasswordConfirmed(UserModel userModel) {
        return userModel.getPassword() != null && userModel.getPassword().equals(userModel.getPasswordConfirmation());
    }

    public UserModel getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
