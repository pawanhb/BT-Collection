package com.besugeytech.collectionsmodule.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CollectionUserDetails {

	private String userId;
	private String password; //note: this should be hash string
	private String userRole;
	
}
