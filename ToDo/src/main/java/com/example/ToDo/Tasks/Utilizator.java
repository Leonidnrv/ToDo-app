package com.example.ToDo.Tasks;

import jakarta.persistence.*;

import java.util.List;

@Entity //Anotatia Entity face ca Spring sa mapeze aceasta clasa catre o tabela in baza de date
@Table(name = "users") //mapam pe 'users'
public class Utilizator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //GeneratedValue defineste cum va fi generata cheia primara. Strategia IDENTITY inseamna ca pk va fi generata de rdbms cand o linie va fi inserata
    private Long id;

    @Column(nullable = false, unique = true)
    private String nume;

    @Column(nullable = false)
    private String parola;

    /*//OneToMany arata ca aici este o relatie one-to-many intre entitatea Utilizator si Taskuri. Este optional sa o creem insa putem aduce task-urile dupa un utilizator daca vom avea nevoie
    @OneToMany(mappedBy = "utilizator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Taskuri> taskuri; //un utilizator poate avea mai multe taskuri*/

    public Utilizator(){};
    public Utilizator(Long id, String nume, String parola){
        this.id = id;
        this.nume = nume;
        this.parola = parola;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    //Alegem sa suprascriem toStrign pentru a nu trimite si parola inapoi catre client.
    @Override
    public String toString(){
        return "Utilizator{" +
                "id=" + id +
                ", nume='" + nume + "\'}";
    }
}
