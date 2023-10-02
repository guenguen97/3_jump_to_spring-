package com.example.demo3.Answer;

import com.example.demo3.Question.Question;
import com.example.demo3.Question.QuestionRepository;
import com.example.demo3.Question.QuestionService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@RequestMapping("/answer")
@Controller
public class AnswerController {
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    QuestionService questionService;
    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id , @RequestParam String content){
        Question question = this.questionService.getQuestion(id);
        Answer answer =new Answer();
        answer.setCreateDate(LocalDateTime.now());
        answer.setContent(content);
        answer.setQuestion(question);
        this.answerRepository.save(answer);

        return String.format("redirect:/question/detail/%s",id);

    }
}
