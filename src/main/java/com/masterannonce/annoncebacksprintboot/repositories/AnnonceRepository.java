package com.masterannonce.annoncebacksprintboot.repositories;

import com.masterannonce.annoncebacksprintboot.entitie.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {

}
