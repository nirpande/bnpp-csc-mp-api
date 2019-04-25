package com.bnp.csc.api.invoice;

import io.swagger.annotations.ApiModelProperty;

public class InvoiceRecallResponse {

    @ApiModelProperty(position=0)
    private String orgId;

    @ApiModelProperty(position=1)
    private String id;

    @ApiModelProperty(position=2)
    private String status;

    @ApiModelProperty(position=3)
    private String message;
}
