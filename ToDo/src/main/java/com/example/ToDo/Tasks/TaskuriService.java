package com.example.ToDo.Tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    //1.de studiat cum va functiona metoda pentru ca este posibil sa facem overload la ea. Daca se completeaza si descrierea + alte campuri optionale.
    public Taskuri saveTask(String titlu, String nume_utilizator, String descriere, String status /*va trebui validat*/,LocalDateTime due_date, String prioritate /*va trebui validat*/){
        System.out.println("3");
        Taskuri taskNou;
        System.out.println("4");
        if(verificareExistentaUtilizator(nume_utilizator)){ //verificam daca utilizatorul exista
            System.out.println("5");
            Long user_id = returnIdByNumeUtilizator(nume_utilizator);
            System.out.println("am gasit id-ul " + user_id + " pentru utilizatorul " + nume_utilizator);
            taskNou = new Taskuri(titlu, descriere, status, due_date, prioritate, user_id);
            System.out.println("6");
            //De adaptat codul pentru formatul de data:
            // DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            // LocalDateTime localDate = LocalDateTime.of(2025,03,25,23,0);
            // String dataFinala = localDate.format(dateTimeFormatter);
            // System.out.println("Data finala: " + dataFinala);
            taskuriRepository.save(taskNou); //save() va salva task-ul sau va face update daca exista deja linia.
        }else{
            //In else nu se va ajunge niciodata pentru ca tot timpul va primi un utilizator. Task-urile se vor creea doar dupa ce user-ul se logheaza in sistem, deci va exista!
        }
        return null;
    }
    //2.De creat metoda care modifica notele
    //3.Modificare status
    //4. Modificare status si prioritate
    //Ca sa nu mai fac mai multe metode in stilul overload, pot face doar una si de acolo sa fac update in db in cu parametrii care nu vin NULL de la client


    @Autowired
    private UtilizatoriRepository utilizatoriRepository; //instantiem pentru a folosi repositoriul in functia de mai jos:
    public boolean verificareExistentaUtilizator(String nume){
        System.out.println("Am ajuns in verificareutilizator");
        List<Utilizator> utilizatorGasit = utilizatoriRepository.getUtilizatorByNume(nume);
        System.out.println("S-a creat lista cu utilizatorul");
        if(utilizatorGasit.isEmpty()){//daca lista este goala -> nu am gasit nici un utilizator
            System.out.println("Nu am gasit utilizatorul");
            return false;
        }else{
            System.out.println("S-a gasit utilizatorul utilizatorul");
            return true;
        }
    }
    public Long returnIdByNumeUtilizator(String nume){//metoda folosita in saveTask(). Daca utilizatorul exista, vom introduce numele lui si se va intoarce id-ul din db
        return utilizatoriRepository.idByNume(nume);
    }


    //de implementat metoda care va returna taskurile in functie de utilizator
    //de implementat metoda care va returna taskurile in functie de utilizator si prioritate
    //metoda pentru taskuri in functie de prioritate
}
