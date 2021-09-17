package com.webchat.webchat.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterPojo {
    @NotBlank(message = "NotBlank.user.username")
    private String username;
    @NotBlank(message = "NotBlank.user.firstName")
    private String firstName;
    @NotBlank(message = "NotBlank.user.lastName")
    private String lastName;
    @NotBlank(message = "NotBlank.user.email")
    @Email(message = "Email.user.email")
    private String email;
    @NotBlank(message = "NotBlank.user.password")
    private String password;
    @NotBlank(message = "NotBlank.user.comfirmPassword")
    private String comfirmPassword;
    @NotBlank(message = "NotBlank.user.birthDate")
    private String birthDate;
    @NotNull(message = "NotBlank.user.gender")
    private boolean gender;
    @NotBlank(message = "NotBlank.user.code")
    private String code;
}
