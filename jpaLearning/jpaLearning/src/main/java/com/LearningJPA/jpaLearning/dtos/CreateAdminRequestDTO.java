package com.LearningJPA.jpaLearning.dtos;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Builder
@Getter
@Setter
public class CreateAdminRequestDTO {
    private String name;

    private String email;

}
