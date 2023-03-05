package org.starking.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	
private String name;
	
	private String description;
	
	private String category;
	
	private String model;
	
	private BigDecimal price;

}
