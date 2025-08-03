package com.acf.pos.restaurant.backend.pojo;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String organizationName;
    private String ownerFirstName;
    private String ownerLastName;
    private String ownerEmail;
    private String ownerPhoneNo;
    private String userID;
    private String password;
}
