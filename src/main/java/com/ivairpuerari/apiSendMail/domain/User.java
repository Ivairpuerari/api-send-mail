package com.ivairpuerari.apiSendMail.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private String emailAddres;

	public String getEmailAddres() {
		return emailAddres;
	}

	public void setEmailAddres(String emailAddres) {
		this.emailAddres = emailAddres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailAddres == null) ? 0 : emailAddres.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (emailAddres == null) {
			if (other.emailAddres != null)
				return false;
		} else if (!emailAddres.equals(other.emailAddres))
			return false;
		return true;
	}
	
	
}
