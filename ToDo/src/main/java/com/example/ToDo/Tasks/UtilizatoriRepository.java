package com.example.ToDo.Tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UtilizatoriRepository extends JpaRepository<Utilizator, Long> {
    //Nu trebuie sa adaugam neaparat metode aici; JpaRepository are deja metode precum findAll(), save(), delete()

    //Metoda folosita pentru a aduce utilizatorii in functie de id-ul dorit.
    //Temporar vom folosi acest query pana se va dezvolta RestControllerAdvice
    @Query(value = "SELECT * FROM users u WHERE u.id = :id", nativeQuery = true)
    List<Utilizator> getUtilizatorById(@Param("id") Long id);

    boolean existsByNume(String nume); //aici Spring va genera un query automat de forma 'SELECT count(*) > 0 FROM user WHERE nume = ?'

    @Query(value = "SELECT DISTINCT id FROM users u WHERE u.nume = :nume", nativeQuery = true)
    Long idByNume(@Param("nume") String nume);//aceasta functie primeste numele unui utilizator si intoarce id-ul din tabela users (folosita la salvarea de task-uri)


    void deleteByNume(String nume); //Spring va genera automat un cod SQL: 'DELETE FROM user WHERE nume = ?'

    List<Utilizator> getUtilizatorByNume(String nume);
}
