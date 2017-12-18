package org.talend.sdk.component.api.service.http;

public class HttpException extends RuntimeException {

    private Response response;

    public HttpException(final Response response) {
        super("code: " + response.status() + ", message: " + response.error(String.class));
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }
}
