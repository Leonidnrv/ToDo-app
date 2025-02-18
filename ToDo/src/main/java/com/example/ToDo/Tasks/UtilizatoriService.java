package com.example.ToDo.Tasks;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilizatoriService {

    @Autowired
    private UtilizatoriRepository utilizatoriRepository;

    public List<Utilizator> getAllUtilizatori(){
        //Returneaza toti utilizatorii din baza de date
        return utilizatoriRepository.findAll();
    }

    public List<Utilizator> getUtilizatorById(Long id){
        return utilizatoriRepository.getUtilizatorById(id);
    }

    public List<Utilizator> getUtilizatorByNume(String nume){
        return utilizatoriRepository.getUtilizatorByNume(nume);
    }

    public Utilizator saveUtilizator(Utilizator utilizator){
        if(utilizatoriRepository.existsByNume(utilizator.getNume())){
            throw new IllegalArgumentException("Utilizatorul cu nume " + utilizator.getNume() + " exista deja in sistem!");
        }
        return utilizatoriRepository.save(utilizator);
    }

    @Transactional //transactional face ca metoda sa faca flush la date (sa le imprime sau sa le stearga din baza de date) abia dupa ce se executa metoda si nu intoarce vreo exceptie!
    //Cu asta noi ne vom asigura ca operatia este executata intr-un context transactional
    public void deleteUtilizator(String nume){
        if(!utilizatoriRepository.existsByNume(nume)){ //verificam daca gasim utilizatorul in baza de date. Daca nu-l gasim, vom arunca exceptie
            throw new IllegalArgumentException("Utilizatorul cu numele " + nume + " nu exista in sistem!");
        }
        utilizatoriRepository.deleteByNume(nume);
    }
}
