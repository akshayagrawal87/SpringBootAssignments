package course.api.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	public List<Topic> topics=new ArrayList<>(Arrays.asList(new Topic("Spring", "Spring FrameWork", "Spring Freamework Description"),
			new Topic("Java", "Java FrameWork", "Java Freamework Description"),new Topic("Python", "Python", "Python Framework Description")));
	
	public List<Topic> getAllTopics()
	{
		return topics; 
	}
	
	public Topic getTopic(String id)
	{
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
	}

	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		topics.add(topic);
	}
}

