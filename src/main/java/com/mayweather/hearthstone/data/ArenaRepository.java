package com.mayweather.hearthstone.data;

import com.mayweather.hearthstone.domain.Arena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArenaRepository extends JpaRepository<Arena, Long> {
}
