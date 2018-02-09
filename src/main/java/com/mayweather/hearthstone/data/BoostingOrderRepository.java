package com.mayweather.hearthstone.data;

import com.mayweather.hearthstone.domain.BoostingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoostingOrderRepository extends JpaRepository<BoostingOrder, Long> {
}
