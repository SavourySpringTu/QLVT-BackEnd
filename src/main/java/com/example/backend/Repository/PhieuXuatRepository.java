package com.example.backend.Repository;

import com.example.backend.Entity.PhieuXuatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuXuatRepository extends JpaRepository<PhieuXuatEntity,String> {
}
