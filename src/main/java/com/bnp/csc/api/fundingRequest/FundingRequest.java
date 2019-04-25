package com.bnp.csc.api.fundingRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FundingRequest {

    @ApiModelProperty(position = 0, notes="Id of the organization whose utilization details are required")
    private String orgId;

    @ApiModelProperty(position = 1)
    private String fundingRequestId;

    @ApiModelProperty(position = 2)
    private List<InvoiceReference> invoices;
}
