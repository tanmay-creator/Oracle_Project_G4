package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "infinity_customer")
@Data
@AllArgsConstructor(staticName = "infinity")
@NoArgsConstructor
public class InfinityModel {

	@Id
    private int accountNo;
    private String name;
    private String permanentAddress;
    private String currentAddress;
    private String mobileNo;
    private String emailId;
    private String occupation;
    private String birthDate;
    private String panNo;
    private long aadharNo;
    private String passportNo;
    private long ekyc;
    private double balance;
}
