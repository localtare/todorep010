package com.ucxmarket.todo.todoapp.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Table;


@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    public enum ActiveStatus{
        ONLINE,
        OFFLINE;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    private Date birth_date;

    @Enumerated(EnumType.STRING)
    private ActiveStatus activeStatus;

    /*@OneToMany(targetEntity = Task.class,mappedBy = "user",cascade = CascadeType.ALL)
    //@JoinColumn(name = "user_id", referencedColumnName = "id")
    List<Task> tasks ;

     */

    @OneToMany(targetEntity = Task.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ut_fid", referencedColumnName = "id")
    List<Task> tasks = new ArrayList<>();
}



