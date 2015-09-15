package jp.cogel.springboot.jpa;

/**
 * Created by shigeru on 15/09/15.
 */
import jp.cogel.springboot.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}