package com.ex.Entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "marks")
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long maths;

    private Long science;

    private Long social;

    private Long physics;

    @OneToOne
    @JoinColumn(name = "student_id")
    private School  school;

}