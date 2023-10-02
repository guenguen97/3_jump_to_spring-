package com.example.demo3.Answer;

import com.example.demo3.Question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;
    public Answer create(Question question, String content) {
        Answer answer =new Answer();
        answer.setCreateDate(LocalDateTime.now());
        answer.setContent(content);
        answer.setQuestion(question);
        this.answerRepository.save(answer);
        return answer;
    }


}
