package com.LearningJPA.jpaLearning.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateAdminResponseDTO {

    private String message;

    private String name;
}
