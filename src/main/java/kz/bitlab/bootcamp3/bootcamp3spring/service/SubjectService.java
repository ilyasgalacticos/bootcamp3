package kz.bitlab.bootcamp3.bootcamp3spring.service;

import kz.bitlab.bootcamp3.bootcamp3spring.model.BitlabStudent;
import kz.bitlab.bootcamp3.bootcamp3spring.model.Subject;
import kz.bitlab.bootcamp3.bootcamp3spring.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }

    public List<Subject> getPossibleSubjects(BitlabStudent student){
        List<Subject> subjects = subjectRepository.findAll();
        subjects.removeAll(student.getSubjects());
        return subjects;
    }

}