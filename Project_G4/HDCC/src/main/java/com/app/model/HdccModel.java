package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hdcc_customer")
@Data
@AllArgsConstructor(staticName = "hdcc")
@NoArgsConstructor
public class HdccModel {

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
