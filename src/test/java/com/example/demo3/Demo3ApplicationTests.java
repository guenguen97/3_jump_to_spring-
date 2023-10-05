package com.example.demo3;

import com.example.demo3.Answer.Answer;
import com.example.demo3.Answer.AnswerRepository;
import com.example.demo3.Question.Question;
import com.example.demo3.Question.QuestionRepository;
import com.example.demo3.Question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
class Demo3ApplicationTests {
	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	QuestionService questionService;

	@Autowired
	AnswerRepository answerRepository;
	@Test
	void contextLoads() {
		for (int i = 1; i <= 300; i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용무";
			this.questionService.create(subject, content);
		}


	}

}
