package com.example.ToDo.Tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskuriRepository extends JpaRepository<Taskuri, Long> {

    //Metoda folosita pentru a aduce task-urile in functie de numele unui utilizator ca parametru
    @Query(value = "SELECT t.* FROM tasks t INNER JOIN users u ON u.id = t.user_id AND u.nume = :numeUtilizator", nativeQuery = true)
    List<Taskuri> getTaskByUser(@Param("numeUtilizator") String numeUtilizator);

    //Aduce task-urile in functie de nume utilizator si prioritate task
    @Query(value = "SELECT t.* " +
                   "FROM tasks t " +
                   "INNER JOIN users u ON u.id = t.user_id AND u.nume = :numeUtilizator AND t.prioritate = :prioritateTask", nativeQuery = true)
    List<Taskuri> getTaskByUserAndPriority(@Param("numeUtilizator") String numeUtilizator, @Param("prioritateTask") String prioritateTask);

    //Aduce id-ul task-ului dupa numele lui. Folosim aceasta metoda la update-ul unui task deja existent.
    // Daca nu punem si id-ul task-ului, se va genera un task-nou in db si noi vrem doar sa-i facem update
    @Query(value = "SELECT DISTINCT id FROM tasks t WHERE t.titlu = :titlu", nativeQuery = true)
    Long getTaskIDByTitlu(@Param("titlu") String titlu);
}
