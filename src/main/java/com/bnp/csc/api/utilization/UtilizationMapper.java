package com.bnp.csc.api.utilization;

public interface UtilizationMapper {

    /**
    @Results({
            @Result(property = "orgId", column = "ORG_ID"),
            @Result(property = "currency", column = "CCY_CODE"),
            @Result(property = "grantedLimit", column = "GRANTED_LIMIT"),
            @Result(property = "utilizedLimit", column = "UTILIZED_AMT"),
            @Result(property = "availableLimit", column = "AVAILABLE_AMT"),
            @Result(property = "effectiveAvailableLimit", column="EFFECTIVE_AVAILABLE_LIMIT")
    })
    @Select( "SELECT ORG_ID, CCY_CODE, GRANTED_LIMIT, UTILIZED_AMT, AVAILABLE_AMT, (AVAILABLE_AMT - BLOCKED_AMT) AS EFFECTIVE_AVAILABLE_LIMIT FROM M_PROGRAM_LIMIT WHERE ORG_ID = #{orgId} AND CCY_CODE = #{ccy}" )
    **/
    UtilizationDetailsResponse queryLimit( String orgId, String currency );
}
