package com.example.backend.Repository;

import com.example.backend.Entity.DatHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DatHangRepository extends JpaRepository<DatHangEntity,String> {
    @Modifying
    @Query(value = "INSERT INTO dathang (maddh,ngay,nhacc,manv) VALUES (?1,?2,?3,?4)",nativeQuery = true)
    void save (String maddh,String ngay,String nhacc,String manv);
}
