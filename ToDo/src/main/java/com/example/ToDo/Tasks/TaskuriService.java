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
    public Taskuri saveTask(String titlu, String nume_utilizator, String descriere, String status /*va trebui validat*/,LocalDateTime due_date, char prioritate /*va trebui validat*/){
        //de implementat (voi face verificare daca utilizatorul exista si daca da, putem crea task-ul)
        Taskuri taskNou;
        if(verificareExistentaUtilizator(nume_utilizator)){
            taskNou = new Taskuri(titlu, descriere, status, due_date, prioritate);
            //De adaptat codul pentru formatul de data:
            // DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            // LocalDateTime localDate = LocalDateTime.of(2025,03,25,23,0);
            // String dataFinala = localDate.format(dateTimeFormatter);
            // System.out.println("Data finala: " + dataFinala);

            //salvam task-ul
            //taskuriRepository.save(); //va trebui sa facem aici un query custom pentru insert. In functie de ce date vom primi in json vom insera in db.
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
        List<Utilizator> utilizatorGasit = utilizatoriRepository.getUtilizatorByNume(nume);
        if(utilizatorGasit.isEmpty()){//daca lista este goala -> nu am gasit nici un utilizator
            return false;
        }else{
            return true;
        }
    }
    //de implementat metoda care va returna taskurile in functie de utilizator
    //de implementat metoda care va returna taskurile in functie de utilizator si prioritate
    //metoda pentru taskuri in functie de prioritate
}
