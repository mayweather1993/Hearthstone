package com.mayweather.hearthstone.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    private int fromRank;

    private int toRank;

}
