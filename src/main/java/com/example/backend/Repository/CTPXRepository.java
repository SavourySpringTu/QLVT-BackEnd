package com.example.backend.Repository;

import com.example.backend.Entity.CTPXEntity;
import com.example.backend.Entity.CTPXID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTPXRepository extends JpaRepository<CTPXEntity, CTPXID> {
}
