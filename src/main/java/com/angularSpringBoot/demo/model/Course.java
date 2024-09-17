package com.angularSpringBoot.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity // Declara como uma entidade e casos não defina o @Table, vai criar a tabela com o mesmo nome
//@Table(name = "cursos") Realiza a criação da tabela com um nome específico
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String category;
}
