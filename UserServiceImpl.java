package org.edf.cat.mmesi.Irritant.service.impl;

import org.edf.cat.mmesi.Irritant.model.User;
import org.edf.cat.mmesi.Irritant.repositrory.UserRepository;
import org.edf.cat.mmesi.Irritant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.UUID;

/**
 * @author TBF053DN
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * retrive all users
     * @return a list of users
     */
    @Override
    public List<?> findAll(){

        return userRepository.findAll();
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return null;
    }

    @Override
    public User getByNni(String nni) {
        return null;
    }

    /**
     *
     * @param id:
     * @param user
     * @return l'utilisateur  enregistrer
     * @throws NullPointerException
     */

    // La méthode de mise à jour d'un utilisateur
    @Override
    @ExceptionHandler
    public User update(UUID id, User user) {
        userRepository.findById(UUID.fromString(String.valueOf(id))); // Cette ligne semble manquer de traitement logique
        user.setId(id); //  modifie l'ID de l'utilisateur avec l'ID passé en paramètre
        return userRepository.save(user); // Enregistrez l'utilisateur modifié dans le dépôt
    }


/**
 @Override
    public List<User> searchByTerm(String name) throws NullPointerException{
        return userRepository.searchByTerm(name);
    }
 */

    @Override
    public User save(User user) {
        return userRepository.save(user); // Enregistrez l'utilisateur dans le dépôt
    }

    @Override
    public void delete(UUID id) {

    }


}
