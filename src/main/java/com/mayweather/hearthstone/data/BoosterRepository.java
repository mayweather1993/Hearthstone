package com.mayweather.hearthstone.data;

import com.mayweather.hearthstone.domain.Booster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoosterRepository extends JpaRepository<Booster, Long> {
}
