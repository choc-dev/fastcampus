package kr.choc.home.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kr.choc.home.model.Question;
import kr.choc.home.model.QuestionRepository;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@GetMapping("/questions")
	public String show(Model model) {
		model.addAttribute("questions", questionRepository.findAll());
		return "redirect:/";
	}
	
	@PostMapping("/qna/question")
	public String question(Question question){
		questionRepository.save(question);
		System.out.println(question);
		return "redirect:/questions";
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("questions", questionRepository.findAll());
		return "/index";
	}
}
