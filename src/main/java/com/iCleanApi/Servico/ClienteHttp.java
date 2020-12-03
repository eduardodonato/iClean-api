package com.iCleanApi.Servico;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iCleanApi.Dominio.DTO.DataLimpezaDTO;
import com.iCleanApi.Dominio.DTO.PostNotificationDTO;
import com.iCleanApi.Dominio.DTO.UsuarioLimpezaDTO;

@Service
public class ClienteHttp {

	private final RestTemplate restTemplate;
	private final String url = "https://exp.host/--/api/v2/push/send";
	
	public ClienteHttp(RestTemplateBuilder restTemplateBuilder) {
	    this.restTemplate = restTemplateBuilder.build();
	}
	
	public String getPostsPlainJSON() {
	    String url = "https://jsonplaceholder.typicode.com/posts";
	    return this.restTemplate.getForObject(url, String.class);
	}
	
	public void postNotification (UsuarioLimpezaDTO limpeza) {
		PostNotificationDTO dto = new PostNotificationDTO();
		DataLimpezaDTO dataDto = new DataLimpezaDTO(limpeza);
		dto.setTitle("Sua Limpeza é Hoje");
		dto.setBody("Clique aqui quando a executá-la");
		dto.setTo(limpeza.getTokenUsuario());
		dto.setData(dataDto);
		restTemplate.postForLocation(url, dto);
	}
}