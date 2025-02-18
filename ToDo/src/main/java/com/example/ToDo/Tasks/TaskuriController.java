package com.example.ToDo.Tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/taskuri")
public class TaskuriController {
    @Autowired
    private TaskuriService taskuriService;

    @GetMapping("/all")
    public ResponseEntity<List<Taskuri>> getAllTasks(){
        List<Taskuri> tasks = taskuriService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{utilizator}") //se inva insera id-ul utilizatorului ca parametru
    public ResponseEntity<List<Taskuri>> getTasksByUser(@PathVariable Long utilizator){
        List<Taskuri> tasks = taskuriService.getTasksByUser(utilizator);
        if(tasks.isEmpty()){
            return ResponseEntity.notFound().build(); //daca nu a gasit nimic va intoarce 404. Atentie! Nu va intoarce un body (pentru asta va fi nevoie de dezvoltare RestControllerAdvice)
            //Va returna:
            //HTTP/1.1 404 Not Found
            //Content-Length: 0
        }
        return ResponseEntity.ok(tasks);
    }

    //de create metode pentru:
    //creare task
    //modificare task
    //trimitere taskuri dupa id utilizator
    //trimitere task dupa id utilizator si nume task
    //stergere task
}
