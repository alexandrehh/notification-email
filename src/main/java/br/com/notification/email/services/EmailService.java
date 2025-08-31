package br.com.notification.email.services;

import br.com.notification.email.dtos.EmailDto;
import br.com.notification.email.models.EmailModel;

public interface EmailService {

    /**
     * Envio de e-mail
     * @param emailDto Dto com as infos do e-mail
     * @return Uma mensagem de sucesso ou falha
     */
    EmailModel sendEmail(EmailDto emailDto);
}
