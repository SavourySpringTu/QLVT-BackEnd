package com.example.backend.Repository;

import com.example.backend.Entity.CTPNEntity;
import com.example.backend.Entity.CTPNID;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CTPNRepository extends JpaRepository<CTPNEntity, CTPNID> {
    @Modifying
    @Query(value = "INSERT INTO ctpn(mapn,mavt,soluong,dongia) VALUES (?1,?2,?3,?4)",nativeQuery = true)
    void insertCTPN(String mapn,String mavt,String soluong,String dongia);
}
