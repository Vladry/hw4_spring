package vlad.homework4.controller.account;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import vlad.homework4.DTO.account.AccountTransferDto;
import vlad.homework4.service.AccountService;
import vlad.homework4.service.CustomerService;
import vlad.homework4.service.dtoMappers.AccountRequestDtoMapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;  //import org.junit.jupiter.api.Test;
// org.junit.Test = JUnit 4, org.junit.jupiter.api.Test = JUnit 5
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ContextConfiguration(classes = AccountControllerTest.class)
@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
@Slf4j
public class AccountControllerTest {

//    private static final Logger logger = LoggerFactory.getLogger(AccountControllerTest.class);
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AccountService accService;
    @MockBean
    private CustomerService customerService;
    @MockBean
    private AccountRequestDtoMapper accReqDtoMapper;

    @Test
    public void putAmount() throws Exception {
        AccountTransferDto dto = new AccountTransferDto()
                .setAccNumber("1").setAmount(50.0)
                .setFrom("1").setTo("2");
        ObjectMapper om = new ObjectMapper();
        ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
        String dtoSrt = ow.writeValueAsString(dto);
        when(accService.putAmount(any(String.class), any(Double.class))).thenReturn(true);
//        System.out.println("result of: accService.putAmount(1, 50.0): " + accService.putAmount("1", 50.0));
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/accounts/put-amount")
                        .contentType("application/json").content(dtoSrt))
                .andExpect(status().isOk())
//                .andExpect(status().isBadRequest())
                .andReturn()
//                .andExpect(MockMvcResultMatchers.content().string("true"))
        ;
        String res = result.getResponse().getContentAsString();
        System.out.println("MockMvcResultMatchers.content(): "+res);

    }

    @Test
    public void drawAmount() {
    }

    @Test
    public void transferAmount() {
    }

    @Test
    public void create() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void getById() {
    }
}