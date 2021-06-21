package br.com.zupacademy.guzzo.transacao.transacoescartao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zupacademy.guzzo.transacao.transacoescartao.Transacao;

public class TransacaoEventDto {

	private String id;
	private BigDecimal valor;
	private LocalDateTime efetivadaEm;

	private CartaoEventDto cartao;
	private EstabelecimentoEventDto estabelecimento;

	public TransacaoEventDto() {

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

	public CartaoEventDto getCartao() {
		return cartao;
	}

	public EstabelecimentoEventDto getEstabelecimento() {
		return estabelecimento;
	}

	public Transacao converterParaTransacao() {
		return new Transacao(id, valor, efetivadaEm, getEstabelecimento().converterParaEstabelecimento(),
				getCartao().converterParaCartao());
	}

	@Override
	public String toString() {
		return "TransacaoEventDto [id=" + id + ", valor=" + valor + ", efetivadaEm=" + efetivadaEm + ", cartao="
				+ cartao + ", estabelecimento=" + estabelecimento + "]";
	}

}
