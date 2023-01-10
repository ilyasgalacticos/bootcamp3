package kz.bitlab.bootcamp3.bootcamp3spring.service;


import kz.bitlab.bootcamp3.bootcamp3spring.model.BitlabStudent;
import kz.bitlab.bootcamp3.bootcamp3spring.model.Subject;
import kz.bitlab.bootcamp3.bootcamp3spring.repository.StudentRepository;
import kz.bitlab.bootcamp3.bootcamp3spring.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public List<BitlabStudent> getAllStudents(){
        return studentRepository.findAllByOrderByGpaDesc();
    }

    public BitlabStudent addStudent(BitlabStudent student){
        student.setLink(student.getName().toLowerCase() + "-" + student.getSurname().toLowerCase());
        return studentRepository.save(student);
    }

    public BitlabStudent saveStudent(BitlabStudent student){
        student.setLink(student.getName().toLowerCase() + "-" + student.getSurname().toLowerCase());
        return studentRepository.save(student);
    }

    public BitlabStudent getStudent(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public BitlabStudent assignSubject(Long studentId, Long subjectId){
        BitlabStudent student = studentRepository.findById(studentId).orElseThrow();
        Subject subject = subjectRepository.findById(subjectId).orElseThrow();

        List<Subject> subjects = student.getSubjects();
        if (subjects == null) {
            subjects = new ArrayList<>();
        }
        subjects.add(subject);
        return studentRepository.save(student);
    }

    public BitlabStudent unAssignSubject(Long studentId, Long subjectId){
        BitlabStudent student = studentRepository.findById(studentId).orElseThrow();
        Subject subject = subjectRepository.findById(subjectId).orElseThrow();

        List<Subject> subjects = student.getSubjects();
        if (subjects == null) {
            subjects = new ArrayList<>();
        }
        subjects.remove(subject);
        return studentRepository.save(student);
    }

    public List<BitlabStudent> search(String key, String order){
        List<BitlabStudent> students = null;
        if(order!=null){
            if(order.equals("desc")){
                students = studentRepository.findAllByNameIsLikeOrderByGpaDesc("%"+key.toLowerCase()+"%");
            }
        }
        if(students==null){
            students = studentRepository.findAllByNameIsLikeOrderByGpaAsc("%"+key.toLowerCase()+"%");
        }
        return students;
    }

    public void deleteStudent(BitlabStudent student){
        studentRepository.deleteById(student.getId());
    }
}