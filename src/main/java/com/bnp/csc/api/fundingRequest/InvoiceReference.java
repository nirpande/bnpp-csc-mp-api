package com.bnp.csc.api.fundingRequest;

import com.bnp.csc.api.common.Constants;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class InvoiceReference {

    @ApiModelProperty(position = 1,notes="")
    private String invoiceRef;

    @ApiModelProperty(position = 2, notes= Constants.DEFAULT_DATE_FORMAT_NOTES)
    private Date issueDate;

    @ApiModelProperty(position = 3)
    private String obligorOrgID;

    @ApiModelProperty(position = 4)
    private Date maturityDate;

    @ApiModelProperty(position = 5)
    private BigDecimal amount;

    @ApiModelProperty(position = 6)
    private String currency;
}
