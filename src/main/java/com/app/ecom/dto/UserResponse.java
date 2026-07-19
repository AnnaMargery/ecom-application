package com.app.ecom.dto;

import com.app.ecom.model.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private UserRole role;
	private AddressDto address;
}
