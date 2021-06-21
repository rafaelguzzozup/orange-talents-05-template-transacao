package br.com.zupacademy.guzzo.transacao.transacoescartao;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Cartao {

	@Column(name = "cartao_id")
	private String id;
	private String email;

	@Deprecated
	public Cartao() {

	}

	public Cartao(String id, String email) {
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

}
