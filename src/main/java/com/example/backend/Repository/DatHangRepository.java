package com.example.backend.Repository;

import com.example.backend.Entity.DatHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatHangRepository extends JpaRepository<DatHangEntity,String> {
}
