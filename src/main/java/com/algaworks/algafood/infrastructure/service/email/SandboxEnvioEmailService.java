package com.algaworks.algafood.infrastructure.service.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.algaworks.algafood.core.email.EmailProperties;

public class SandboxEnvioEmailService extends SmtpEnvioEmailService {
	
	@Autowired
	private EmailProperties emailProperties;

	@Override
	protected MimeMessage criarMimeMessage(Mensagem mensagem, String corpo) throws MessagingException {
		MimeMessage mimeMessage = super.criarMimeMessage(mensagem, corpo);
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
		helper.setTo(emailProperties.getSandbox().getDestinatario());
		
		return mimeMessage;
	}
	
}
