package com.bnp.csc.api.remittance;

import io.swagger.annotations.ApiModelProperty;

public class SettlementResponse {

    @ApiModelProperty(position = 0)
    private String invoiceRef;

    @ApiModelProperty(position = 1, notes="Error or Success")
    private String status;

    @ApiModelProperty(position = 2, notes="Error Code")
    private String errorCode;

    @ApiModelProperty(position = 2, notes="Error Description")
    private String errorDescription;
}
