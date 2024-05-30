package com.example.backend.Repository;

import com.example.backend.Entity.KhoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoRepository extends JpaRepository<KhoEntity,String> {
}
