package com.kripesh.cms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {
    private Long id;
    private String quote;

    public Value() {

    }

    public String getQuote(){
        return quote;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id= id;
    }

    public void setQuote(String quote){
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                '}';
    }
}
