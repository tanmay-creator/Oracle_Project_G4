package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityResponse {
	private CitiBal citi;
	private HdccBal hdcc;
	private InfinityBal infinity;
	
}
