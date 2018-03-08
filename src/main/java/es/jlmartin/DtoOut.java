package es.jlmartin;

import java.io.Serializable;

public class DtoOut implements Serializable{
    private Boolean codeV;
    private String message;
    private Integer attempts;
    private Integer maxAttempts;

    public DtoOut(String message,Boolean codeV,Integer attempts, Integer maxAttempts) {
        this.message = message;
        this.codeV = codeV;
        this.attempts = attempts;
        this.maxAttempts = maxAttempts;
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

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public Integer getMaxAttempts() {
        return maxAttempts;
    }

    public void setMaxAttempts(Integer maxAttempts) {
        this.maxAttempts = maxAttempts;
    }
}
