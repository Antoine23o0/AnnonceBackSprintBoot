package com.masterannonce.annoncebacksprintboot.entitie;

import jakarta.persistence.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Optional;


@Entity
@Table(name = "annonce")
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 64, nullable = false)
    private String title;

    @Column(length = 256, nullable = false)
    private String description;

    @Column(length = 64, nullable = false)
    private String adress;

    @Column(length = 64, nullable = false)
    private String mail;

    @Column(nullable = false)
    private LocalDateTime date;

    public Annonce() {
    }

    public Annonce(String title, String description, String adress, String mail, LocalDateTime date) {
        this.title = title;
        this.description = description;
        this.adress = adress;
        this.mail = mail;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Annonce{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", adress='" + adress + '\'' +
                ", mail='" + mail + '\'' +
                ", date=" + date +
                '}';
    }

}
