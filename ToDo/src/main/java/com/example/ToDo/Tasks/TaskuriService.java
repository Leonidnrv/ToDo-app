package com.example.ToDo.Tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Taskuri saveTask(String titlu, Long user_id){
        //de implementat (voi face verificare daca utilizatorul exista si daca ta, putem crea task-ul)
    }
    //de implementat metoda care va returna taskurile in functie de utilizator
    //de implementat metoda care va returna taskurile in functie de utilizator si prioritate
    //metoda pentru taskuri in functie de prioritate
}
