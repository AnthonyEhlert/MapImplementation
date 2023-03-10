package MainClasses;

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
public class MapNode {

	// DATA MEMBERS
	private String emailKey;
	private String nameValue;
	
	/**
	 * Default no-arg constructor with private access modifier to enforce
	 * no null values for data members upon creation of object 
	 */
	private MapNode() {
	}
	
	/**
	 * This constructor accepts the email address and name of person and creates a MapNode object
	 * that can be inserted into a map data structure
	 * 
	 * @param email - email address to be used as the key
	 * @param name - name of person to be used as the value
	 */
	public MapNode(String email, String name) {
		this.emailKey = email;
		this.nameValue = name;
	}

	/**
	 * @return the emailKey
	 */
	public String getEmailKey() {
		return emailKey;
	}

//	/**
//	 * @param emailKey the emailKey to set
//	 */
//	public void setEmailKey(String emailKey) {
//		this.emailKey = emailKey;
//	}

	/**
	 * @return the nameValue
	 */
	public String getNameValue() {
		return nameValue;
	}

//	/**
//	 * @param nameValue the nameValue to set
//	 */
//	public void setNameValue(String nameValue) {
//		this.nameValue = nameValue;
//	}
	
	
}
