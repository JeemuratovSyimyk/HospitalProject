package org.example.ServiceImpl;

import org.example.Entity.Hospital;
import org.example.Service.Generic;
import org.example.Service.HospitalService;
import org.example.db.DataBase;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HospitalServiceImpl implements HospitalService , Generic<Hospital> {
  Scanner scanner = new Scanner(System.in);
  int num;
    private DataBase dataBase = new DataBase();

    public HospitalServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Hospital> addHospitals(List<Hospital> hospitals) {
      dataBase.getHospitals().addAll(hospitals);
        return dataBase.getHospitals();
    }

    @Override
    public Hospital getHospitalById(Long id) {
      List<Hospital> list = dataBase.getHospitals().stream()
              .filter(hospital -> hospital.getId().equals(id))
              .toList();
        return list.get(0);
    }

    @Override
    public void updateHospital(Long id, Hospital hospital) {
      for (Hospital h : dataBase.getHospitals()) {
        if (h.getId().equals(id)) {
          h.setName(h.getName());
          h.setAddress(h.getAddress());
        }
      }
      System.out.println("Successfully updated");
    }
    @Override
    public List<Hospital> sortHospitalByName(String sort) {
    List<Hospital> hospitals = dataBase.getHospitals();
      System.out.println("""
                press 1-by ascending
                press 2-by descending""");
 switch (sort){
   case "1" :
     Collections.sort(hospitals , Comparator.comparing(Hospital::getName));
     break;
   case "2" :
     Collections.sort(hospitals , Comparator.comparing(Hospital::getName).reversed());
 break;
   default:
     System.out.println("Invalid input. No sorting performed");
 }
        return hospitals;
    }

  @Override
  public List<Hospital> add(Hospital hospital) {
  dataBase.getHospitals().add(hospital);
    return dataBase.getHospitals();
  }

  @Override
  public List<Hospital> getAll() {
      return dataBase.getHospitals();
  }
}
