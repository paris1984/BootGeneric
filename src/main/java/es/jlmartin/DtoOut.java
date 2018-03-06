package es.jlmartin;

import java.io.Serializable;

public class DtoOut implements Serializable{
    private Boolean codeV;
    private String message;

    public DtoOut(Boolean codeV) {
        this.codeV = codeV;
    }

    public DtoOut(String message) {
        this.message = message;
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
}
