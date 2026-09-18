package com.example.SpringJPA.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String foodname;
    double price;
    @Column(name = "is_available")
    boolean available;

}
