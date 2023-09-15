package org.edf.cat.mmesi.Irritant.repositrory;

import org.edf.cat.mmesi.Irritant.model.Team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeamRepository extends JpaRepository<Team, UUID> {
}
