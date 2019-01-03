package org.pankaj.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="employeeDetails" )
public class Customer {
	@Id
	public String id;
	
	public String employeeName;
	public String employeeLastName;
	
}
