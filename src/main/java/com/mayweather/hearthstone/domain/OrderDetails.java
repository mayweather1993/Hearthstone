package com.mayweather.hearthstone.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_Details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Long id;


    @Column(name = "salaryPerRank")
    private int salaryPerRank;

    @Column(name = "fromRank")
    private int fromRank;

    @Column(name = "toRank")
    private int toRank;


}
