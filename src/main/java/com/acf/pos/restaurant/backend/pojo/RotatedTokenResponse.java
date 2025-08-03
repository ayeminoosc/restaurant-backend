package com.acf.pos.restaurant.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RotatedTokenResponse {
    private String userId;
    private String newRefreshToken;
}
