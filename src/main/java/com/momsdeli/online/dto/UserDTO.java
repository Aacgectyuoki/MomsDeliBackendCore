package com.momsdeli.online.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    @JsonProperty("id")
    private Long id;

    @NotBlank(message = "Username is mandatory")
    @JsonProperty("username")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @JsonProperty("password")
    private String password;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Role is mandatory")
    @Pattern(regexp = "USER|ADMIN", message = "Role must be either USER or ADMIN")
    @JsonProperty("role")
    private String role;

    @NotBlank(message = "First name is mandatory")
    @JsonProperty("first_name")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("orders")
    private List<OrderDTO> orders;

    @JsonProperty("cart")
    private CartDTO cart;

    @JsonProperty("ratings")
    private List<RatingDTO> ratings;
}
