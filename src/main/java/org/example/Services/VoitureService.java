package org.example.Services;

import org.example.Repoitory.VoitureRepository;
import org.example.entities.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureService {


    private final VoitureRepository voitureRepository;

    @Autowired
    public VoitureService(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll();
    }

    public Voiture getVoitureById(int id) {
        return voitureRepository.findById(id).orElse(null);
    }

    public void addVoiture(Voiture voiture){
        voitureRepository.save(voiture);
    }

    public void addVoitures(List<Voiture> voitures){
        voitureRepository.saveAll(voitures);
    }



//    public void subcribeToLibrary(int userId, int libraryId) {
//        Library library = libraryRepository.findById(libraryId).orElse(null);
//        User user = userRepository.findById(userId).orElse(null);
//        library.getUsers().add(user);
//        System.out.println("User " + user.getName() + " subscribed to library " + library.getName());
//        libraryRepository.save(library);
//    }
//
//    public void unSubcribeFromLibrary(int userId, int libraryId) {
//        Library library = libraryRepository.findById(libraryId).orElse(null);
//        User user = userRepository.findById(userId).orElse(null);
//        library.getUsers().remove(user);
//        System.out.println("User " + user.getName() + " unsubscribed from library " + library.getName());
//        libraryRepository.save(library);
//    }
//
//    public Library getLibraryByName(String name){
//        return libraryRepository.findByName(name);
//    }
//
//    public Library getLibraryById(int id){
//        return libraryRepository.findById(id).orElse(null);
//    }
//
//    public List<Library> getAllLibraries() {
//        return libraryRepository.findAll();
//    }

}
