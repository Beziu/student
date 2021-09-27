package com.myproject.student.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity                                             // @Entity jest informacja dla JPA
@Table(name = "student")                            // @Table musi byc użyty, aby zmienne zostały
public class Student {                              // powiązane z nazwami kolumn w tabeli.
                                                    // Dodanie nazwy tabeli nie jest obowiązkowe
    @Column(nullable = false)
    @Id                                             // @Id Tworzy primary key
    @SequenceGenerator(                             // Generator dla ID, określa rozmiar ID
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;

    @Column(name = "name", nullable = false)        // Można zapisać @Column oraz nazwy
    private String name;                            // kolumn lub uczyć @SequenceGenerator

    @Column(name = "email", nullable = false)
    private String email;
    private LocalDate dob;

    @Transient                                      // Tworzy wirtualną kolumnę, obliczana ona jest
    private Integer age;                            // z bieżącej daty, niezapisywana w tabeli.

    public Student() {
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }

}
