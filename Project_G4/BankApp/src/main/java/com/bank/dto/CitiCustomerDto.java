package com.bank.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class CitiCustomerDto {
	    private int accountNo;
        @NotNull(message="{citiCustomerDto.name.absent}")
	    private String name;
        @NotNull(message=" {citiCustomerDto.permanentAddress.absent}")
	    private String permanentAddress;
        @NotNull(message="{citiCustomerDto.currentAddress.absent}")
	    private String currentAddress;
        @NotNull(message="{citiCustomerDto.mobileNo.absent}")
	    private String mobileNo;
        @Email(message="{citiCustomerDto.emailId.absent}")
	    private String emailId;
       // @NotNull(message="{citiCustomerDto.occupation.absent}")
	    private String occupation;
        @NotNull(message="{citiCustomerDto.birthDate.absent}")
	    private String birthDate;
        @NotNull(message="{citiCustomerDto.panNo.absent}")
	    private String panNo;
        @NotNull(message="{citiCustomerDto.aadharNo.absent}")
	    private long aadharNo;
        @NotNull(message="{citiCustomerDto.passportNo.absent}")
	    private String passportNo;
       // @NotNull(message="{citiCustomerDto.ekyc.absent}")
	    private long ekyc;
        @NotNull(message="{citiCustomerDto.balance.absent}")
        @Min(value=1000, message = "{citiCustomerDto.balance.invalid}")
	    private double balance;
	    
}
