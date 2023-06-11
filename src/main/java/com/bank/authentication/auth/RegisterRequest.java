package com.bank.authentication.auth;

import com.bank.authentication.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
  private String firstname;
  private String lastname;
  private Date dateOfBirth;
  private String email;
  private String phoneNumber;
  private String address;
  private String password;
  private String aadharNumber;
  private String panNumber;
  private String gender;
  private Role role;
}
