package com.mustafa.rest.dto;

import com.mustafa.rest.validator.UniqueUserName;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserCreateDTO {
    @NotNull(message = "{backend.constraints.username.NotNull.message}")
    @UniqueUserName()
    private String userName;

    @Size(min = 2 ,max = 25, message ="{backend.constraints.firstname.Size.message}")
    @NotNull(message = "{backend.constraints.firstname.NotNull.message}")
    private String firstName;

    @NotNull(message = "${backend.constraints.lastname.NotNull.message}")
    @Size(min = 2 ,max = 25, message ="{backend.constraints.lastname.Size.message}")
    private String lastName;

}
