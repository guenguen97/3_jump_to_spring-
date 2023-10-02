package com.example.demo3.Question;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("/question")
@Controller
public class QuestionController {


    @Autowired
    QuestionService questionService;


    @GetMapping("/list")
    public String showList(Model model){

        List<Question> questions = this.questionService.getList();
        model.addAttribute("questionList", questions);


        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question" , question);
        return "question_detail";
    }
}
