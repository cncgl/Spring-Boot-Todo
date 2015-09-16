package jp.cogel.springboot.jpa;

/**
 * Created by shigeru on 15/09/15.
 */
import jp.cogel.springboot.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Query("Select x From Todo x ORDER BY x.id")
    List<Todo> findAllOrderById();

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Todo c SET c.status = :status, c.title = :title WHERE c.id = :id")
    int updateTodo(@Param("id") int id, @Param("status") boolean status, @Param("title") String title);
}