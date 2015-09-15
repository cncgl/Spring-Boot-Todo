package jp.cogel.springboot.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Todo を扱う REST コントローラー
 * Created by shigeru on 15/09/15.
 */
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @RequestMapping(method=RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String show(@PathVariable int id) {
        return "show:" + id;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String create() {
        return "create";
    }

    @RequestMapping(value="/{id}", method={RequestMethod.PUT, RequestMethod.PATCH})
    public String update(@PathVariable int id) {
        return "update:" + id;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String delete(@PathVariable int id) {
        return "delete:" + id;
    }

}
