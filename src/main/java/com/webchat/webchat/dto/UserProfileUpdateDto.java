package com.webchat.webchat.dto;

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
public class UserProfileUpdateDto {
    @NotBlank(message = "NotBlank.user.username")
    private String username;
    private String id;
    @NotBlank(message = "NotBlank.user.firstName")
    private String firstName;
    @NotBlank(message = "NotBlank.user.lastName")
    private String lastName;
    private String phone;
    @NotBlank(message = "NotBlank.user.birthDate")
    private String birthday;
    @NotNull(message = "NotBlank.user.gender")
    private Boolean gender;
    private String description;
}
