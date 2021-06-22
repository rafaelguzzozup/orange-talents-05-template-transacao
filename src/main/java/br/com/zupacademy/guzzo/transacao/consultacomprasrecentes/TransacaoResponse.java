package br.com.zupacademy.guzzo.transacao.consultacomprasrecentes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zupacademy.guzzo.transacao.transacoescartao.Transacao;

public class TransacaoResponse {
	private String id;
	private BigDecimal valor;
	private LocalDateTime efetivadaEm;
	private String email;
	private String estabelecimento;
	private String cidade;
	private String endereco;

	public TransacaoResponse(Transacao transacao) {
		this.id = transacao.getId();
		this.valor = transacao.getValor();
		this.efetivadaEm = transacao.getEfetivadaEm();
		this.email = transacao.getCartao().getEmail();
		this.estabelecimento = transacao.getEstabelecimento().getNome();
		this.cidade = transacao.getEstabelecimento().getCidade();
		this.endereco = transacao.getEstabelecimento().getEndereco();
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public String getEmail() {
		return email;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}

}
