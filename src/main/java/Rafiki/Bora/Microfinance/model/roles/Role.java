package Rafiki.Bora.Microfinance.model.roles;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
	  ROLE_MERCHANT,ROLE_ADMIN;

	  public String getAuthority() {
	    return name();
	  }

}
