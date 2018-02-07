package com.mayweather.hearthstone.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderDetails")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int salaryPerRank;

    @Max(value = 25)
    @Min(value = 1)
    private int fromRank;

    @Max(value = 10)
    private int toRank;
}
