package com.bnp.csc.api.remittance;

import com.bnp.csc.api.common.Constants;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class SettlementInvoice {

    @ApiModelProperty(position = 0)
    private String invoiceRef;

    @ApiModelProperty(position = 1)
    private String obligorOrgID;

    @ApiModelProperty(position = 2)
    private BigDecimal amount;

    @ApiModelProperty(position = 2)
    private BigDecimal outstandingAmount;

    @ApiModelProperty(position = 2, notes= Constants.DEFAULT_CURRENCY_FORMAT_NOTES)
    private String currency;
}
