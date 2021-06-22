package br.com.zupacademy.guzzo.transacao.consultacomprasrecentes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	public ResponseEntity<?> retornaComprasRecentes(@PathVariable String id) {

		PageRequest paginacao = PageRequest.of(0, 10, Sort.Direction.DESC, "efetivadaEm");
		List<Transacao> transacoes = transacaoRepository.findAllByCartaoId(id, paginacao);

		List<TransacaoResponse> retorno = transacoes.stream().map(TransacaoResponse::new).collect(Collectors.toList());

		if (retorno.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(retorno);
	}
}
