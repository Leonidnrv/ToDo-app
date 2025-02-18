package com.example.ToDo.Tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskuriRepository extends JpaRepository<Taskuri, Long> {

    //Metoda folosita pentru a aduce task-urile in functie de un id utilizator ca parametru
    @Query(value = "SELECT * FROM tasks t WHERE t.user_id = :id", nativeQuery = true)
    List<Taskuri> getTaskByUser(@Param("id") Long id);

}
