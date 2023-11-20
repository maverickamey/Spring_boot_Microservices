package com.LearningJPA.jpaLearning.Controllers;

import com.LearningJPA.jpaLearning.Services.NewAdminService;
import com.LearningJPA.jpaLearning.dtos.CreateAdminRequestDTO;
import com.LearningJPA.jpaLearning.dtos.CreateAdminResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    NewAdminService newAdminService;

    @PostMapping("/addAdmin")
    public CreateAdminResponseDTO addAdmin(CreateAdminRequestDTO createAdminRequestDTO){
        return newAdminService.addAdminRequest(createAdminRequestDTO);
    }
}
