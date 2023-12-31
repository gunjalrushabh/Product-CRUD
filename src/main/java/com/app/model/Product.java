package com.app.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producttbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	@Column(name = "description")
	    private String description;
	
	@Column(name = "price")
	    private BigDecimal price;
	
	@Column(name = "imgurl")
	    private String imageUrl;
	    
	    
		@Override
		public String toString() {
			return "Product [id=" + id + ", description=" + description + ", price=" + price + ", imageUrl=" + imageUrl
					+ "]";
		}

	    
}
