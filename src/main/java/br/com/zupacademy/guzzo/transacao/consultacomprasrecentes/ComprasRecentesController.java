package br.com.zupacademy.guzzo.transacao.consultacomprasrecentes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guzzo.transacao.transacoescartao.Transacao;
import br.com.zupacademy.guzzo.transacao.transacoescartao.TransacaoRepository;

@RestController
public class ComprasRecentesController {

	@Autowired
	private TransacaoRepository transacaoRepository;

	@GetMapping("/transacoes/{id}/compras-recentes")
	public ResponseEntity<?> retornaComprasRecentes(@PathVariable String id,
			@PageableDefault(page = 0, size = 10, direction = Direction.DESC, sort = "efetivadaEm") Pageable paginacao) {

		Page<Transacao> transacoes = transacaoRepository.findAllByCartaoId(id, paginacao);

		return transacoes.isEmpty() ? ResponseEntity.notFound().build()
				: ResponseEntity.ok().body(transacoes.map(TransacaoResponse::new).getContent());
	}
}
