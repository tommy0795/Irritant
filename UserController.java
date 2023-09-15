package org.edf.cat.mmesi.Irritant.controller;

import org.edf.cat.mmesi.Irritant.model.User;
import org.edf.cat.mmesi.Irritant.service.UserService;
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
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;



    //récupérer tous les utilisateurs
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    @GetMapping("/")
    public ResponseEntity<List<?>> findAll() {
        List<?> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping
    public ResponseEntity<List<?>> findByLastName(@PathVariable String lastName){
        List<?> list = userService.findByLastName(lastName);
        return ResponseEntity.ok().body(list);

    }
    //enregistrer un nouvel utilisateur
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user) {
        User saveUser = userService.save(user);

        // Création de l'URI pour l'utilisateur nouvellement enregistré
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}").buildAndExpand(saveUser.getId())
                .toUri();


        return ResponseEntity.created(uri).body(saveUser);
    }

    // mettre à jour un utilisateur existant
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody User user) {
        User updatedUser = userService.update(id, user);
        return ResponseEntity.ok().body(updatedUser);
    }

    //supprimer un utilisateur existant
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.ok().body(id);
    }

    //recherche par un valeur (nni, prénom et ou nom) retourne une liste d'utilisateurs
    /**
     @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    @GetMapping("/search/{value}")
    public ResponseEntity<List<User>> searchByTerm(@RequestParam(value = "searchTerm", required = false) String searchTerm) throws NullPointerException
    {
       List<User> list = userService.searchByTerm(searchTerm);

        if (list == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(list);
    }

      */
}
