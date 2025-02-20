package com.example.ToDo.Tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskuriService {
    @Autowired
    private TaskuriRepository taskuriRepository;

    public List<Taskuri> getAllTasks(){
        //returneaza toate taskurile din baza de date
        return taskuriRepository.findAll();
    }

    public List<Taskuri> getTasksByUser(Long id){
        return taskuriRepository.getTaskByUser(id);
    }

    //de studiat cum va functiona metoda pentru ca este posibil sa facem overload la ea. Daca se completeaza si descrierea + alte campuri optionale.
    public Taskuri saveTask(String titlu, String nume_utilizator){
        //de implementat (voi face verificare daca utilizatorul exista si daca ta, putem crea task-ul)
        if(verificareExistentaUtilizator(nume_utilizator)){
            //salvam task-ul
        }else{
            //In else nu se va ajunge niciodata pentru ca tot timpul va primi un utilizator. Task-urile se vor creea doar dupa ce user-ul se logheaza in sistem, deci va exista!
        }
    }


    @Autowired
    private UtilizatoriRepository utilizatoriRepository; //instantiem pentru a folosi repositoriul in functia de mai jos:
    public boolean verificareExistentaUtilizator(String nume){
        List<Utilizator> utilizatorGasit = utilizatoriRepository.getUtilizatorByNume(nume);
        return !utilizatorGasit.isEmpty() ? true : false; //daca lista nu este goala, returneaza true
    }
    //de implementat metoda care va returna taskurile in functie de utilizator
    //de implementat metoda care va returna taskurile in functie de utilizator si prioritate
    //metoda pentru taskuri in functie de prioritate
}
