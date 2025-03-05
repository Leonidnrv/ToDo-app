package com.example.ToDo.Tasks;

import org.springframework.data.convert.Jsr310Converters;

import java.time.LocalDateTime;

//Clasa folosita pentru a crea task-uri noi
public class TaskuriDTO {
    private String titlu;
    private String descriere;
    private String status;
    private LocalDateTime due_date;
    private String prioritate;
    private UtilizatorDTO utilizatorDTO_Nume;

    public TaskuriDTO(){}
    public TaskuriDTO(String titlu, String descriere, String status, LocalDateTime due_date, String prioritate, UtilizatorDTO utilizatorDTO_Nume){
        this.titlu = titlu;
        this.descriere = descriere;
        this.status = status;
        this.due_date = due_date;
        this.prioritate = prioritate;
        this.utilizatorDTO_Nume = utilizatorDTO_Nume;
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

    public UtilizatorDTO getUtilizatorDTO_Nume(){
        return this.utilizatorDTO_Nume;
    }

    public void setUtilizatorDTO_Nume(UtilizatorDTO utilizatorDTO_Nume){
        this.utilizatorDTO_Nume = utilizatorDTO_Nume;
    }
}
