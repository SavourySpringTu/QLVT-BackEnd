package com.example.backend.Repository;

import com.example.backend.Entity.KhachHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHangEntity, Long> {

}
