package com.masterannonce.annoncebacksprintboot.controleur;


import com.masterannonce.annoncebacksprintboot.entitie.Annonce;
import com.masterannonce.annoncebacksprintboot.services.impls.AnnonceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("annonces")
public class AnnonceController {

    private final AnnonceImpl annonceService;

    @Autowired
    public AnnonceController(AnnonceImpl annonceService) {
        this.annonceService = annonceService;
    }

    @PostMapping
    public ResponseEntity<Annonce> createAnnonce(@RequestBody Annonce annonce) {
        Annonce savedAnnonce = annonceService.saveAnnonce(annonce);
        return ResponseEntity.ok(savedAnnonce);
    }

    @GetMapping
    public ResponseEntity<List<Annonce>> getAllAnnonces() {
        List<Annonce> annonces = annonceService.getListAnnonces();
        return ResponseEntity.ok(annonces);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getAnnonceById(@PathVariable int id) {
        Annonce annonce = annonceService.getAnnonceById(id);
        if (annonce != null) {
            return ResponseEntity.ok(annonce);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Annonce non trouvée avec l'ID : " + id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Annonce> updateAnnonce(@PathVariable int id, @RequestBody Annonce annonce) {
        Annonce updatedAnnonce = annonceService.updateAnnonce(id, annonce);
        return ResponseEntity.ok(updatedAnnonce);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnonce(@PathVariable int id) {
        annonceService.deleteAnnonce(id);
        return ResponseEntity.noContent().build();
    }

}