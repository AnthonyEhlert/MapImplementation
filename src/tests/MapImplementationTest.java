package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import Exceptions.KeyNotPresentException;
import Exceptions.KeyPresentException;
import Exceptions.MapEmptyException;
import MainClasses.Map;

class MapImplementationTest {

	@Test
	void testMap() {
		// ARRANGE
		Map myMap = new Map();
		boolean actual;
		// ACT
		actual = myMap.isEmpty();
		// ASSERT
		assertTrue(actual);
	}

	@Test
	void testIsEmptyTrue() {
		// ARRANGE
		Map myMap = new Map();
		boolean actual;
		// ACT
		actual = myMap.isEmpty();
		// ASSERT
		assertTrue(actual);
	}

	@Test
	void testIsEmptyFalse() throws KeyPresentException {
		// ARRANGE
		Map myMap = new Map();
		String key = "test@test.com";
		String value = "Test Name";
		boolean actual;
		// ACT
		myMap.insertKey(key, value);
		actual = myMap.isEmpty();
		// ASSERT
		assertFalse(actual);
	}

	@Test
	void testInsertKey() throws KeyPresentException, MapEmptyException, KeyNotPresentException {
		// ARRANGE
		Map myMap = new Map();
		String key = "test@test.com";
		String value = "Test Name";
		String actual, expected;
		expected = "Test Name";
		// ACT
		myMap.insertKey(key, value);
		actual = myMap.getValue(key);
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void testInsertRemoveKey() throws KeyNotPresentException, MapEmptyException, KeyPresentException {
		// ARRANGE
		Map myMap = new Map();
		String key1 = "test@test.com";
		String value1 = "Test Name";
		String key2 = "test2@test.com";
		String value2 = "Test2 Name";
		String actual, expected;
		expected = "Test Name";
		// ACT
		myMap.insertKey(key1, value1);
		myMap.insertKey(key2, value2);
		myMap.removeKey(key2);
		actual = myMap.getValue(key1);
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void testRemoveKey() throws KeyNotPresentException, MapEmptyException, KeyPresentException {
		// ARRANGE
		Map myMap = new Map();
		String key1 = "test@test.com";
		String value1 = "Test Name";
		String key2 = "test2@test.com";
		String value2 = "Test2 Name";
		String actual, expected;
		expected = "Test Name";
		// ACT
		myMap.insertKey(key1, value1);
		myMap.insertKey(key2, value2);
		myMap.removeKey(key2);
		actual = myMap.getValue(key1);
		// ASSERT
		assertEquals(expected, actual);
	}

	
//	@Test
//	void testDequeue() throws QueueFullException, QueueEmptyException {
//		// ARRANGE
//		queue myQueue = new queue();
//		String item = "QueueItem";
//		String actual, expected;
//		expected = item+"3";
//		myQueue.enqueue(item+"1");
//		myQueue.dequeue();
//		myQueue.enqueue(item+"2");
//		myQueue.enqueue(item+"3");
//		myQueue.dequeue();
//		myQueue.enqueue(item+"4");
//		// ACT
//		actual = myQueue.dequeue();
//		// ASSERT
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	void testDequeueEmptyQueue() {
//		// ARRANGE
//		queue myQueue = new queue();
//		// ACT
//		// ASSERT
//		assertThrows(QueueEmptyException.class, () -> myQueue.dequeue());
//	}
//	
//	@Test
//	void testSizeZero() {
//		// ARRANGE
//		queue myQueue = new queue();
//		int actual, expected;
//		expected = 0;
//		// ACT
//		actual = myQueue.size();
//		// ASSERT
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	void testSizeNonZero() throws QueueFullException, QueueEmptyException {
//		// ARRANGE
//		queue myQueue = new queue();
//		String item = "QueueItem";
//		int actual, expected;
//		expected = 2;
//		// ACT
//		myQueue.enqueue(item + "1");
//		myQueue.enqueue(item + "2");
//		myQueue.enqueue(item + "3");
//		myQueue.dequeue();
//		actual = myQueue.size();
//		// ASSERT
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	void testPeek() throws QueueLab.QueueEmptyException, QueueFullException {
//		// ARRANGE
//		queue myQueue = new queue();
//		String item = "QueueItem";
//		String actual, expected;
//		// ACT
//		myQueue.enqueue(item);
//		expected = item;
//		actual = myQueue.peek();
//		// ASSERT
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	void testPeekEmptyQueue() {
//		// ARRANGE
//		queue myQueue = new queue();
//		// ACT
//		// ASSERT
//		assertThrows(QueueEmptyException.class, () -> myQueue.peek());
//	}
//	
//	@Test
//	void testPrintQueueEmptyQueue() {
//		// ARRANGE
//		queue myQueue = new queue();
//		// ACT
//		// ASSERT
//		assertThrows(QueueEmptyException.class, () -> myQueue.printQueue());
//	}
//	
//	@Test
//	void testPrintQueue() throws QueueEmptyException, QueueFullException {
//		// ARRANGE
//		queue myQueue = new queue();
//		String item = "QueueItem";
//		String actual, expected;
//		expected = "QueueItem1\nQueueItem2\n";
//		// ACT
//		myQueue.enqueue(item + "1");
//		myQueue.enqueue(item + "2");
//		actual = myQueue.printQueue();
//		// ASSERT
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	void testPrintQueueWrapAround() throws QueueFullException, QueueEmptyException {
//		// ARRANGE
//		queue myQueue = new queue();
//		String item = "QueueItem";
//		String actual, expected;
//		expected = "QueueItem2\nQueueItem3\n";
//		// ACT
//		myQueue.enqueue(item + "1");
//		myQueue.enqueue(item + "2");
//		myQueue.dequeue();
//		myQueue.enqueue(item + "3");
//		actual = myQueue.printQueue();
//		// ASSERT
//		assertEquals(expected, actual);
//	}


}