package org.edf.cat.mmesi.Irritant.controller;

import org.edf.cat.mmesi.Irritant.model.File;
import org.edf.cat.mmesi.Irritant.service.FileService;
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
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = fileService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN') or hasRole('USER')")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody File file) {
        File saveFile = fileService.save(file);

        // Création de l'URI pour l'utilisateur nouvellement enregistré
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}").buildAndExpand(saveFile.getId())
                .toUri();
        return ResponseEntity.created(uri).body(saveFile);
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN') or hasRole('USER')")
    @PutMapping
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody File file) {
        File updateFile = fileService.update(id, file);
        return ResponseEntity.ok().body(updateFile);
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN') or hasRole('USER')")
    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        fileService.delete(id);
        return ResponseEntity.ok().body(id);
    }



}
