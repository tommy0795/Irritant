package org.edf.cat.mmesi.Irritant.repositrory;

import org.edf.cat.mmesi.Irritant.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findById(UUID id);
    List<User> findByFirstName(String firstName);
    Optional<User> findByLastName(String lastName);
    Optional<User> findByNni(String nni);

/**
    @Query("SELECT value FROM USERS WHERE LOWER(value.nni) LIKE (CONCAT('%',:searchTerm','%')) OR" +
    "LOWER(value.first_name) LIKE (CONCAT('%',:searchTerm,'%'))  OR" +
    "LOWER(value.last_name) LIKE (CONCAT('%',:searchTerm,'%')) OR")
    List<User> searchByTerm(@Param("searchTerm") String searchTerm);
    */
}
