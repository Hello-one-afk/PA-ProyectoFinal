package com.proyecto.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.app.models.User;
import com.proyecto.app.repository.NotaRepository;
import com.proyecto.app.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final NotaRepository notaRepository;

    public List<User> getAll() throws Exception {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error fetching data: " + e.getMessage());
        }
    }

    public User getUserByID(Long ID) throws Exception {
        return userRepository.findById(ID).orElseThrow(
                () -> new Exception("This user doesn't exist!"));
    }


    public void deleteUserByID(Long ID) throws Exception {
        try {
            userRepository.deleteById(ID);
        }catch(Exception e){
            throw new Exception("This user doesn't exist! "+e.getMessage());
        }
    }
    

    public User createUser(User userToCreate) throws Exception {
        return userRepository.save(userToCreate);
    }

    public User changeUserRole(Long userId, String newRole) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));
        user.setRole(newRole);
        return userRepository.save(user);
    }

    public User updateUserByAdmin(Long userId, User userUpdates) throws Exception {
        User userToUpdate = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));

        userToUpdate.setUsername(userUpdates.getUsername());
        userToUpdate.setName(userUpdates.getName());
        userToUpdate.setLastname(userUpdates.getLastname());
        userToUpdate.setEmail(userUpdates.getEmail());
        userToUpdate.setPassword(userUpdates.getPassword());

        return userRepository.save(userToUpdate);
    }

    public User updateUser(User userDetails) throws Exception {
        User userToUpdate = userRepository.findById(userDetails.getId())
                .orElseThrow(() -> new Exception("This user doesn't exist!"));

        userToUpdate.setUsername(userToUpdate.getUsername());
        userToUpdate.setName(userToUpdate.getName());
        userToUpdate.setLastname(userToUpdate.getLastname());
        userToUpdate.setEmail(userToUpdate.getEmail());
        userToUpdate.setPassword(userToUpdate.getPassword());

        return userRepository.save(userToUpdate);
    }
}
