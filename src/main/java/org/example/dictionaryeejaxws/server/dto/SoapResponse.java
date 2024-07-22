package org.example.dictionaryeejaxws.server.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SoapResponse {

    @XmlElement(name = "result")
    private String result;

    public SoapResponse(String result) {
        this.result = result;
    }
    public SoapResponse() {}

    public String getResult() {
        return result;
    }
}
