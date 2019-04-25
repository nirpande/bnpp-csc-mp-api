package com.bnp.csc.api.fundingRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(description="Funding Requests")
@RequestMapping("v1/funding-requests")
public class FundingReqController {

    @PostMapping
    @ApiOperation(
            value="Push invoices to be discounted",
            position = 1,
            notes="Push into CSC the invoices to be discounted (with the usual flexibility to auto discount at file upload or through Discount Date adjustment rules, no cherry picking/manual discounting)"
    )
    public FundingReqResponse discountInvoice( @RequestBody FundingRequest fundingRequest )
    {
        FundingReqResponse result = new FundingReqResponse();
        //result.
       // result.setFileId( "DUMMY_FILE_ID" );
        return result;
    }
}
