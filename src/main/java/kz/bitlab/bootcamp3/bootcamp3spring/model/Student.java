package kz.bitlab.bootcamp3.bootcamp3spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Long id;
    private String name;
    private String surname;
    private double gpa;
    private String link;
}
