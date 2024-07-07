package com.example.backend.Repository;

import com.example.backend.Entity.PhieuNhapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuNhapRepository extends JpaRepository<PhieuNhapEntity,Long> {
}
