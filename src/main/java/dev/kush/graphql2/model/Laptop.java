package dev.kush.graphql2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Laptop {

    @Id  @GeneratedValue
    private Long laptopId;
    private String brand;
    private String model;
    private BigDecimal price;
    private Boolean isOnSale;

    @ManyToOne(cascade = {DETACH,PERSIST,REFRESH,MERGE})
    @JoinColumn(name = "student_id",referencedColumnName = "studentId")
    @JsonIgnore
    private Student student;

    public Laptop(String brand, String model, BigDecimal price, Boolean isOnSale, Student student) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.isOnSale = isOnSale;
        this.student = student;
    }

    public Laptop(String brand, String model, BigDecimal price, Boolean isOnSale) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.isOnSale = isOnSale;
    }
}
