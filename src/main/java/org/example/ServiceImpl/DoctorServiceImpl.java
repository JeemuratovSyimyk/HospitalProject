package org.example.ServiceImpl;

import org.example.Entity.Doctor;
import org.example.Service.DoctorService;
import org.example.Service.Generic;
import org.example.db.DataBase;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DoctorServiceImpl implements DoctorService , Generic<Doctor> {
 Scanner scanner = new Scanner(System.in);
 int num;
   private DataBase dataBase = new DataBase();

    public DoctorServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    @Override
    public Doctor getDoctorById(Long id) {
       List<Doctor> doctors = dataBase.getDoctors().stream()
               .filter(doctor -> doctor.getId().equals(id))
               .toList();
        return doctors.get(0);
    }
    @Override
    public List<Doctor> filterByGender(String gender) {
      List<Doctor> list = dataBase.getDoctors();
        System.out.println("Filter doctors by gender: " + gender);
      List<Doctor> doctorFilter = dataBase.getDoctors().stream()
              .filter(doctor -> doctor.getGender().equalsIgnoreCase(gender))
              .collect(Collectors.toList());
        return doctorFilter;
    }

    @Override
    public List<Doctor> add(Doctor doctor) {
      dataBase.getDoctors().add(doctor);
        return dataBase.getDoctors();
    }

    @Override
    public List<Doctor> getAll() {
        return dataBase.getDoctors();
    }
}
