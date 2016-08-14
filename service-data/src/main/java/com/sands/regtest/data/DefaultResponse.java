package com.sands.regtest.data;


import com.sands.regtest.util.ApplicationProperties;

/**
 * Default REST-service response (error and description)
 * Created by ava on 09.09.2015.
 */
public class DefaultResponse {
    //Блок описания ошибки
    private ErrorInfo errorInfo = new ErrorInfo();

    public DefaultResponse() {
    }

    public void setErrorInfo(RESPONSE result){
            this.getErrorInfo().setError(result.code);
            this.getErrorInfo().setErrorText(ApplicationProperties.ACCESS.getString(result.key));
    }

    public void setErrorInfo(RESPONSE result, Object... addParams){
        this.getErrorInfo().setError(result.code);
        this.getErrorInfo().setErrorText(ApplicationProperties.ACCESS.getString(result.key, addParams));
    }

    public DefaultResponse(String error, String errorText, String errorDescription) {
        this.errorInfo.setError(error);
        this.errorInfo.setErrorText(errorText);
        this.errorInfo.setErrorDescription(errorDescription);
    }

    public DefaultResponse(String error, String errorText) {
        this.errorInfo.setError(error);
        this.errorInfo.setErrorText(errorText);
    }

    public DefaultResponse(String errorText) {
        this.errorInfo.setErrorText(errorText);
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }
}
