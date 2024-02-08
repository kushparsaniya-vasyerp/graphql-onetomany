package dev.kush.graphql2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {

    @Id   @GeneratedValue
    private Long studentId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    @OneToMany(cascade = ALL,mappedBy = "student")
    private List<Laptop> laptops;

    public Student(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Student(String firstName, String lastName, String phoneNumber, String email, List<Laptop> laptops) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.laptops = laptops;
    }
}
