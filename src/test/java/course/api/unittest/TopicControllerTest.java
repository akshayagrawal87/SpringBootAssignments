package course.api.unittest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import course.api.topic.Topic;
import course.api.topic.TopicController;
import course.api.topic.TopicService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=TopicController.class)
public class TopicControllerTest {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TopicService topicService;
	
	Topic mockTopic=new Topic("Course1", "Spring", "10 Steps"); 
	String exampleTopicJson="{\"name\":\"Spring\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
	@Test
	public void topicController_basic() throws Exception
	{
		
		Mockito.when(topicService.getTopic(Mockito.anyString())).thenReturn(mockTopic);
				

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/topics/").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		//System.out.println(result.getResponse());
		String expected = "{\"id\":\"Course1\",\"name\":\"Spring\",\"description\":[\"10 Steps\"]}";

		//JSONAssert.assertEquals(expected, result.getResponse()
				//.getContentAsString(), true);
		
	
		
		
}
}

	