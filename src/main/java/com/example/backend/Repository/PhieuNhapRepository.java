package com.example.backend.Repository;

import com.example.backend.Entity.PhieuNhapEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface PhieuNhapRepository extends JpaRepository<PhieuNhapEntity,Long> {
    @Modifying
    @Query(value = "SELECT * FROM phieunhap WHERE maddh=?1",nativeQuery = true)
    List<PhieuNhapEntity> findByMaDDH(String maddh);
}
