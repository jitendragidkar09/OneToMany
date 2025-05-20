package com.example.OneToMany.controller;

import com.example.OneToMany.entity.Question;
import com.example.OneToMany.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question postQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

    @GetMapping("/{questionId}")
    public Question getQuestionById(@PathVariable Integer questionId){
        return questionService.findQuestionById(questionId).get();
    }

    @DeleteMapping("/{questionId}")
    public void deleteQuestionById(@PathVariable Integer questionId){
         questionService.deleteQuestionById(questionId);
    }

    @PutMapping
    public Question updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }
}
