package general.tests;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.entity.TestEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={com.test.app.TestApp.class})
@AutoConfigureMockMvc
public class TestEndPointsWithMockMvc
{
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
    public void testHomeResponseTrue() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON);
		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
        String responseMessage = result.getResponse().getContentAsString();
        assertTrue(responseMessage.equals("Test Application"));
    }
	
	@Test
    public void testHomeResponseFalse() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON);
		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
        String responseMessage = result.getResponse().getContentAsString();
        assertFalse(responseMessage.equals("Ronaldo"));
    }
	
	@Test
    public void testEntityResponseObject() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/testEntity");
		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
        TestEntity response = objectMapper.readValue(result.getResponse().getContentAsString(), TestEntity.class);
        assertTrue(response.getName().equals("Test Entity"));
    }
	
	@Test
    public void testPostUrl() throws Exception {
		TestEntity inputEntity = new TestEntity();
		inputEntity.setId(1);
		inputEntity.setName("Ronaldo");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/setEntity")
										.content(objectMapper.writeValueAsString(inputEntity))
										.contentType("application/json");
		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
        String message = result.getResponse().getContentAsString();
        assertTrue(message.equals("Entity Created!"));
    }
	
	@Test
    public void testHomeUrlWithMatchers() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print())
        .andExpect(content().string(containsString("Test Application")));
    }

}
