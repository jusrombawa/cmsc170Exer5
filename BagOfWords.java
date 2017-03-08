//ROMBAWA, JUSTIN AARON S.
//CMSC 170 U-3L

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class BagOfWords
{
	//array for words (with duplicates)
    private String [] bag;

    
    //hash maps for words with their respective counts
    private HashMap<String,Integer> bagMap;
    
    private int bagTotal;
    private int bagDictSize; //ilang taon na ko sa 170 but this never gets old
    
    //file i/o stuff
    private BufferedReader br;
    private FileReader fr;
    
	//filenames
    private String bagInput;
    
	//temp variables
    private String tempInput; //used to compile all messages in bag into one string for splitting
    private String currLine; //temp String for current line in file read
	private Integer tempInt; //holder for hashmap value to be modified
	private Object[] keyArray; //for... stuff. mamaya na to.
    
    //constructor 1: for file input
    public BagOfWords(String fileInput)
    {
    	//some init, nothing special
    	bagMap = new HashMap<String,Integer>();

        bagInput = fileInput;
        tempInput = new String();
        
        //read file
		try
		{
			fr = new FileReader(bagInput);
			br = new BufferedReader(fr);
			while((currLine = br.readLine()) != null)
			{
				//if empty, tempInput is currLine
				if(tempInput.isEmpty())
					tempInput = currLine ;
				//else append with space in between (for tokenizing if that's even a word)
				else
					tempInput = tempInput + " " + currLine;
			}
    	}
    	
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}

		finally
		{
			try
			{
				if(br != null)
					br.close();
				if(fr != null)
					fr.close();
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}

		//tokenize bag
		bag = tempInput.split(" ");
		//convert to lower case and remove non-alphanumeric characters (if any)
		for(int i=0;i<bag.length;i++)
		{
			bag[i] = bag[i].toLowerCase();
			bag[i] = bag[i].replaceAll("[^a-zA-Z0-9]", "");

		}
		
		//place bag words on hash map, along with their count
		//i mean i could join this with the other loop, but for readability's sake...
		for(int i=0;i<bag.length;i++)
		{
			//if already in map, take value, add 1, replace key-value
			if(bagMap.containsKey(bag[i]))
			{
				tempInt = bagMap.get(bag[i]);
				tempInt++;
				bagMap.put(bag[i],tempInt);
				tempInt = 0; //clear just in case
			}
			//else just add to hash map
			else
			{
				bagMap.put(bag[i],1);
			}
		}
		
		//temporarily set to 0
		bagTotal = 0;
		
		//total words and dict sizes
		bagDictSize = bagMap.size();

		
		//hold keys in... object array? can't typecast for some reason.
		keyArray = bagMap.keySet().toArray(); //okay... so this is a thing. 
		
		for(int i=0;i<bagMap.size();i++)
		{
			bagTotal += bagMap.get(keyArray[i]);
		}		
	}
	
	//constructor 2: for one-line message
	public BagOfWords(String message, boolean msgFlag)
    {
    	//some init, nothing special
    	bagMap = new HashMap<String,Integer>();
    	tempInput = message;

        
        //tokenize bag
		bag = tempInput.split(" ");
		//convert to lower case and remove non-alphanumeric characters (if any)
		for(int i=0;i<bag.length;i++)
		{
			bag[i] = bag[i].toLowerCase();
			bag[i] = bag[i].replaceAll("[^a-zA-Z0-9]", "");

		}
		
		//place bag words on hash map, along with their count
		//i mean i could join this with the other loop, but for readability's sake...
		for(int i=0;i<bag.length;i++)
		{
			//if already in map, take value, add 1, replace key-value
			if(bagMap.containsKey(bag[i]))
			{
				tempInt = bagMap.get(bag[i]);
				tempInt++;
				bagMap.put(bag[i],tempInt);
				tempInt = 0; //clear just in case
			}
			//else just add to hash map
			else
			{
				bagMap.put(bag[i],1);
			}
		}
		
		//temporarily set to 0
		bagTotal = 0;
		
		//total words and dict sizes
		bagDictSize = bagMap.size();

		
		//hold keys in... object array? can't typecast for some reason.
		keyArray = bagMap.keySet().toArray(); //okay... so this is a thing. 
		
		for(int i=0;i<bagMap.size();i++)
		{
			bagTotal += bagMap.get(keyArray[i]);
		}		
	}
		

    
    //getters
    
    public HashMap getBagMap()
    {
    	return bagMap;
    }
    
    public Object[] getBagWords()
    {
    	return keyArray;
    }
   
    
    public int getBagTotal()
    {
		return bagTotal;
	}
    public int getBagDictSize()
    {
    	return bagDictSize;
    }
}
