package com.example.demo3.Question;


import com.example.demo3.Answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.List;


@RequestMapping("/question")
@Controller
@RequiredArgsConstructor
public class QuestionController {



    private final QuestionService questionService;


    @GetMapping("/list")
    public String showList(Model model){

        List<Question> questions = this.questionService.getList();
        model.addAttribute("questionList", questions);


        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id , AnswerForm answerForm){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question" , question);


        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm){
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm , BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(),questionForm.getContent());
        return "redirect:/question/list";
    }
}
