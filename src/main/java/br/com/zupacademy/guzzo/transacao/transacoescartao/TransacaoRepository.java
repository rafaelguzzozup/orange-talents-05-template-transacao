package br.com.zupacademy.guzzo.transacao.transacoescartao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {

	List<Transacao> findAllByCartaoId(String cartaoId, Pageable paginacao);

}
