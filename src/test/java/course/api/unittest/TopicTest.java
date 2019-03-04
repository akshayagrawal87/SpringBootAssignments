package course.api.unittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import course.api.topic.Topic;
import junit.framework.Assert;

public class TopicTest {

	@Test
	public void test_true() {
		Topic topic=new Topic("django","django framework","django framework description");
		assertTrue(topic.getId()=="django");
		assertTrue(topic.getName()=="django framework");
		assertTrue(topic.getDesription()=="django framework description");
		
	}
	
/*
 *  @Test
    public void testSetForeignWord() {
        Card card = new Card();
        card.setForeignWord("test");
        assertTrue(card.getForeignWord() == "test");
    }	
 */
	@Test
	public void test_false()
	{
		Topic topic =new Topic();
		//test id
		topic.setId("java");
		assertFalse(topic.getId()=="django");
		
		//test name
		topic.setName("java framework");
		assertFalse(topic.getName()=="django framework");
		
		//test descriptiom
		topic.setDesription("jango framework description");
		assertFalse(topic.getDesription()=="django framework description");
		
	}
	
}
