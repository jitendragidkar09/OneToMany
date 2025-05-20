package com.example.OneToMany.controller;

import com.example.OneToMany.entity.Answer;
import com.example.OneToMany.service.AnswerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {

        this.answerService = answerService;
    }

    @PostMapping
    public Answer postAnswer(@RequestBody Answer answer){
        return answerService.createAnswer(answer);
    }

    @GetMapping("/{answerId}")
    public Answer getAnswerById(@PathVariable Integer answerId){
        return answerService.findAnswerById(answerId).get();
    }

    @DeleteMapping("/{answerId}")
    public void deleteAnswerById(@PathVariable Integer answerId){
         answerService.deleteAnswerById(answerId);
    }

    @PutMapping
    public Answer updateAnswer(@RequestBody Answer answer){
        return answerService.updateAnswer(answer);
    }
}
