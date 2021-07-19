package com.fabionascimento.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.fabionascimento.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
