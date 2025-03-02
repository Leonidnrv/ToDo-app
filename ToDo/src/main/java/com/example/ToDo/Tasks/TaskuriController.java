package com.example.ToDo.Tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @GetMapping("/{utilizator}") //se insera numele utilizatorului ca parametru
    public ResponseEntity<List<Taskuri>> getTasksByUser(@PathVariable String utilizator){
        List<Taskuri> tasks = taskuriService.getTasksByUser(utilizator);
        if(tasks.isEmpty()){
            return ResponseEntity.notFound().build(); //daca nu a gasit nimic va intoarce 404. Atentie! Nu va intoarce un body (pentru asta va fi nevoie de dezvoltare RestControllerAdvice)
            //Va returna:
            //HTTP/1.1 404 Not Found
            //Content-Length: 0
        }
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{utilizator}/prioritate_{prioritate_task}") //se insera numele utilizatorului ca parametru
    public ResponseEntity<List<Taskuri>> getTaskByUserAndPriority(@PathVariable String utilizator, @PathVariable String prioritate_task){
        List<Taskuri> tasks = taskuriService.getTasksByUserAndPriority(utilizator, prioritate_task);
        if(tasks.isEmpty()){
            return ResponseEntity.notFound().build(); //daca nu a gasit nimic va intoarce 404. Atentie! Nu va intoarce un body (pentru asta va fi nevoie de dezvoltare RestControllerAdvice)
            //Va returna:
            //HTTP/1.1 404 Not Found
            //Content-Length: 0
        }
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{utilizator}/nume_{nume_task}") //se insera numele utilizatorului ca parametru
    public ResponseEntity<List<Taskuri>> getTaskByUserAndTaskname(@PathVariable String utilizator, @PathVariable String nume_task){ //vom pasa in path %20 pentru space " ". Exemplu: 'aplicatia 2' -> nume_aplicatia%202
        System.out.println("Am pasat nume_task: " + nume_task);
        List<Taskuri> tasks = taskuriService.getTasksByUserAndTaskname(utilizator, nume_task);
        if(tasks.isEmpty()){
            return ResponseEntity.notFound().build(); //daca nu a gasit nimic va intoarce 404. Atentie! Nu va intoarce un body (pentru asta va fi nevoie de dezvoltare RestControllerAdvice)
            //Va returna:
            //HTTP/1.1 404 Not Found
            //Content-Length: 0
        }
        return ResponseEntity.ok(tasks);
    }



    @GetMapping("/test_user_{nume}")
    public boolean verificareUtilizator(@PathVariable String nume){
        return taskuriService.verificareExistentaUtilizator(nume);
    }

    @PostMapping("/test_save_task")
    public ResponseEntity<Taskuri> saveTask(){
        LocalDateTime localDateTime = LocalDateTime.of(2025,2,25,0,0,0);
        Taskuri nouTask = taskuriService.saveTask("Titlu6", "User2", "Am modificat descrierea", "In asteptare", localDateTime, "1");
        return ResponseEntity.ok(nouTask);
    }


    //de create metode pentru:
    //trimitere task dupa id utilizator si nume task
    //stergere task
}
