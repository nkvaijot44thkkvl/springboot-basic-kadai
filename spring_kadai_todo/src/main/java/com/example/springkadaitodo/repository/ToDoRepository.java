package com.example.springkadaitodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springkadaitodo.entity.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo , Integer>{
	//List<ToDo> findByToDoTitle(String Title);
}


/*public class ToDoRepository {

	public static void main(String[] args) {

	}

}*/
