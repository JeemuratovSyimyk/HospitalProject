package org.example.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
public class Hospital {
    private Long id;
    private String name;
    private String address;
    private List<Doctor> doctors;
    private List<Patient>patients;

    public Hospital(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Hospital(Long id, String name, String address, List<Doctor> doctors, List<Patient> patients) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.doctors = doctors;
        this.patients = patients;
    }

    public Hospital(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return Objects.equals(id, hospital.id) && Objects.equals(name, hospital.name) && Objects.equals(address, hospital.address) && Objects.equals(doctors, hospital.doctors) && Objects.equals(patients, hospital.patients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, doctors, patients);
    }

    @Override
    public String toString() {
        return "\nHospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", doctors=" + doctors +
                ", patients=" + patients +
                '}';
    }
}
