package org.example.Entity;

import lombok.Getter;
import lombok.Setter;
import org.example.Enum.Gender;

import java.util.Objects;

@Setter
@Getter
public class Patient {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Gender gender;
    private int age;

    public Patient(Long id, String firstName, String lastName, String phoneNumber, Gender gender, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return age == patient.age && Objects.equals(id, patient.id) && Objects.equals(firstName, patient.firstName) && Objects.equals(lastName, patient.lastName) && Objects.equals(phoneNumber, patient.phoneNumber) && gender == patient.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, gender, age);
    }

    @Override
    public String toString() {
        return "\nPatient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
