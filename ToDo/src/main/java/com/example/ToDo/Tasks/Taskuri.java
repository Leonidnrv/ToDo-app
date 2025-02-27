package com.example.ToDo.Tasks;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Taskuri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String titlu;

    @Column
    private String descriere;

    @Column
    @NotNull
    //@Pattern(regexp = )
    @Pattern(regexp = "In asteptare|In lucru|Finalizat", message = "Statusul poate fi doar: 'In asteptare', 'In lucru' sau 'Finalizat'")
    private String status;

    @Column(nullable = false)
    private LocalDateTime due_date;

    @Column
    @Pattern(regexp = "^[0-4]$", message = "Prioritatile pot fi de nivel 1, 2, 3 sau 4.")
    private String prioritate;

    @Column
    private Long user_id;

    /*@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Utilizator utilizator;*/



    public Taskuri(){};
    public Taskuri(Long id, String titlu, String descriere, String status, LocalDateTime due_date, String prioritate) {
        this.id = id;
        this.titlu = titlu;
        this.descriere = descriere;
        this.status = status;
        this.due_date = due_date;
        this.prioritate = prioritate;
    }
    public Taskuri(String titlu, String descriere, String status, LocalDateTime due_date, String prioritate, Long user_id){
        this.titlu = titlu;
        this.descriere = descriere;
        this.status = status;
        this.due_date = due_date;
        this.prioritate = prioritate;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitlu() {
        return titlu;
    }
    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }
    public String getDescriere() {
        return descriere;
    }
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDateTime getDue_date() {
        return due_date;
    }
    public void setDue_date(LocalDateTime due_date) {
        this.due_date = due_date;
    }
    public String getPrioritate() {
        return prioritate;
    }
    public void setPrioritate(String prioritate) {
        this.prioritate = prioritate;
    }
    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
