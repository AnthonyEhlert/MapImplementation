package MainClasses;
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
public class MapDriver {

	public static void main(String[] args) {

		// create map data structure
		Map emailMap = new Map();
		
		System.out.println("START OF isEmpty() TRUE TEST");
		System.out.println("Is map empty? " + emailMap.isEmpty());
		System.out.println("END OF isEmpty() TRUE TEST");

		// create variables used for testing
		String searchKey1 = "aehlert@dmacc.edu";
		String searchKey2 = "tehlert@dmacc.edu";
		String searchKey3 = "aEHLERT@DMacc.EDU";
		String searchKey4 = "srodgers@avengers.com";

		// test of removeKey, hasKey, getValue, printMap from empty map
		// (EmptyMapException tests)
		System.out.println("\nSTART OF MapEmptyException TESTS");
		try {
			emailMap.removeKey("tehlert");
		} catch (MapEmptyException e) {
			System.out.println("removeKey() MapEmptyException thrown");
		} catch (KeyNotPresentException ex) {
			System.out.println("removeKey() KeyNotPresentException thrown");
		}

		try {
			emailMap.hasKey("tehlert@dmacc.edu");
		} catch (MapEmptyException e) {
			System.out.println("hasKey() MapEmptyException thrown");
		}

		try {
			emailMap.getValue("tehlert@dmacc.edu");
		} catch (MapEmptyException e) {
			System.out.println("getValue() MapEmptyException thrown");
		} catch (KeyNotPresentException ex) {
			System.out.println("getValue() KeyNotPresentException thrown");
		}

		try {
			emailMap.printMap();
		} catch (MapEmptyException e) {
			System.out.println("printMap() MapEmptyException thrown");
		}
		System.out.println("END OF MapEmptyException TESTS");

		// add people to map
		try {
			emailMap.insertKey("aehlert@dmacc.edu", "Tony Ehlert");
			emailMap.insertKey("srodgers@avengers.com", "Steve Rodgers");
			emailMap.insertKey("tStarK@AVENGERS.com", "Tony Stark");
		} catch (KeyPresentException e) {
			System.out.println("insertKey() KeyPresentException thrown");
		}

		// print contents of map
		System.out.println("\nSTART OF PRINT CONTENTS OF MAP TEST");
		try {
			emailMap.printMap();
		} catch (MapEmptyException e) {
			System.out.println("printMap() MapEmptyException thrown");
		}
		System.out.println("END OF PRINT CONTENTS OF MAP TEST");

		// test of insertKey KeyPresentException
		System.out.println("\nSTART OF KeyPresentException TESTS");
		try {
			emailMap.insertKey("aEHLert@dmacc.edu", "Tony Ehlert");
		} catch (KeyPresentException e) {
			System.out.println("insertKey() KeyPresentException thrown");
		}
		System.out.println("END OF KeyPresentException TESTS");

		// test of removeKey, getValue KeyNotPresentException
		System.out.println("\nSTART OF KeyNotPresentException TESTS");
		try {
			emailMap.removeKey("tehlert");
		} catch (MapEmptyException e) {
			System.out.println("removeKey() MapEmptyException thrown");
		} catch (KeyNotPresentException ex) {
			System.out.println("removeKey KeyNotPresentException thrown");
		}

		try {
			emailMap.getValue("tehlert");
		} catch (MapEmptyException e) {
			System.out.println("getValue() MapEmptyException throw");
		} catch (KeyNotPresentException ex) {
			System.out.println("getValue() KeyNotPresentException thrown");
		}

		System.out.println("END OF KeyNotPresentException TESTS");

		// test of hasKey method
		System.out.println("\nSTART OF hasKey() TESTS");
		try {
			System.out.println("Key: " + searchKey1 + " in map? " + emailMap.hasKey(searchKey1));
			System.out.println("Key: " + searchKey2 + " in map? " + emailMap.hasKey(searchKey2));
			System.out.println("Key: " + searchKey3 + " in map? " + emailMap.hasKey(searchKey3));
			System.out.println("Key: " + searchKey4 + " in map? " + emailMap.hasKey(searchKey4));
		} catch (MapEmptyException e) {
			System.out.println("hasKey() MapEmptyException thrown");
		}
		System.out.println("END OF hasKey() TESTS");

		// search for at least two people by key(e-mail address)
		System.out.println("\nSTART OF getValue() TESTS");
		try {
			System.out.println("Key: " + searchKey1 + " has a value/name of: " + emailMap.getValue(searchKey1));
			System.out.println("Key: " + searchKey4 + " has a value/name of: " + emailMap.getValue(searchKey4));
		} catch (KeyNotPresentException e) {
			System.out.println("getValue() KeyNotPresentException thrown");
		} catch (MapEmptyException e) {
			System.out.println("getValue() MapEmptyException thrown");
		}
		System.out.println("END OF getValue() TESTS");

		// remove all by keys
		try {
			emailMap.removeKey("aehlert@dmacc.edu");
			emailMap.removeKey("srodgers@avengers.com");
			emailMap.removeKey("tstark@avengers.com");

			System.out.println("\nENSURE MAP IS EMPTY TEST START");
			emailMap.removeKey(searchKey4);
		} catch (MapEmptyException e) {
			System.out.println("Map is now empty MapEmptyException thrown");
		} catch (KeyNotPresentException ex) {
			System.out.println("removeKey() KeyNotPresentException thrown");
		}
		System.out.println("ENSURE MAP IS EMPTY TEST END");

	}

}
