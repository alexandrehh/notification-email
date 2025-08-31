package br.com.notification.email.controllers;

import br.com.notification.email.dtos.EmailDto;
import br.com.notification.email.models.EmailModel;
import br.com.notification.email.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public ResponseEntity<EmailModel> sendEmail(@RequestBody @Valid EmailDto emailDto) {
        return new ResponseEntity<>(emailService.sendEmail(emailDto), HttpStatus.CREATED);
    }
}
