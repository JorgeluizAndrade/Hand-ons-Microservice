package com.ms.email.dto;

public record EmailDTO(Integer userId, String emailTo, String subject, String text) {

}
