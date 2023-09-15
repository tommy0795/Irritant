package org.edf.cat.mmesi.Irritant.security;

import org.edf.cat.mmesi.Irritant.model.Token;
/**
 * @author TBF053DN
 */
public interface TokenService {

    Token createSecureToken();
    void saveSecureToken(final Token token);
    Token findByToken(final String token);
    void removeToken(final Token token);
    void removeTokenByToken(final String token);
}
