package br.com.zupacademy.guzzo.transacao.transacoescartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Transacao {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@NotBlank
	private String idExterno;

	private BigDecimal valor;

	private LocalDateTime efetivadaEm;

	@Embedded
	private Estabelecimento estabelecimento;

	@Embedded
	private Cartao cartao;

	@Deprecated
	public Transacao() {

	}

	public Transacao(@NotBlank String idExterno, BigDecimal valor, LocalDateTime efetivadaEm,
			Estabelecimento estabelecimento, Cartao cartao) {
		this.idExterno = idExterno;
		this.valor = valor;
		this.efetivadaEm = efetivadaEm;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
	}

	public String getId() {
		return id;
	}

	public String getIdExterno() {
		return idExterno;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

}
