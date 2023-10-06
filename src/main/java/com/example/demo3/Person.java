package com.example.demo3;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;





    @OneToMany(mappedBy = "person",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hobby> hobby;

    private LocalDateTime createDate;
}
