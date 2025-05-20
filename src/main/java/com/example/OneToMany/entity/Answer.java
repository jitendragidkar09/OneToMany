package com.example.OneToMany.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer answerId;
    private String answer;
    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="questionId")
    @JsonBackReference
    private Question question;
}
