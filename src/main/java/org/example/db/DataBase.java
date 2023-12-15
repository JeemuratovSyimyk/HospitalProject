package org.example.db;

import lombok.Getter;
import lombok.Setter;
import org.example.Entity.Doctor;
import org.example.Entity.Hospital;
import org.example.Entity.Patient;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class DataBase {
    List<Hospital> hospitals = new ArrayList<>();
    List<Doctor> doctors = new ArrayList<>();
    List<Patient> patients = new ArrayList<>();
}
