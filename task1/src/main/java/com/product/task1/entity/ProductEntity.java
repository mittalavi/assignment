package com.product.task1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
	    @Id	    
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long productId; 
	    
	    @NotBlank(message = "Product name cannot be blank")
	    @Size(min = 5, message = "Product name must have at least 5 characters")
	    private String productName;

	    @NotNull(message = "Product price cannot be null")
	    @DecimalMin(value = "0.01", message = "Product price cannot be less than 0.01")
	    private double productPrice;
	    
	    @NotNull(message = "Quantity cannot be null")
	    @Min(value = 0, message = "Quantity cannot be negative")
	    private int quantity;

}



