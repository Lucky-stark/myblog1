package com.myblog.myblog1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SighUpDto {
    private String name;
    private String username;
    private String email;
    private String password;
    private String roleType;
}
