package com.example.backend.Repository;

import com.example.backend.Entity.DatHangEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface DatHangRepository extends JpaRepository<DatHangEntity,Long> {
    @Modifying
    @Query(value = "INSERT INTO dathang (ngay,nhacc,makho,manv) VALUES (?1,?2,?3,?4)",nativeQuery = true)
    void save (String ngay,String nhacc,String makho,String manv);

    @Query(value = "UPDATE dathang SET nhacc = ?1 WHERE maddh = ?2",nativeQuery = true)
    void updateByMaDDH(String nhacc,Long maddh);
}
