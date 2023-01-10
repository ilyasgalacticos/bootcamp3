package kz.bitlab.bootcamp3.bootcamp3spring.db;

import kz.bitlab.bootcamp3.bootcamp3spring.model.Student;

import java.util.ArrayList;

public class DBManager {

    private static ArrayList<Student> students = new ArrayList<>();

    private static Long id = 8L;

    static {
        students.add(new Student(1L, "Ilyas", "Zhuanyshev", 3.4, "ilyas-zhuanyshev"));
        students.add(new Student(2L, "Almas", "Maratov", 1.9, "almas-maratov"));
        students.add(new Student(3L, "Erzhan", "Erikov", 1.5, "erzhan-erikov"));
        students.add(new Student(4L, "Madina", "Berikova", 3.6, "medina-berikova"));
        students.add(new Student(5L, "Karina", "Serikova", 4.0, "karina-serikova"));
        students.add(new Student(6L, "Marina", "Serikova", 3.2, "marina-serikova"));
        students.add(new Student(7L, "Darina", "Serikova", 4.0, "darina-serikova"));
    }

    public static ArrayList<Student> getStudents(){
        return students;
    }

    public static void addStudent(Student student){
        student.setLink(student.getName().toLowerCase()+"-"+student.getSurname().toLowerCase());
        student.setId(id);
        students.add(student);
        id++;
    }

    public static Student getStudent(Long id){
        return students
                .stream()
                .filter(student -> student.getId()==id)
                .findFirst()
                .orElse(null);
    }

}
