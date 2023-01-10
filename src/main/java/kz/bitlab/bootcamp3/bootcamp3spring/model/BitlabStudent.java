package kz.bitlab.bootcamp3.bootcamp3spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "t_students")
@Getter
@Setter
public class BitlabStudent {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    @Column(name = "id")
    private Long id;

    @Column(name = "student_name", length = 200)
    private String name;

    @Column(name = "student_surname")
    private String surname;

    @Column(name = "gpa")
    private double gpa;

    @Column(name = "link", columnDefinition = "TEXT")
    private String link;

    @ManyToOne(fetch = FetchType.LAZY)
    private Faculty faculty;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Subject> subjects;

}
