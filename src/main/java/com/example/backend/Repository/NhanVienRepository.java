package com.example.backend.Repository;

import com.example.backend.Entity.NhanVienEntity;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface NhanVienRepository extends JpaRepository<NhanVienEntity,Long> {
    @Modifying
    @Query(value = "UPDATE nhanvien SET hoten=?2, diachi= ?3,ngaysinh= ?4, email=?5, luong= ?6, socmnd= ?7, trangthai =?8, macn=?9, maquyen=?10 WHERE manv = ?1",nativeQuery = true)
    void updateByMANV(String manv,String hoten,String diachi,String ngaysinh, String email,String luong,String socmnd,boolean trangthai,String macn,String maquyen);

    @Modifying
    @Query(value = "INSERT INTO nhanvien (hoten,diachi,ngaysinh,email,luong,socmnd,trangthai,macn,maquyen) VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9)",nativeQuery = true)
    void save (String hoten,String diachi,String ngaysinh,String email,String luong,String socmnd,boolean trangthai,String macn,String maquyen);
}
