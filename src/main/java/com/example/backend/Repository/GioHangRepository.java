package com.example.backend.Repository;

import com.example.backend.Entity.GioHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangRepository extends JpaRepository<GioHangEntity, Long> {
}
