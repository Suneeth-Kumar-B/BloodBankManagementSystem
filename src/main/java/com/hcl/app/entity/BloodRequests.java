package com.hcl.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="blood_requests", uniqueConstraints = @UniqueConstraint(columnNames={"patientName", "bloodGroup", "contactNumber"}))
public class BloodRequests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long bloodRequestId;

    @Column(nullable = false)
    @NotBlank(message = "Patient name is required")
    private String patientName;

    @Column(nullable = false)
    @NotBlank(message = "Blood group is required")
    private String bloodGroup;

    @Column(nullable = false)
    @NotBlank(message = "City is required")
    private String city;

    @Column(nullable = false)
    @NotBlank(message = "Doctor name is required")
    private String doctorName;

    @Column(nullable = false)
    @NotBlank(message = "Hospital name and address are required")
    private String hospitalNameAddress;

    @Column(nullable = false)
    @NotBlank(message = "Date is required")
    private String date;

    @Column(nullable = false)
    @NotBlank(message = "Contact name is required")
    private String contactName;

    @Column(nullable = false)
    @NotBlank(message = "Contact number is required")
    private String contactNumber;

    @Column(nullable = false)
    @NotBlank(message = "Contact email is required")
    private String contactEmail;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String status = "Pending"; // Default value is "Pending"

    // Getters and setters

    public Long getBloodRequestId() {
        return bloodRequestId;
    }

    public void setBloodRequestId(Long bloodRequestId) {
        this.bloodRequestId = bloodRequestId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getHospitalNameAddress() {
        return hospitalNameAddress;
    }

    public void setHospitalNameAddress(String hospitalNameAddress) {
        this.hospitalNameAddress = hospitalNameAddress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BloodRequests(String patientName, String bloodGroup, String city, String doctorName,
            String hospitalNameAddress, String date, String contactName, String contactNumber, String contactEmail,
            String message) {
        super();
        this.patientName = patientName;
        this.bloodGroup = bloodGroup;
        this.city = city;
        this.doctorName = doctorName;
        this.hospitalNameAddress = hospitalNameAddress;
        this.date = date;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
        this.message = message;
    }

    public BloodRequests() {
        super();
    }
}
