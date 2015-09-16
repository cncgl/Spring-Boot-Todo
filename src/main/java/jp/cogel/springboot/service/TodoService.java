package jp.cogel.springboot.service;

import jp.cogel.springboot.domain.Todo;
import jp.cogel.springboot.jpa.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by shigeru on 15/09/16.
 */
@Service
@Transactional
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAllOrderById();
    }

    public Todo findOne(Integer id) {
        return todoRepository.findOne(id);
    }

    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo update(Todo todo) {
        todoRepository.updateTodo(todo.getId(), todo.status, todo.title);
        return findOne(todo.getId());
    }

    public void delete(Integer id) {
        todoRepository.delete(id);
    }


}
