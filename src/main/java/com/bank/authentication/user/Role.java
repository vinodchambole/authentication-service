package com.bank.authentication.user;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public enum Role {
  CUSTOMER,
  ADMIN,
  MANAGER;
}
