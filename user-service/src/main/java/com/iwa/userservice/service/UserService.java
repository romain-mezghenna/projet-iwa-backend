package com.iwa.userservice.service;

import com.iwa.userservice.model.User;
import com.iwa.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Value("${admin.ids}")
    private String adminIds;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public User createUser(User user) {
        // Vérifier si l'email existe déjà
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email déjà utilisé");
        }
        return userRepository.save(user);
    }

    public boolean isAdmin(Long userId) {
        List<String> adminIdList = Arrays.asList(adminIds.split(","));
        return adminIdList.contains(String.valueOf(userId));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        user.setPrenom(userDetails.getPrenom());
        user.setNom(userDetails.getNom());
        user.setTelephone(userDetails.getTelephone());
        user.setEmail(userDetails.getEmail());
        user.setAdresse(userDetails.getAdresse());
        // Mettez à jour d'autres attributs si nécessaire
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        // Envoyer une notification à l'admin
        kafkaTemplate.send("user-deletion", String.valueOf(id));
    }
}