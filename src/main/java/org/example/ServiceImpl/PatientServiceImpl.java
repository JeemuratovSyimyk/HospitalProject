package org.example.ServiceImpl;

import org.example.Entity.Patient;
import org.example.Enum.Gender;
import org.example.Service.PatientService;
import org.example.db.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientServiceImpl implements PatientService {
   Scanner scanner = new Scanner (System.in);
   int num;
    private DataBase dataBase = new DataBase();

    public PatientServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    @Override
    public List<Patient> addPatient(List<Patient> patients) {
     dataBase.getPatients().addAll(patients);
        System.out.println("Patients are successfully saved");
        return dataBase.getPatients();
    }

    @Override
    public Patient getPatientByFirstName(String name) {
      List<Patient> List = dataBase.getPatients().stream()
              .filter(patient -> patient.getFirstName().equalsIgnoreCase(name))
              .toList();
        return List.get(0);
    }
    @Override
    public void groupingByGender() {
        System.out.println("Only male:");
      dataBase.getPatients().stream()
              .filter(patient -> patient.getGender().equals(Gender.MALE)).forEach(System.out::println);
       System.out.println("Only female");
         dataBase.getPatients().stream()
                 .filter(patient -> patient.getGender().equals(Gender.FEMALE)).forEach(System.out::println);

    }

    @Override
    public List<Patient> filterByAge() {
      List<Patient> list = dataBase.getPatients().stream()
              .filter(patient -> patient.getAge()>31)
              .toList();
        return list;
    }

    @Override
    public List<Patient> getAll() {
        return dataBase.getPatients();
    }
}
