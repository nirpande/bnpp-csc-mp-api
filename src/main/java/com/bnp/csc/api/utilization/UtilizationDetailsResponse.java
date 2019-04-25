package com.bnp.csc.api.utilization;

import com.bnp.csc.api.common.Constants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@ApiModel(description = "Utilization details")
public class UtilizationDetailsResponse implements Serializable {

    private static final long serialVersionUID = -1208813238281303100L;

    @ApiModelProperty(notes = "CSC Supplier Org ID whose utilization details are required", position = 0)
    private String orgId;

    @ApiModelProperty(notes = "Currency being passed in", position = 1, example = Constants.DEFAULT_CURRENCY_FORMAT_NOTES)
    private String currency;

    @ApiModelProperty(notes = "Granted Limit", position = 2)
    private BigDecimal grantedLimit;

    @ApiModelProperty(notes = "Utilized Limit", position = 2)
    private BigDecimal utilizedLimit;

    @ApiModelProperty(notes = "Available Limit", position = 2)
    private BigDecimal availableLimit;

    @ApiModelProperty(notes = "Effective Available Limit", position = 3)
    private BigDecimal effectiveAvailableLimit;
}
