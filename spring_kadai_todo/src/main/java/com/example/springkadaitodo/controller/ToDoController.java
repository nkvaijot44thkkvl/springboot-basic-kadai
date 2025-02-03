package com.example.springkadaitodo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.service.ToDoService;

@RequestMapping("")
@Controller
public class ToDoController {
	private final ToDoService toDoService;
	
	public ToDoController(ToDoService toDoService) {
		this.toDoService = toDoService;
	}
	
	@GetMapping("/todo")
	
	public String todoView(Model model) {
		//最新のToDoリストを取得
		List<ToDo> todos = toDoService.getAllToDos();
		
		//ビューにToDoリストを返す
		model.addAttribute("todos",todos);
		return "todoView";
	}
	

}
