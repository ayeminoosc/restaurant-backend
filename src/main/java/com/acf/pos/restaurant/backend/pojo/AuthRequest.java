package com.acf.pos.restaurant.backend.pojo;

import lombok.Data;

@Data
public class AuthRequest { private String email; private String password; private String phoneNumber;}