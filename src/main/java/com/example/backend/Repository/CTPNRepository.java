package com.example.backend.Repository;

import com.example.backend.Entity.CTPNEntity;
import com.example.backend.Entity.CTPNID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTPNRepository extends JpaRepository<CTPNEntity, CTPNID> {
}
