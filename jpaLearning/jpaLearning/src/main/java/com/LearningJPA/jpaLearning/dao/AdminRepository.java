package com.LearningJPA.jpaLearning.dao;

import com.LearningJPA.jpaLearning.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

}
