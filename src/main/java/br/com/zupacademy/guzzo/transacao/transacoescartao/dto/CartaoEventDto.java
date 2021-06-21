package br.com.zupacademy.guzzo.transacao.transacoescartao.dto;

import br.com.zupacademy.guzzo.transacao.transacoescartao.Cartao;

public class CartaoEventDto {

	private String id;
	private String email;

	public CartaoEventDto() {

	}

	public CartaoEventDto(String id, String email) {
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public Cartao converterParaCartao() {
		return new Cartao(id, email);
	}

	@Override
	public String toString() {
		return "CartaoEventDto [id=" + id + ", email=" + email + "]";
	}

}
