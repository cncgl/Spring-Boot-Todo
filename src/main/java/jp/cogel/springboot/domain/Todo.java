package jp.cogel.springboot.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Todo のエンティティを表すクラス
 * Created by cncgl on 15/09/15.
 */
@Entity
@Table(name="todos")
public class Todo implements Serializable {
    private static final long serialVersionUID = 1835127006838671512L;

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="todos_id_seq")
    @SequenceGenerator(name="todos_id_seq", sequenceName="todos_id_seq", allocationSize=1)
    @Column(name="id")
    public Integer id;
    @Column(name="status")
    public boolean status;
    @Column(name="title")
    public String title;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date inserted_at;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Version
    public Date updated_at;


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
    public void setId(Integer id) {
        this.id = id;
    }
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    @PrePersist
    public void updateInsertedAt() {
        this.inserted_at = new Date();
    }

    @PreUpdate
    public void updateUpdatedAt() {
        this.updated_at = new Date();
    }

    // オーバーライド
    //----------------------------
    @Override
    public String toString() {
        return "Todo {id:"+id+", status:"+status+", title:"+title
                +" inserted_at:"+inserted_at+". updated_at:"+updated_at+"}";
    }
}
