package com.adrar.cdafad.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.sql.Date;
import com.adrar.cdafad.entity.Game;
@Entity
@Table(name="utilisateur")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, length = 50)
    private String firstname;
    @Column(nullable = false, length = 50)
    private String lastname;

    @Column(nullable=true)
    @OneToMany(
            mappedBy = "users",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Game> games;

}
