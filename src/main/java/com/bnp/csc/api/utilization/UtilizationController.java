package com.bnp.csc.api.utilization;

import com.google.common.collect.Streams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Api(description = "Utilization Service")
@RestController
@RequestMapping("v1/utilization")
public class UtilizationController {

    private UtilizationMapper mapper;

    @GetMapping
    @ApiOperation(
            value="Query utiization details",
            notes="Provides the ability for Marco Polo to query CSC FO for Utilization details of given Supplier CSC OrgId.",
            responseContainer = "List",
            response= UtilizationDetailsResponse.class
    )
    @Transactional(readOnly = true)
    public List<UtilizationDetailsResponse> queryUtilization(
            @ApiParam(value = "CSC Supplier Org ID whose utilization details are required", required = true)
            @RequestParam(name="orgID") final List<String> orgIds,
            @ApiParam(value = "Invoice Currency in which the utilization/limit amount details are required", required = true, example = "USD")
            @RequestParam(name="currency") final List<String> currencies
    )
    {
        return Streams
                .zip(
                    orgIds.stream(),
                    currencies.stream(),
                    (orgId, currency) -> {
                        UtilizationDetailsResponse result = this.mapper.queryLimit( orgId.toUpperCase(), currency.toUpperCase() );
                        if( result == null ){
                            result = new UtilizationDetailsResponse();
                          
                        }
                        return result;
                    })
                .collect( Collectors.toList());
    }
}
