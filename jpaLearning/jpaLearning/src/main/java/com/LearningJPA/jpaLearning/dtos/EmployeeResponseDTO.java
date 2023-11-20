package com.LearningJPA.jpaLearning.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeResponseDTO {

    private long salary;
    private String designation;
    private String message;
}
