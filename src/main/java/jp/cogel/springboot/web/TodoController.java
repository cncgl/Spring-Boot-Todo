package jp.cogel.springboot.web;

import jp.cogel.springboot.domain.Todo;
import jp.cogel.springboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Todo を扱う REST コントローラー
 * Created by shigeru on 15/09/15.
 */
@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    TodoService todoService;

    @RequestMapping(method=RequestMethod.GET)
    public List<Todo> index() {
        //return "index";
        List<Todo> todos = todoService.findAll();
        return todos;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Todo show(@PathVariable Integer id) {
        //return "show:" + id;
        Todo todo = todoService.findOne(id);
        return todo;
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@RequestBody Todo todo) {
        //return "create";
        return todoService.create(todo);
    }

    @RequestMapping(value="/{id}", method={RequestMethod.PUT, RequestMethod.PATCH})
    public Todo update(@PathVariable int id, @RequestBody Todo todo) {
        //return "update:" + id;
        todo.setId(Integer.valueOf(id));
        //System.out.println(todo);
        return todoService.update(todo);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        //return "delete:" + id;
        todoService.delete(id);
    }

}
