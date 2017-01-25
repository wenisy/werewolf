package com.cogrood.controller;

import com.cogrood.Application;
import com.cogrood.model.OrderForm;
import com.cogrood.repository.OrderFormRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class OrderFoodControllerTest {

    private MockMvc mockMvc;

    @Mock
    private OrderFormRepository orderFormRepository;

    @Autowired
    @InjectMocks
    private OrderFoodController orderFoodController;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderFoodController).build();
    }

    @Test
    public void shouldReturn400WhenOrderIDDoesNotExists() throws Exception {
        when(orderFormRepository.findOne("abc")).thenReturn(null);
        mockMvc.perform(get("/orders?orderId=abc"))
                .andExpect(status().is(400));
    }

    @Test
    public void shouldReturn200WhenOrderIDExists() throws Exception {
        when(orderFormRepository.findOne("EU389Y3K39")).thenReturn(new OrderForm("EU389Y3K39",null));
        mockMvc.perform(get("/orders?orderId=EU389Y3K39"))
                .andExpect(status().is(200));
    }

    @Test
    public void shouldThrowDatabaseOperationExceptionWhenSaveFailed() throws Exception {
        OrderForm orderForm = new OrderForm("sdfsdfsdf", null);
        String content = asJsonString(orderForm);
        mockMvc.perform(post("/orders/")
                .contentType(MediaType.APPLICATION_JSON).content(content)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}