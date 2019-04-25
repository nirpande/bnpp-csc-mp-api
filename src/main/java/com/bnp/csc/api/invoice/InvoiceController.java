package com.bnp.csc.api.invoice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description="Invoice Service")
@RequestMapping("v1/invoice")
public class InvoiceController {

    @ApiOperation( value="Recall an invoice that has not been discounted" )
    @DeleteMapping("/{org_id}/{invoice_id}")
    public InvoiceRecallResponse recall( @ApiParam(name="org_id",required = true) @PathVariable("org_id") String orgId,
                                         @ApiParam(name="invoice_id",required = true) @PathVariable("invoice_id") String invoiceId )
    {
        return new InvoiceRecallResponse();
    }
}
