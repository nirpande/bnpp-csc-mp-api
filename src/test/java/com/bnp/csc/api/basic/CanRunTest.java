package com.bnp.csc.api.basic;

import com.bnp.csc.services.common.dao.IUserCacheDAO;
import com.bnp.scm.services.limitmgmt.dao.ILimitCheckDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CanRunTest {

    @Autowired
    private IUserCacheDAO userCacheDAO;

    @Autowired
    private ILimitCheckDAO limitCheckDAO;

    @Test
    public void canRunMybatis3(){
        assertThat( userCacheDAO ).isNotNull();
        assertDoesNotThrow( () -> userCacheDAO.getBranchDetailsForLoginUser( "DUMMY_USER" ) );
    }

    @Test
    public void canRunMybatis2(){
        assertThat( limitCheckDAO ).isNotNull();
        assertDoesNotThrow( () ->  limitCheckDAO.fetchBranchIdforUser( "DUMMY_USER" ) );
    }
}
