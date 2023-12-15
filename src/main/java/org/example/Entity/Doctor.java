package org.example.Entity;

import lombok.Getter;
import lombok.Setter;
import org.example.Enum.Gender;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
public class Doctor {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Patient> patients;
    private Gender gender;

    public Doctor(Long id, String firstName, String lastName, String email, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.patients = patients;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id) && Objects.equals(firstName, doctor.firstName) && Objects.equals(lastName, doctor.lastName) && Objects.equals(email, doctor.email) && Objects.equals(patients, doctor.patients) && gender == doctor.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, patients, gender);
    }

    @Override
    public String toString() {
        return "\nDoctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", patients=" + patients +
                ", gender=" + gender +
                '}';
    }
}
