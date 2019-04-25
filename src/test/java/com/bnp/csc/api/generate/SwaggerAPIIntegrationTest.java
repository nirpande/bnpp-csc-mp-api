package com.bnp.csc.api.generate;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SwaggerAPIIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Disabled("for code generation only")
    public void swaggerJsonExists() throws Exception {
        String contentAsString = mockMvc
                .perform( MockMvcRequestBuilders.get("/v2/api-docs")
                        .accept( MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse().getContentAsString();
        try ( Writer writer = new FileWriter(new File("target/generated-sources/swagger.json"))) {
            IOUtils.write(contentAsString, writer);
        }
    }
}
