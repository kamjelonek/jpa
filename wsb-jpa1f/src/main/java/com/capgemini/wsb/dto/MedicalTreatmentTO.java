package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.enums.TreatmentType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MedicalTreatmentTO implements Serializable
{
    private Long id;
    private String description;
    private TreatmentType type;
    //private VisitEntity visit_id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TreatmentType getType() {
        return type;
    }

    public void setType(TreatmentType type) {
        this.type = type;
    }


    //public VisitEntity  getVisit() { return visit_id; }
    //public void setVisit(VisitEntity  visit_id) { this.visit_id = visit_id; }

}
