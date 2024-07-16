package com.example.backend.Repository;

import com.example.backend.Entity.KhoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface KhoRepository extends JpaRepository<KhoEntity,String> {
    @Modifying
    @Query(value="INSERT INTO kho(makho,tenkho,diachi,macn) VALUES(?1,?2,?3,?4)",nativeQuery = true)
    void insertKho(String makho,String tenkho,String diachi,String macn);

    @Modifying
    @Query(value = "UPDATE kho SET tenkho=?1,diachi=?2 WHERE makho=?3",nativeQuery = true)
    void updateKho(String tenkho,String diachi,String makho);
}
