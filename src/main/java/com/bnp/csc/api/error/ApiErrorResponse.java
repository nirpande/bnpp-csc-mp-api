package com.bnp.csc.api.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@ApiModel(description = "REST API Error")
public class ApiErrorResponse implements Serializable {

    private static final long serialVersionUID = -8594130844531679603L;

    @ApiModelProperty(
            value = "HTTP status code",
            notes=" It will be anything from 4xx to signalize client errors or 5xx to mean server errors. A common scenario is a http code 400 that means a BAD_REQUEST, when the client, for example, sends an improperly formatted field, like an invalid email address.",
            position = 0
    )
    private int status;

    @ApiModelProperty(notes="date-time instance of when the error happened",position = 1)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;

    @ApiModelProperty(notes="human-readable error message",position = 2)
    private String message;

    @ApiModelProperty(notes="REST API specific error code",position = 3)
    private String code;

    public static final class ApiErrorResponseBuilder {
        private int status;
        private LocalDateTime timestamp;
        private String message;
        private String code;

        public static ApiErrorResponseBuilder anApiErrorResponse() {
            return new ApiErrorResponseBuilder();
        }

        public ApiErrorResponseBuilder withStatus( HttpStatus status) {
            this.status = status.value();
            return this;
        }

        public ApiErrorResponseBuilder withCode( String code) {
            this.code = code;
            return this;
        }

        public ApiErrorResponseBuilder withMessage( String message) {
            this.message = message;
            return this;
        }

        public ApiErrorResponse build() {
            ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
            apiErrorResponse.status = this.status;
            apiErrorResponse.code = this.code;
            apiErrorResponse.message = this.message;
            apiErrorResponse.timestamp = LocalDateTime.now();
            return apiErrorResponse;
        }
    }
}
