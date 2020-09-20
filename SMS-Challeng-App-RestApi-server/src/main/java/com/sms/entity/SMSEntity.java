package com.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="sms_data")
public class SMSEntity {
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="id")
	    private Integer id;  
		@Column(name="start_date")
	    private String start_date;
		@Column(name="end_date")
        private String end_date;
		
		@Column(name="price")	
		private String price;
		
		@ApiModelProperty(notes="color should have atleast 2 characters")
		@Size(min=2, message="color should have atleast 2 characters")
		@Column(name="color")	
		private String color;
		
		@ApiModelProperty(notes="city should have atleast 2 characters")
		@Size(min=2, message="city should have atleast 2 characters")
		@Column(name="city")	
		private String city;
		
		@ApiModelProperty(notes="status should have atleast 2 characters")
		@Size(min=2, message="status should have atleast 2 characters")
		@Column(name="status")	
		private String status;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getStart_date() {
			return start_date;
		}
		public void setStart_date(String start_date) {
			this.start_date = start_date;
		}
		public String getEnd_date() {
			return end_date;
		}
		public void setEnd_date(String end_date) {
			this.end_date = end_date;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		@Override
		public String toString() {
			return "SMSEntity [id=" + id + ", start_date=" + start_date + ", end_date=" + end_date + ", price=" + price
					+ ", color=" + color + ", city=" + city + ", status=" + status + "]";
		}
		
		
		
	} 

