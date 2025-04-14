package com.masterannonce.annoncebacksprintboot.services.interfaces;


import com.masterannonce.annoncebacksprintboot.entitie.Annonce;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceInter {

    List<Annonce> getListAnnonces();
    Annonce getAnnonceById(int id);
    void addAnnonce(Annonce annonce);
    void deleteAnnonce(int id);
    public Annonce saveAnnonce(Annonce annonce);
    public Annonce updateAnnonce(int id, Annonce annonce);

}