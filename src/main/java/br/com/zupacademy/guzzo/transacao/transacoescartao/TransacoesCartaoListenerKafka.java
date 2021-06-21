package br.com.zupacademy.guzzo.transacao.transacoescartao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zupacademy.guzzo.transacao.transacoescartao.dto.TransacaoEventDto;

@Component
public class TransacoesCartaoListenerKafka {

	@Autowired
	private TransacaoRepository transacaoRepository;

	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
	public void escutaTransacoesDoCartao(TransacaoEventDto eventDto) {
		System.out.println(eventDto.toString());
		Transacao transacao = eventDto.converterParaTransacao();

		transacaoRepository.save(transacao);
	}

}
