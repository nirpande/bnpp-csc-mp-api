package com.bnp.csc.api.remittance;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(description = "Remittance Service")
@RequestMapping("v1/remittance")
public class RemittanceController {

    @PostMapping
    @ApiOperation( value="Push Settlement details", position = 2)
    public List<SettlementResponse> settlement( @RequestBody SettlementRequest settlementRequest )
    {
        return new ArrayList<>( 0 );
    }

}
