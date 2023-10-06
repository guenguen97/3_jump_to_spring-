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
import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
class Demo3ApplicationTests {
	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	QuestionService questionService;

	@Autowired
	AnswerRepository answerRepository;


	@Autowired
	PersonRepository personRepository;


	@Test
	void contextLoads() {
//		for (int i = 1; i <= 300; i++) {
//			String subject = String.format("테스트 데이터입니다:[%03d]", i);
//			String content = "내용무";
//			this.questionService.create(subject, content);
//		}

		Person person = new Person();
		Hobby soccerHobby = new Hobby();
		soccerHobby.setName("soccer");
		soccerHobby.setPerson(person);

		Hobby basketballHobby = new Hobby();
		basketballHobby.setName("basketball");
		basketballHobby.setPerson(person);

		person.setHobby(Arrays.asList(soccerHobby, basketballHobby));

// Save the person and their associated hobbies
		personRepository.save(person);

		System.out.println(person.getHobby().get(0).getName());


		Person person2 = new Person();
		Hobby soccerHobby2 = new Hobby();
		soccerHobby2.setName("swim");
		soccerHobby2.setPerson(person2);

		Hobby basketballHobby2 = new Hobby();
		basketballHobby2.setName("fly");
		basketballHobby2.setPerson(person2);

		person2.setHobby(Arrays.asList(soccerHobby2, basketballHobby2));

// Save the person and their associated hobbies
		personRepository.save(person2);






	}

}
