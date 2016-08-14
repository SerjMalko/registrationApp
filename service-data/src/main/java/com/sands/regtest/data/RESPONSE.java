package com.sands.regtest.data;


import javax.ws.rs.core.Response;

/**
 * Response generator for All REST-service
 *
 */
public enum RESPONSE {
// 10000 - logic error
    _0_OK(Response.Status.OK),
    _10005_INVALID_PARAMETER(Response.Status.BAD_REQUEST),
    _10006_INPUT_ERROR_PARAMS(Response.Status.BAD_REQUEST),
    _10007_INPUT_ERROR_PARAMS_UNDEFINED(Response.Status.BAD_REQUEST),

// 20000 - server error.

    _20000_INTERNAL_SERVER_ERROR(Response.Status.INTERNAL_SERVER_ERROR),
    _20001_CANT_PARSE_REQUEST(Response.Status.BAD_REQUEST),
    _20002_CANT_PARSE_RESPONSE(Response.Status.BAD_REQUEST),

    _20100_MESSAGE_NOT_SENT(Response.Status.BAD_REQUEST);

   private final String DEFAULT_LANGUAGE = "en";

    //Code of response респонса
    public final String code;
    // Key for description of response in bundle
    public final String key;
    //HTTP status
    public final Response.Status status;

    RESPONSE(Response.Status status) {
        this.status = status;
        this.code = this.name().split("_")[1];
        this.key = this.name().substring(this.name().indexOf("_", 1) + 1);
    }

    /**
     * Create response by parameters and fill error block. Parameters can be null
     *
     * @param response респонс для которого производится заполнение блока errorInfo
     * @param errorText  error description text (can be different with bundle text)
     * @param errorDescription additional error description
     * @return
     */
    public Response createResponse(DefaultResponse response, String errorText, String errorDescription) {
        if (response==null) response = new DefaultResponse();

        response.setErrorInfo(this, DEFAULT_LANGUAGE);
        if (errorText!=null)response.getErrorInfo().setErrorText(errorText);
        if (errorDescription!=null)response.getErrorInfo().setErrorDescription(errorDescription);

        return getResponse(response);
    }

    public Response createResponse(DefaultResponse response, String errorText, String errorDescription, Object... addParams) {
        if (response==null) response = new DefaultResponse();

        response.setErrorInfo(this, DEFAULT_LANGUAGE, addParams);
        if (errorText!=null)response.getErrorInfo().setErrorText(errorText);
        if (errorDescription!=null)response.getErrorInfo().setErrorDescription(errorDescription);

        return getResponse(response);
    }

    /**
     * Create response with http status
     *
     * @param response
     * @return
     */
    private Response getResponse(DefaultResponse response) {
        Response result;
        result = Response.status(status).entity(response).build();
        return result;
    }

    /**
     * Формирует респонс по готовому овтету
     * @param response
     * @return
     */
    public static Response covertResponse(DefaultResponse response) {
        Response result;
        try {
            RESPONSE resp = findStatusByCode(response.getErrorInfo().getError());
            Response.Status status = resp.status;
            result = Response.status(status).entity(response).build();
        } catch (Exception e) {
            result = RESPONSE._20000_INTERNAL_SERVER_ERROR.createResponse(null,null,null,null);
        }
        return result;
    }

    private static RESPONSE findStatusByCode(String statusCode) {
        for (RESPONSE value : values()) {
            if (value.code.equalsIgnoreCase(statusCode)) {
                return value;
            }
        }
        return null;
    }

    public static RESPONSE parseByCode(String code) {
        for (RESPONSE value : values()) {
            if (value.code.equalsIgnoreCase(code)) {
                return value;
            }
        }
        return null;
    }

}
