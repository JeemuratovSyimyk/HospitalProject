package org.example;


import org.example.Entity.Doctor;
import org.example.Entity.Hospital;
import org.example.Entity.Patient;
import org.example.Enum.Gender;
import org.example.ServiceImpl.DoctorServiceImpl;
import org.example.ServiceImpl.HospitalServiceImpl;
import org.example.ServiceImpl.PatientServiceImpl;
import org.example.db.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        {

            Scanner scanner = new Scanner(System.in);
            int num;
            DataBase dataBase = new DataBase();
            HospitalServiceImpl hospitalService = new HospitalServiceImpl(dataBase);
            DoctorServiceImpl doctorService = new DoctorServiceImpl(dataBase);
            PatientServiceImpl patientService = new PatientServiceImpl(dataBase);
            while (true) {
                System.out.println("""
                        Choose operation
                        1-add a new patient                       8-get hospital by id
                        2-get patient by first name               9-update hospital |
                        3-group patients by gender                10-sort hospital by name
                        4-filter patients above 30years old       11-add doctor
                        5-add one hospital                        12-get doctor by id
                        6-add list of hospitals                   13-filter doctors by gender
                        7-get all hospitals                       14-get all doctors
                                                                  15-add one more doctor
                        """);
                List<Patient> patients = new ArrayList<>(List.of(
                        new Patient(1L, "Nursultan", "Musaeva", "+996702790266", Gender.FEMALE, 21),
                        new Patient(2L, "Myrzaiym", "Musaev", "+996773543669", Gender.MALE, 23),
                        new Patient(3L, "Eldan", "Valentinovna", "+996773543669", Gender.FEMALE, 43),
                        new Patient(4L, "Kamila", "Asanova", "+996773543789", Gender.FEMALE, 31),
                        new Patient(5L, "Rasul", "ER", "+996773547898", Gender.MALE, 54),
                        new Patient(6L, "Kalys", "Abdrazakov", "+996702790266", Gender.FEMALE, 21),
                        new Patient(7L, "Asel", "Temirbekova", "+996773543669", Gender.FEMALE, 78),
                        new Patient(8L, "Isma", "Alymbaev", "+996773543669", Gender.MALE, 36)));

                switch (num = scanner.nextInt()) {
                    case 1:
                        System.out.println(patientService.addPatient(patients));

                    case 2:
                        System.out.println(patientService.getPatientByFirstName("Nursultan"));

                    case 3:
                        patientService.groupingByGender();
                    case 4:
                        System.out.println(patientService.filterByAge());
                    case 5:
                        System.out.println(patientService.getAll());

                    case 6:

                        hospitalService.addHospitals(List.of(
                                new Hospital(1L,"Hospital 1","Address 1"),
                                new Hospital(2L,"Hospital 2","Address 2"),
                                new Hospital(3L,"Hospital 3","Address 3"),
                                new Hospital(4L,"Hospital 4","Address 4"),
                                new Hospital(5L,"Hospital 5","Address 5"),
                                new Hospital(6L,"Hospital 6","Address 6"),
                                new Hospital(7L,"Hospital 7","Address 7"),
                                new Hospital(8L,"Hospital 8","Address 8")));
                    case 8:
                        System.out.println(hospitalService.getAll());
                    case 9:
                        System.out.println(hospitalService.getHospitalById(1L));
                    case 10:
                        hospitalService.updateHospital(4L,new Hospital("H1","A1"));
                    case 11:
                        System.out.println(hospitalService.sortHospitalByName("sort"));
                    case 12:
                        System.out.println(hospitalService.add(new Hospital(9L, "H2", "A2")));

                    case 13:
                        doctorService.add(
                                new Doctor(1L, "Meerim", "Asanova", "milana@gmail.com",Gender.FEMALE));
                                new Doctor(2L, "Aijamal", "Asanova", "aijamal@gmail.com",Gender.MALE);
                    case 14:
                        System.out.println(doctorService.getAll());
                    case 15:
                        System.out.println(doctorService.filterByGender("Female"));
                }
            }
        }
    }
}
