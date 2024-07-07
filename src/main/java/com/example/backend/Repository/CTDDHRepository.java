package com.example.backend.Repository;

import com.example.backend.Entity.CTDDHEntity;
import com.example.backend.Entity.CTDDHID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CTDDHRepository extends JpaRepository<CTDDHEntity, CTDDHID> {
    @Modifying
    @Query(value = "INSERT INTO ctddh (maddh,mavt,soluong,dongia) VALUES (?1,?2,?3,?4)",nativeQuery = true)
    void save(String maddh, String mavt, String soluong, String dongia);
}
