package com.mayweather.hearthstone.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booster")
public class Booster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String description;

    private Long ordersCompleted;

    private LocalDate lastActive;

    @Enumerated
    private Status status;
}
