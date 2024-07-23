package org.example.dictionaryeejaxws.server.dto;

import org.example.dictionaryeejaxws.server.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement
public class SoapResponse {

    @XmlElement(name = "message")
    private String message;
    @XmlElement(name = "response-time")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate responseTime;
    @XmlElement(name = "result")
    private String result;


    public SoapResponse(String message, LocalDate responseTime, String result) {
        this.message = message;
        this.responseTime = responseTime;
        this.result = result;
    }

    public SoapResponse() {}

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getResponseTime() {
        return responseTime;
    }
}
