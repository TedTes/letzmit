package com.tutego.date4u;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.tutego.date4u.core.Quotes;
import com.tutego.date4u.rest.QuoteRestController;
import static org.mockito.BDDMockito.*;

//NOTE:  set free port when testing parallel servers to avoid port conflict
//@SpringBootTest( webEnvironment = WebEnvironment.RANDOM_PORT )
@WebMvcTest(QuoteRestController.class)
@Import(Quotes.class)
public class QuoteRestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private Quotes quotes;

    @Test
    void first_quote_is_a_string() throws Exception {
        given(quotes.quote(1)).willReturn("Be happy!");
        mockMvc.perform(get("/api/quotes?index=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Be happy!"));
    }

}
