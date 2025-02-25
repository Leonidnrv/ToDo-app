package com.example.ToDo.Tasks;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilizatori")
public class UtilizatoriController {
    @Autowired
    private UtilizatoriService utilizatoriService;

    @GetMapping("/toti")
    public ResponseEntity<List<Utilizator>> getAllUtilizatori(){
        List<Utilizator> utilizatori = utilizatoriService.getAllUtilizatori();
        System.out.println("S-au adus utilizatorii.");
        return ResponseEntity.ok(utilizatori);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<List<Utilizator>> getUtilizatorById(@PathVariable Long id){
        List<Utilizator> utilizator = utilizatoriService.getUtilizatorById(id);
        if(utilizator.isEmpty()){
            return ResponseEntity.notFound().build(); //daca nu a gasit nimic va intoarce 404. Atentie! Nu va intoarce un body (pentru asta va fi nevoie de dezvoltare RestControllerAdvice)
        }
        return ResponseEntity.ok(utilizator);
    }

    @GetMapping("/nume/{nume}")
    public ResponseEntity<List<Utilizator>> getUtilizatorByNume(@PathVariable String nume){
        List<Utilizator> utilizator = utilizatoriService.getUtilizatorByNume(nume);
        if(utilizator.isEmpty()){
            System.out.println("Nu am gasit utilizatorul.");
            return ResponseEntity.notFound().build(); //la fel ca functia de mai sus cu id
        }
        System.out.println("Am gasit utilizatorul");
        return ResponseEntity.ok(utilizator);
    }

    @PostMapping
    public ResponseEntity<Utilizator> createUtilizator(@RequestBody Utilizator utilizator){
        Utilizator saveUtilizator = utilizatoriService.saveUtilizator(utilizator);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveUtilizator);
    }

    @DeleteMapping("/{nume}")
    public ResponseEntity<?> deleteUtilizator(@PathVariable String nume){
        //Clientul va trimite un request DELETE catre '/utilizatori/{nume}'
        //daca se va sterge cu succes, va returna codul 204 No content care este standard pentru DELETE. Daca utilizatorul nu exista, va returna 404 Not Found.
        try{
            utilizatoriService.deleteUtilizator(nume);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //204 No Content
        }catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); //404 Not Found
        }
    }
}

