package com.example.workexperienceservice.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class WorkExperience extends BaseEntity {

    private String startYear;
    private String designation;
    private String companyName;
    private String endYear;

//    @ManyToOne(cascade = CascadeType.ALL, optional = false)
//    @JoinColumn(name = "profile_id", nullable = false)
//    private Profile profile;
    private Long user_id;

// relation
}
