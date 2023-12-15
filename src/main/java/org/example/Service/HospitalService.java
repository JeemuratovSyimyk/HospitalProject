package org.example.Service;

import org.example.Entity.Hospital;

import java.util.List;

public interface HospitalService {
    List<Hospital> addHospitals(List<Hospital> hospitals);

    Hospital getHospitalById(Long id);
    void updateHospital(Long id, Hospital hospital);
    List<Hospital>sortHospitalByName(String sort);
}
