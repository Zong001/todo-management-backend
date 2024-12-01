package net.javaguides.todo_management.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.todo_management.dto.TodoDto;
import net.javaguides.todo_management.entity.Todo;
import net.javaguides.todo_management.repository.TodoRepository;
import net.javaguides.todo_management.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;
    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        // convert TodoDto into Todo Jpa entity
        Todo todo = modelMapper.map(todoDto,Todo.class);

        Todo savedTodo =  todoRepository.save(todo);

        //convert saved Todo Jpa entity object into TodoDto object
        TodoDto savedTodoDto = modelMapper.map(savedTodo,TodoDto.class);
        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo todo = todoRepository.findById(id).get();
        return modelMapper.map(todo,TodoDto.class);
    }
}
