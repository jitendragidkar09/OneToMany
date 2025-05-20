package com.example.OneToMany.service;

import com.example.OneToMany.entity.Answer;
import com.example.OneToMany.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer createAnswer(Answer answer){
        return answerRepository.save(answer);
    }

    public Optional<Answer> findAnswerById(Integer answerId) {
        if (answerId == null) {
            throw new IllegalArgumentException("Answer ID cannot be null");
        }

        return Optional.ofNullable(answerRepository.findById(answerId)
                .orElseThrow(() -> new RuntimeException("No Answer present with given AnswerId: " + answerId)));
    }

    public void deleteAnswerById(Integer answerId){
        answerRepository.deleteById(answerId);
    }

    public Answer updateAnswer(Answer answer){
        Integer answerId = answer.getAnswerId();
        Answer oldAnswer = answerRepository.findById(answerId).get();
        oldAnswer.setAnswer(answer.getAnswer());
        oldAnswer.setQuestion(answer.getQuestion());
        Answer answer1 = answerRepository.save(oldAnswer);
        return answer1;
    }
}
