package com.example.ToDo.Tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;


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


    //stergere task
    @DeleteMapping("/{numeUtilizator}/task_{titluTask}")
    public ResponseEntity<Void> deleteTask(@PathVariable String numeUtilizator, @PathVariable String titluTask){
        boolean deleted = taskuriService.deleteTask(titluTask, numeUtilizator);
        if(deleted){
            return ResponseEntity.noContent().build(); //204 No Content daca s-a sters
        }else{
            return ResponseEntity.notFound().build(); //404 Not Found daca nu a gasit nimic ce sa stearga
        }
    }

    //adaugare task
    @PostMapping("/crearetask")
    public ResponseEntity<String> creareTask(@RequestBody TaskuriDTO taskNouDTO) {
        int valid = taskuriService.creareTaskNou(taskNouDTO);
        System.out.println("Task-uri controller. Valid: " + valid);
        if(valid == 1){ //creareTaskNow intoarce 1 daca se insereaza linia in db
            return ResponseEntity.status(HttpStatus.CREATED).body("Task creat cu succes.");
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Taskul nu a fost creat.");
        }
        
    //     Exemplu de json:
    //    {
    //        "titlu": "TestareDTO",
    //            "descriere": "TestareDTO descriere",
    //            "status": "In lucru",
    //            "due_date": "2025-01-01T00:00:00",
    //            "prioritate": "0",
    //            "utilizatorNume": "User2"
    //    }
    }

    @PostMapping("/birt")
    public ResponseEntity<String> testareBirt(){
        System.out.println("Test");
        return ResponseEntity.status(HttpStatus.CREATED).body("Testare cu succes");
    }
    
}
