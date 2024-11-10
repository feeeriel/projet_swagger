package tn.esprit.Feryal_yahyaoui_4twin5.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Feryal_yahyaoui_4twin5.entities.Piste;
import tn.esprit.Feryal_yahyaoui_4twin5.entities.Skier;
import tn.esprit.Feryal_yahyaoui_4twin5.entities.enums.Color;
import tn.esprit.Feryal_yahyaoui_4twin5.repositories.IPisteRepository;
import tn.esprit.Feryal_yahyaoui_4twin5.repositories.ISkierRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service

public class SkierServicesImpl implements ISkierServices {

    private ISkierRepository skierRepository;
    private IPisteRepository pisteRepository;
    @Override
    public Skier addSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier updateSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier retrieveSkier(Long numSkier) {
        return skierRepository.findById(numSkier).orElse(null);
    }

    @Override
    public List<Skier> retrieveAll() {
        return (List<Skier>) skierRepository.findAll();
    }

    @Override
    public void removeSkier(long numSkier) {
     skierRepository.deleteById(numSkier);
    }

    @Override
    public void assignSkierToPiste(Long numSkier, Long numPiste) {
        Skier skier = skierRepository.findById(numSkier).orElse(null);
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
        piste.getSkiers().add(skier);
        pisteRepository.save(piste);


    }
    @Override
    public Skier getByFirstNameAndLastName(String firstName,String lastName){
        return skierRepository.findByFirstNameAndLastName(firstName,lastName);
    }
    public Set<Skier> getByBirthDate(LocalDate birthDate) {
        return skierRepository.findByBirthDate(birthDate);
    }

    public Skier findSkierByNumskier(Long numSkier){
        return skierRepository.findById(numSkier).orElse(null);
    }
    @Override
    public List<Skier> assignSkierToPiste(String firstName, String lastName, Color color){
        List<Skier> skier = skierRepository.findSkierByFirstNameAndLastName(firstName,lastName);
        List<Piste> piste = pisteRepository.findPisteByColor(color);
        for(Skier s : skier) {
            for(Piste p : piste) {
                s.getPistes().add(p);
            }
            skierRepository.save(s);
        }
        return skier;
    }


}
