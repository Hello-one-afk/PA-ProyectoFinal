package com.proyecto.app.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.app.models.User;
import com.proyecto.app.services.UserService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/v1/api/users")
@CrossOrigin(origins = "http://localhost:8080")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<?> getAllUsers() throws Exception {
        try {
            return ResponseEntity.ok(userService.getAll());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }  

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody User userToCreate) throws Exception {
        try {
            return ResponseEntity.ok(userService.createUser(userToCreate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{userID}")
    public ResponseEntity<?> getUserByID(@PathVariable Long userID) throws Exception {
        try {
            return ResponseEntity.ok(userService.getUserByID(userID));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userID}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userID) throws Exception {
        try {
            userService.deleteUserByID(userID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } 
    }

    @PutMapping("/{userId}/update")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody User userUpdates) {
        try {
            return ResponseEntity.ok(userService.updateUser(userId, userUpdates));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
