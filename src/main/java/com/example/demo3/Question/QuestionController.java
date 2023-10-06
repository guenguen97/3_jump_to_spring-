package com.example.demo3.Question;


import com.example.demo3.Answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page){
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging" , paging);



        return "question_list";
    }
}
