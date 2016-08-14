package com.sands.regtest.data;

/**
 * Created by ava on 28.09.2015.
 */
public class ErrorInfo {
    //Код ошибки
    private String error;
    //Текст ошибки (для пользователя)
    private String errorText;
    //Описание ошибки (системное)
    private String errorDescription;

    public ErrorInfo() {
    }

    public ErrorInfo(String error) {
        this.error = error;
    }

    public ErrorInfo(String error, String errorText) {
        this.error = error;
        this.errorText = errorText;
    }

    public ErrorInfo(Integer error, String errorText) {
        this.error = String.valueOf(error);
        this.errorText = errorText;
    }

    public ErrorInfo(String error, String errorText, String errorDescription) {
        this.error = error;
        this.errorText = errorText;
        this.errorDescription = errorDescription;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
