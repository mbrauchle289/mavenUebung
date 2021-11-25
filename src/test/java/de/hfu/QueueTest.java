package de.hfu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QueueTest {

	
	@Test(expected=IllegalArgumentException.class, timeout=1000)
	public void testQueueException() {
		new Queue(0);
	}
	
	@Test
	public void testQueue() {
		int maxLength = 3;
		Queue q = new Queue(3);
		
		assertEquals(q.queue.length,maxLength);
		
		
	}
	
	@Test
	public void testEnqueue() {
		int maxLength = 3;
		Queue q = new Queue(maxLength);
		int lastElement = 3;
		
		q.enqueue(3);
		q.enqueue(2);
		q.enqueue(1);
		q.enqueue(3);
		
		assertTrue(q.queue[maxLength-1]==lastElement);
	}
	
	@Test
	public void testDequeue() {
		Queue q = new Queue(3);
		int firstElement = 5;
		q.enqueue(firstElement);
		q.enqueue(3);
		q.enqueue(1);
		
		assertEquals(firstElement, q.dequeue());
	}
	
	@Test(expected=IllegalStateException.class, timeout=1000)
	public void testDequeueException() {
		Queue q = new Queue(3);
		q.dequeue();
		
	}
	
}
