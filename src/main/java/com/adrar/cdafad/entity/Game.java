package com.adrar.cdafad.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String title;
    @Column(length = 255)
    private String description;
    @Column(name = "publish_at")
    @Temporal(TemporalType.DATE)
    private Date publishAt;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
    @ManyToMany
    @JoinTable(name = "game_category",
    joinColumns = @JoinColumn( name = "game_id" ),
    inverseJoinColumns = @JoinColumn( name = "category_id" ) )
    private List<Category> categories = new ArrayList<>();
}
