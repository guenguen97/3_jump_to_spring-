package com.example.demo3.Question;


import com.example.demo3.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
public class QuestionService {
        @Autowired
        QuestionRepository questionRepository;
    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Optional<Question> question=this.questionRepository.findById(id);
        if(question.isPresent()){
            return question.get();
        }else {
            throw new DataNotFoundException("question not found");
        }



    }
}
