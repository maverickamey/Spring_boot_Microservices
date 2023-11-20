package com.LearningJPA.jpaLearning.Services;

import com.LearningJPA.jpaLearning.dao.AdminRepository;
import com.LearningJPA.jpaLearning.dtos.CreateAdminRequestDTO;
import com.LearningJPA.jpaLearning.dtos.CreateAdminResponseDTO;
import com.LearningJPA.jpaLearning.models.Admin;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class NewAdminService {
    // send to the repo which handles(repo)
    @Autowired
    AdminRepository adminRepository;
    public CreateAdminResponseDTO addAdminRequest(CreateAdminRequestDTO createAdminRequestDTO){
        Admin admin = Admin.builder().email(createAdminRequestDTO.getEmail())
                .name(createAdminRequestDTO.getName()).build();
        adminRepository.save(admin);

        CreateAdminResponseDTO createAdminResponseDTO = CreateAdminResponseDTO.builder().message("Admin is configured").name(createAdminRequestDTO.getName()).build();

        return createAdminResponseDTO;

    }
}
