package com.example.demo3;

import com.example.demo3.Answer.Answer;
import com.example.demo3.Answer.AnswerRepository;
import com.example.demo3.Question.Question;
import com.example.demo3.Question.QuestionRepository;
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
	AnswerRepository answerRepository;
	@Test
	void contextLoads() {
		Optional<Question>  q= this.questionRepository.findById(2);

		Question q2=q.get();

		Answer a = new Answer();
		a.setContent("자동생성 됩니다.");
		a.setQuestion(q2);
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);




	}

}
