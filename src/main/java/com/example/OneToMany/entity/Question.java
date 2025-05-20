package com.example.OneToMany.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer questionId;
    private String question;
    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Answer> answers;
}
