package com.example.backend.Repository;

import com.example.backend.Entity.CTGHEntity;
import com.example.backend.Entity.CTGHID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTGHRepository extends JpaRepository<CTGHEntity, CTGHID> {
}
