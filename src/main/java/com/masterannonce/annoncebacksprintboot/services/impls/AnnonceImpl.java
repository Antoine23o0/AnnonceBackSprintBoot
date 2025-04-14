package com.masterannonce.annoncebacksprintboot.services.impls;


import com.masterannonce.annoncebacksprintboot.entitie.Annonce;
import com.masterannonce.annoncebacksprintboot.repositories.AnnonceRepository;
import com.masterannonce.annoncebacksprintboot.services.interfaces.AnnonceInter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnnonceImpl implements AnnonceInter {

    private final AnnonceRepository annonceRepository;

    @Autowired
    public AnnonceImpl(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    @Override
    public List<Annonce> getListAnnonces() {
        return annonceRepository.findAll();
    }

    @Override
    public Annonce getAnnonceById(int id) {
        return annonceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Annonce non trouvée avec l'ID: " + id));
    }

    @Override
    public Annonce saveAnnonce(Annonce annonce) {
        annonce.setDate(LocalDateTime.now());
        return annonceRepository.save(annonce);
    }


    @Override
    public Annonce updateAnnonce(int id, Annonce annonce) {
        return annonceRepository.findById(id)
                .map(existingAnnonce -> {
                    existingAnnonce.setTitle(annonce.getTitle());
                    existingAnnonce.setDescription(annonce.getDescription());
                    existingAnnonce.setAdress(annonce.getAdress());
                    existingAnnonce.setMail(annonce.getMail());
                    existingAnnonce.setDate(LocalDateTime.now());
                    return annonceRepository.save(existingAnnonce);
                }).orElseThrow(() -> new RuntimeException("Annonce pas trouvée " + id));
    }



    @Transactional
    @Override
    public void addAnnonce(Annonce annonce) {
        if (annonce == null) {
            throw new IllegalArgumentException("L'annonce ne peut pas être nulle");
        }
        annonceRepository.save(annonce);
    }

    @Transactional
    @Override
    public void deleteAnnonce(int id) {
        try {
            annonceRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("Aucune annonce trouvée avec l'ID: " + id, e);
        }
    }
}