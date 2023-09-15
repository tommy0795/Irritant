package org.edf.cat.mmesi.Irritant.controller;

import org.edf.cat.mmesi.Irritant.model.File;
import org.edf.cat.mmesi.Irritant.model.Irritant;
import org.edf.cat.mmesi.Irritant.model.Team;
import org.edf.cat.mmesi.Irritant.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://10.168.24.224:3306")
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = teamService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Team team) {
        Team saveTeam = teamService.save(team);

        // Création de l'URI pour l'utilisateur nouvellement enregistré
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}").buildAndExpand(saveTeam.getId())
                .toUri();
        return ResponseEntity.created(uri).body(saveTeam);
    }
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody Team team) {
        Team updateTeam = teamService.update(id, team);
        return ResponseEntity.ok().body(updateTeam);
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        teamService.delete(id);
        return ResponseEntity.ok().body(id);
    }

}
