package org.example.Service;

import org.example.Entity.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor getDoctorById(Long id);//Stream
    List<Doctor> filterByGender(String gender);
}
