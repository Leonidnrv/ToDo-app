package com.example.ToDo.Tasks;

public class UtilizatorDTO {
    //voi pune toate campurile aici si voi folosi doar nume in TaskuriDTO
    private Long id;
    private String nume;

    public void setNume(String nume){
        this.nume = nume;
    }
    public String getNume(){
        return this.nume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
