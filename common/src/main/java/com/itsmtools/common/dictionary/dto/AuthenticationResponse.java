package com.itsmtools.common.dictionary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


@SuppressWarnings("all")
public class AuthenticationResponse {
    @JsonProperty
    private String status;
    @JsonProperty
    private String redirectUrl;
    @JsonProperty
    private String textStatus;

    public AuthenticationResponse(String status, String textStatus, String redirectUrl){
        this.status = status;
        this.textStatus = textStatus;
        this.redirectUrl = redirectUrl;
    }
}
