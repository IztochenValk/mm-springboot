package com.adrar.cdafad.service;

import com.adrar.cdafad.entity.Game;
import com.adrar.cdafad.entity.Users;
import com.adrar.cdafad.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public Users createUsers(Users users) {
        if (usersRepository.existsByEmail(users.getEmail())) {
            throw new RuntimeException("Le Users avec l'email: " + users.getEmail() + " existe déjà");
        }
        return usersRepository.save(users);
    }

    @Transactional(readOnly = true)
    public Users getByEmail(String email) {
        return usersRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Le Users avec l'email: " + email + " n'existe pas"));
    }

    @Transactional(readOnly = true)
    public List<Game> getUserGames(String email) {
        Users user = getByEmail(email);
        return user.getGames();
    }

    @Transactional(readOnly = true)
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
}