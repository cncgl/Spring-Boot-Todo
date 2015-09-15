package jp.cogel.springboot.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * Todo のエンティティを表すクラス
 * Created by cncgl on 15/09/15.
 */
@Entity
@Table(name="todos")
public class Todo {
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="todos_id_seq")
    @SequenceGenerator(name="todos_id_seq", sequenceName="todos_id_seq", allocationSize=1)
    @Column(name="id")
    private Integer id;
    @Column(name="status")
    private boolean status;
    @Column(name="title")
    private String title;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date inserted_at;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Version
    private Date updated_at;


    // コンストラクタ
    //---------------------------
    public Todo(boolean status, String title) {
        this.status = status;
        this.title = title;
    }
    public Todo() {
        this(false, "");
    }

    // アクセッサ
    //---------------------------
    @PrePersist
    public void updateInsertedAt() {
        this.inserted_at = new Date();
    }

    @PreUpdate
    public void updateUpdatedAt() {
        this.updated_at = new Date();
    }
}
