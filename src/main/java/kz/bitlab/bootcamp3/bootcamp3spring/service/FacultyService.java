package kz.bitlab.bootcamp3.bootcamp3spring.service;

import kz.bitlab.bootcamp3.bootcamp3spring.model.Faculty;
import kz.bitlab.bootcamp3.bootcamp3spring.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public List<Faculty> getFaculties(){
        return facultyRepository.findAll();
    }

}
