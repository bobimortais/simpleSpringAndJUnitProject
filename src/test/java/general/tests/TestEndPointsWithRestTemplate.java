package general.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.entity.TestEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes={com.test.app.TestApp.class})
public class TestEndPointsWithRestTemplate
{
	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHomeResponseFalse() throws Exception
    {
    	String response = this.restTemplate.getForObject("http://localhost:" + port + "/",String.class);
    	assertFalse(response.equals("Ronaldo"));
    }
    
    @Test
    public void testHomeResponseTrue() throws Exception
    {
    	String response = this.restTemplate.getForObject("http://localhost:" + port + "/",String.class);
    	assertTrue(response.equals("Test Application"));
    }
    
    @Test
    public void testTestEntityTrue() throws Exception
    {
    	TestEntity response = this.restTemplate.getForObject("http://localhost:" + port + "/testEntity",TestEntity.class);
    	assertTrue(response.getId() == 1);
    }
    
    @Test
    public void testTestEntityFalse() throws Exception
    {
    	TestEntity response = this.restTemplate.getForObject("http://localhost:" + port + "/testEntity",TestEntity.class);
    	assertFalse(response.getId() == 0);
    }
    
}
