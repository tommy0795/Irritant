package org.edf.cat.mmesi.Irritant.service;

import org.edf.cat.mmesi.Irritant.model.User;

import java.util.List;
import java.util.UUID;

/**
 * @author TBF053DN
 */
public interface UserService {

    List<?> findAll();

    List<User> findByLastName(String lastName);
    User getByNni(String nni);
    User update(UUID id, User user);

    //retourne les utilisateur par pages en fonction de la valeur de la barre de recherche
   // List<User> searchByTerm(String name);

    User save(User user);
    void delete(UUID id);

}
