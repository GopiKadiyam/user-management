package com.gk.usermanagement.repository;

import com.gk.usermanagement.entity.ProfessionalDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalDetailRepository extends JpaRepository<ProfessionalDetail,Long> {
}
