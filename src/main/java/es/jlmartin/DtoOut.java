package es.jlmartin;

import java.io.Serializable;

public class DtoOut implements Serializable{
    private Boolean codeV;
    private String message;
    private Integer intents;

    public DtoOut(String message,Boolean codeV,Integer intents) {
        this.message = message;
        this.codeV = codeV;
        this.intents = intents;
    }

    public Boolean getCodeV() {
        return codeV;
    }

    public void setCodeV(Boolean codeV) {
        this.codeV = codeV;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getIntents() {
        return intents;
    }

    public void setIntents(Integer intents) {
        this.intents = intents;
    }
}
