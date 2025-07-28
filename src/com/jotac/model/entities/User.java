package com.jotac.model.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String codUser;
	private String nomeUser;
	
	private Nivel nivel;
	
	public User() {
		
	}

	public User(String codUser, String nomeUser, Nivel nivel) {
		this.codUser = codUser;
		this.nomeUser = nomeUser;
		this.nivel = nivel;
	}

	public String getCodUser() {
		return codUser;
	}

	public void setCodUser(String codUser) {
		this.codUser = codUser;
	}

	public String getNomeUser() {
		return nomeUser;
	}

	public void setNomeUser(String nomeUser) {
		this.nomeUser = nomeUser;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codUser, nivel, nomeUser);
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
		return Objects.equals(codUser, other.codUser) && Objects.equals(nivel, other.nivel)
				&& Objects.equals(nomeUser, other.nomeUser);
	}

	@Override
	public String toString() {
		return "User [codUser=" + codUser + ", nomeUser=" + nomeUser + ", nivel=" + nivel + "]";
	}
	

}
