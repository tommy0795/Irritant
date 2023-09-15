package org.edf.cat.mmesi.Irritant.repositrory;

import org.edf.cat.mmesi.Irritant.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {
    Optional<Token> findByToken(String token);

    @Query(value = """
    select token from Irritant_Test.secure_tokens inner join users on Irritant_Test.users.id =  user.id
    where user.id = :id and (secure_token.is_expired = false or secure_token.revoked = false)""")
    List<Token> findAllValidTokenByUser(UUID id);
}

