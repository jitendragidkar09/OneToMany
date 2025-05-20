package com.example.OneToMany.service;

import com.example.OneToMany.entity.Question;
import com.example.OneToMany.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(Question question){
        return questionRepository.save(question);
    }

    public Optional<Question> findQuestionById(Integer questionId) {
        if (questionId == null) {
            throw new IllegalArgumentException("Question ID cannot be null");
        }

        return Optional.ofNullable(questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("No question present with given questionId: " + questionId)));
    }

    public void deleteQuestionById(Integer questionId){
        questionRepository.deleteById(questionId);
    }

    public Question updateQuestion(Question question){
        Integer questionId = question.getQuestionId();
        Question oldQuestion = questionRepository.findById(questionId).get();
        oldQuestion.setQuestion(question.getQuestion());
        oldQuestion.setAnswers(question.getAnswers());
        Question question1 = questionRepository.save(oldQuestion);
        return question1;
    }
}
