package com.bnp.csc.api.fundingRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FundingReqResponse {

    @ApiModelProperty(value = "Discount Request GUID ")
    private String fileId;
}
