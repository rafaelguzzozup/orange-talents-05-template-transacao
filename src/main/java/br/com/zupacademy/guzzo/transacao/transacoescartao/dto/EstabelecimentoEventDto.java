package br.com.zupacademy.guzzo.transacao.transacoescartao.dto;

import br.com.zupacademy.guzzo.transacao.transacoescartao.Estabelecimento;

public class EstabelecimentoEventDto {

	private String nome;
	private String cidade;
	private String endereco;

	public EstabelecimentoEventDto() {

	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public Estabelecimento converterParaEstabelecimento() {
		return new Estabelecimento(nome, cidade, endereco);
	}

	@Override
	public String toString() {
		return "EstabelecimentoEventDto [nome=" + nome + ", cidade=" + cidade + ", endereco=" + endereco + "]";
	}

}
