package com.mayweather.hearthstone.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BoostingOrder extends Order implements Serializable {

    @Column(name = "salaryPerRank")
    private int salaryPerRank;

    @Column(name = "fromRank")
    private int fromRank;

    @Column(name = "toRank")
    private int toRank;
}
