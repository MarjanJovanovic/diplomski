package it.engineering.marjanjovanovicbe.entity;

public class SenderResponse {
    private String message;
    public SenderResponse(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}