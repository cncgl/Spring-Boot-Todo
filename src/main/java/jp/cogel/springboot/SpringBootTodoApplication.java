package jp.cogel.springboot;

import jp.cogel.springboot.domain.Todo;
import jp.cogel.springboot.jpa.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootTodoApplication {

    public static void main(String[] args) {
        /*
        try (ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootTodoApplication.class, args)) {
            SpringBootTodoApplication m = ctx.getBean(SpringBootTodoApplication.class);
            m.method();
        }
        */
        SpringApplication.run(SpringBootTodoApplication.class, args);
    }

    @Autowired
    private TodoRepository repository;

    public void method() {
        this.repository.save(new Todo());
        this.repository.findAll().forEach(System.out::println);
    }
}
