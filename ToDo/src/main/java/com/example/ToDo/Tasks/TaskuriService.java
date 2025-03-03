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

    //intoarce task-urile in functie de utilizator
    public List<Taskuri> getTasksByUser(String numeUtilizator){
        return taskuriRepository.getTaskByUser(numeUtilizator);
    }

    //Intoarce task-urile in functie de utilizator si prioritate
    public List<Taskuri> getTasksByUserAndPriority(String numeUtilizator, String prioritateTask){
        return taskuriRepository.getTaskByUserAndPriority(numeUtilizator, prioritateTask);
    }

    //Intoarce task-urile in functie de utilizator si numele taskului
    public List<Taskuri> getTasksByUserAndTaskname(String numeUtilizator, String taskName){
        return taskuriRepository.getTaskByUserAndTaskname(numeUtilizator, taskName);
    }


    //1.de studiat cum va functiona metoda pentru ca este posibil sa facem overload la ea. Daca se completeaza si descrierea + alte campuri optionale.
    public Taskuri saveTask(String titlu, String nume_utilizator, String descriere, String status /*va trebui validat*/,LocalDateTime due_date, String prioritate /*va trebui validat*/){
        Taskuri taskNou;
        if(verificareExistentaUtilizator(nume_utilizator)){ //verificam daca utilizatorul exista
            //De adaptat codul pentru formatul de data:
            // DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            // LocalDateTime localDate = LocalDateTime.of(2025,03,25,23,0);
            // String dataFinala = localDate.format(dateTimeFormatter);
            // System.out.println("Data finala: " + dataFinala);

            //Va trebui sa stocam user_id si id_task. Motivul este ca
            //Vom primi numele utilizatorului si trebuie gasit id-ul lui in baza de date
            //Vom primi titlul task-ului si va trebui sa gasim id-ul lui in baza de date
            Long user_id = returnIdByNumeUtilizator(nume_utilizator); //stocam id-ul utilizatorului
            Long id_task = returnIdByTitluTask(titlu);
            if(id_task != null){
                taskNou = new Taskuri(id_task, titlu, descriere, status, due_date, prioritate, user_id);//cream entitatea task
            }else{
                taskNou = new Taskuri(titlu, descriere, status, due_date, prioritate, user_id);
            }
            //Daca task-ul exista, atunci taskNou va trebui sa aiba specificat si id-ul taskului deci constructorul va avea si id
            //Daca nu exista, atunci tasknou va ignora id-ul si va genera automat din dbms
            taskuriRepository.save(taskNou); //save() va salva task-ul sau va face update daca exista deja linia.
        }else{
            //In else nu se va ajunge niciodata pentru ca tot timpul va primi un utilizator. Task-urile se vor creea doar dupa ce user-ul se logheaza in sistem, deci va exista!
        }
        return null;
    }


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


    public Long returnIdByNumeUtilizator(String nume){//metoda folosita in saveTask(). Daca utilizatorul exista, vom introduce numele lui si se va intoarce id-ul din db
        return utilizatoriRepository.idByNume(nume);
    }


    //metoda folosita pentru a returna id-ul task-ului. Daca nu il gasim vom folosi constructorul care nu primeste idul de task
    public Long returnIdByTitluTask(String titlu){
        return taskuriRepository.getTaskIDByTitlu(titlu);
    }

}
