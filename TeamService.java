package org.edf.cat.mmesi.Irritant.service;

import org.edf.cat.mmesi.Irritant.model.Team;

import java.util.List;
import java.util.UUID;

/**
 * @author TBF053DN
 */
public interface TeamService {
    List<?> findAll();

    Team update(UUID id, Team team);

    Team save(Team team);

    void delete(UUID id);
}
