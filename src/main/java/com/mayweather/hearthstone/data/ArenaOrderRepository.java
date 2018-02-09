package com.mayweather.hearthstone.data;

import com.mayweather.hearthstone.domain.ArenaOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArenaOrderRepository extends JpaRepository<ArenaOrder, Long> {
}
