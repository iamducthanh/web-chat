package com.webchat.webchat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordDto {
    @NotBlank(message = "NotBlank.user.password")
    private String password;
    @NotBlank(message = "NotBlank.user.newPassword")
    private String newPassword;
    @NotBlank(message = "NotBlank.user.comfirmPassword")
    private String comfirmPassword;
}
