package com.example.ToDo.Tasks;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.convert.Jsr310Converters;

import java.time.LocalDateTime;

//Clasa folosita pentru a crea task-uri noi
public class TaskuriDTO {
    private String titlu;
    private String descriere;
    private String status;
    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime due_date;
    private String prioritate;
    private String utilizatorNume;

    public TaskuriDTO(){}
    public TaskuriDTO(String titlu, String descriere, String status, LocalDateTime due_date, String prioritate, String utilizatorNume){
        this.titlu = titlu;
        this.descriere = descriere;
        this.status = status;
        this.due_date = due_date;
        this.prioritate = prioritate;
        this.utilizatorNume = utilizatorNume;
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

    public String getUtilizatorNume(){
        return this.utilizatorNume;
    }

    public void setUtilizatorNume(String utilizatorNume){
        this.utilizatorNume = utilizatorNume;
    }
    
}
