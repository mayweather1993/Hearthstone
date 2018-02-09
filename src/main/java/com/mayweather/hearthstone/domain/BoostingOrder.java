package com.mayweather.hearthstone.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class BoostingOrder extends Order implements Serializable {


    @Column(name = "fromRank")
    private int fromRank;

    @Column(name = "toRank")
    private int toRank;
}
