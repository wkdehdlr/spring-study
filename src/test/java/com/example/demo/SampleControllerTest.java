package com.example.demo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @MockBean
    SampleService sampleService;

    @Autowired
    MockMvc mockMvc;


    @Test
    public void hello() throws Exception{
        mockMvc.perform(get("/hello"))
                .andExpect(content().string("doik"));

        assertThat(outputCapture.toString())
                .contains("holoman")
                .contains("twosomeplace");


    }
}