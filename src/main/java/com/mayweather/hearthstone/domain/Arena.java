package com.mayweather.hearthstone.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "arena_order_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Arena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "arena_order_id")
    private Long id;

    @Column(name = "wins")
    private int wins;

    private int salary;
}
