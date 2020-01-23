package com.senla.cources.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Email implements Serializable {

    private String to;
    private String body;

}
