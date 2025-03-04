package com.example.ToDo.Tasks;

import org.springframework.data.convert.Jsr310Converters;

import java.time.LocalDateTime;

//Clasa folosita pentru a crea task-uri noi
public class TaskuriDTO {
    String titlu;
    String descriere;
    String status;
    LocalDateTime due_date;
    String prioritate;
    String nume_utilizator;

    public TaskuriDTO(){}
    public TaskuriDTO(String titlu, String descriere, String status, LocalDateTime due_date, String prioritate, String nume_utilizator){
        this.titlu = titlu;
        this.descriere = descriere;
        this.status = status;
        this.due_date = due_date;
        this.prioritate = prioritate;
        this.nume_utilizator = nume_utilizator;
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

    public String getNume_utilizator() {
        return nume_utilizator;
    }

    public void setNume_utilizator(String nume_utilizator) {
        this.nume_utilizator = nume_utilizator;
    }
}
