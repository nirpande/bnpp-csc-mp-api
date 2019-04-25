package com.bnp.csc.api.remittance;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SettlementRequest {

    private String orgId;

    @ApiModelProperty(position = 1)
    private List<SettlementInvoice> invoices;
}
