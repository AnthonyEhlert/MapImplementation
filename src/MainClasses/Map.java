package MainClasses;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import Exceptions.KeyNotPresentException;
import Exceptions.KeyPresentException;
import Exceptions.MapEmptyException;

/*****************************************************************
 * Name				: MapImplementation
 * Author			: Tony Ehlert
 * Created			: Mar 10, 2023
 * Course			: CIS152 Data Structures
 * Version			: 1.0
 * OS				: Windows 11
 * Copyright		: This is my own original work based on
 *         	  	  	  specifications issued by our instructor
 * Description		: This programs implements a map data structure and its necessary methods to store an email
 * 					  address as the key and the person's name as the value. It includes a driver that adds
 * 					  three people to the map, searches for two people in the map by the key,
 * 					  and then calls a function to remove all the items
 *					 Input: Email addresses and names needed to create the map
 *					 Output: Print statements to the console after method calls to verify that
 *							 the methods and data structure are working properly
 * Academic Honesty	: I attest that this is my original work.
 * I have not used unauthorized source code, either modified or 
 * unmodified. I have not given other fellow student(s) access to
 * my program.         
 *****************************************************************/
public class Map {

	// DATA MEMBERS
	private Queue<MapNode> mapQueue; // queue data structure to hold the nodes

	// NECESSARY METHODS

	/**
	 * This is the default no-arg constructor the creates a LinkedList that
	 * implements the queue data structure to hold the nodes
	 */
	public Map() {
		this.mapQueue = new LinkedList<>();
	}

	
	/**
	 * This method returns true if map is empty, else false
	 * 
	 * @param map - map to be checked if empty or not
	 * @return - boolean value indicating if map is empty
	 */
	public boolean isEmpty() {
		return mapQueue.isEmpty();
	}
	
	/**
	 * This method search the map for a matching key and returns true if found. If
	 * map is empty throws MapEmptyException
	 * 
	 * @param key - the email address key to search the map for
	 * @return - boolean value representing if the key was found
	 * @throws MapEmptyException - thrown if the map is empty
	 */
	public boolean hasKey(String key) throws MapEmptyException {

		// check for empty map
		if (mapQueue.isEmpty()) {
			throw new MapEmptyException();
		}

		// boolean variable to return
		boolean keyFound = false;

		// create iterator for mapQueue
		Iterator<MapNode> mapQueueIter = mapQueue.iterator();
		while (mapQueueIter.hasNext()) {
			if (key.equalsIgnoreCase(mapQueueIter.next().getEmailKey())) {
				keyFound = true;
				break;
			}
		}

		return keyFound;
	}

	/**
	 * This method searches the map for a matching key email and returns the
	 * corresponding name as a string. If the key is not found throws
	 * KeyNotPResentException. If map is empty throws MapEmptyException
	 * 
	 * @param key - email address key to search for
	 * @return - matching name string for matching key
	 * @throws MapEmptyException      - thrown in map is empty
	 * @throws KeyNotPresentException - thrown if key was not found
	 */
	public String getValue(String key) throws MapEmptyException, KeyNotPresentException {

		// check for empty map
		if (mapQueue.isEmpty()) {
			throw new MapEmptyException();
		}

		// create iterator for mapQueue
		Iterator<MapNode> mapQueueIter = mapQueue.iterator();

		// while loop to check for matching key
		while (mapQueueIter.hasNext()) {
			MapNode current = mapQueueIter.next();
			if (key.equalsIgnoreCase(current.getEmailKey())) {
				return current.getNameValue();
			}
		}

		// key not found, throw exception
		throw new KeyNotPresentException();
	}

	/**
	 * This method checks if the key value is present in the mapQueue and throws the
	 * custom KeyPresentException if the key is found, else it creates a new MapNode
	 * and adds it to the mapQueue
	 * 
	 * @param key   - email address to be used as the key
	 * @param value - name to be used as the value
	 * @throws KeyPresentException - thrown in key is found in mapQueue
	 */
	public void insertKey(String key, String value) throws KeyPresentException {

		// check for key in map if map size is greater than zero
		if (!mapQueue.isEmpty()) {
			// create iterator for mapQueue
			Iterator<MapNode> mapQueueIter = mapQueue.iterator();
			while (mapQueueIter.hasNext()) {
				if (key.equalsIgnoreCase(mapQueueIter.next().getEmailKey())) {
					throw new KeyPresentException();
				}
			}
		}

		// key not present in mapQueue, so add to mapQueue
		mapQueue.add(new MapNode(key, value));

	}

	/**
	 * This method searches for a matching key(email address) and removes it from
	 * the mapQueue if found, else throws KeyNotPresentException. If the map is
	 * empty the custom MapEmptyException is thrown
	 * 
	 * @param key - email key to be removed from map
	 * @throws KeyNotPresentException- thrown if key was not found in mapQueue
	 * @throws MapEmptyException       - thrown if map is empty
	 */
	public void removeKey(String key) throws KeyNotPresentException, MapEmptyException {
		// check for empty map
		if (mapQueue.isEmpty()) {
			throw new MapEmptyException();
		}

		// create iterator for mapQueue
		Iterator<MapNode> mapQueueIter = mapQueue.iterator();

		// while loop to check for matching key value
		while (mapQueueIter.hasNext()) {
			MapNode current = mapQueueIter.next();
			if (key.equalsIgnoreCase(current.getEmailKey())) {
				mapQueue.remove(current);
				return;
			}
		}

		// key not found in mapQueue, so throw KeyNotPresetException
		throw new KeyNotPresentException();
	}

	/**
	 * This helper method prints the contents of the map. if the map is empty a
	 * custom MapEmptyException is thrown
	 * 
	 * @throws MapEmptyException - thrown if map is empty
	 */
	public void printMap() throws MapEmptyException {

		// check if map is empty
		if (mapQueue.isEmpty()) {
			throw new MapEmptyException();
		}

		// create iterator for mapQueue
		Iterator<MapNode> mapQueueIter = mapQueue.iterator();

		System.out.println("Map Contents:");
		while (mapQueueIter.hasNext()) {
			MapNode current = mapQueueIter.next();
			System.out.println("Key: " + current.getEmailKey() + ", Value: " + current.getNameValue());
		}
	}

}
