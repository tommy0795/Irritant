package org.edf.cat.mmesi.Irritant.controller;

import org.edf.cat.mmesi.Irritant.model.Irritant;
import org.edf.cat.mmesi.Irritant.service.IrritantService;
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
@RequestMapping("/irritant")
public class IrritantController {

    @Autowired
    private IrritantService irritantService;

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = irritantService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN') or hasRole('USER')")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Irritant irritant) {
        Irritant saveIrritant = irritantService.save(irritant);

        // Création de l'URI pour l'utilisateur nouvellement enregistré
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}").buildAndExpand(saveIrritant.getId())
                .toUri();
        return ResponseEntity.created(uri).body(saveIrritant);
    }
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN') or hasRole('USER')")
    @PutMapping
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody Irritant irritant) {
        Irritant updateIrritant = irritantService.update(id, irritant);
        return ResponseEntity.ok().body(updateIrritant);
    }
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN') or hasRole('USER')")
    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        irritantService.delete(id);
        return ResponseEntity.ok().body(id);
    }
}
