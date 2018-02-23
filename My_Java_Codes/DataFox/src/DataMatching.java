
import java.io.File;
import java.io.FileInputStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.opencsv.CSVReader;


public class DataMatching {
	
	static String queryString = "name";
	static String queryOutput = "id";

	
	public static void main(String[] args) throws Exception
	{
		
		  // Specify the location where output will be stored
		  FileWriter writer = new FileWriter("/Users/rsalecha/Desktop/test-output.txt");
		  //Build CSV reader instance
	      CSVReader reader = new CSVReader(new FileReader("src/crm.csv"), ',', '"', 1);
	       
	      //Read all rows at once
	      List<String[]> allRows = reader.readAll();
	      
	      //Close the CSV reader
	      reader.close();
	       
	      // Write the first line in the output file
	      writer.write("Matches");
	      writer.write(System.getProperty( "line.separator" ));
	      
	      //Read CSV line by line and match the company name
	     for(String[] row : allRows){
	    	 System.out.println(row[0]);
	    	 writer.write(JsonParse(row[0]));  
	    	 writer.write(System.getProperty( "line.separator" ));
	     }
	   	    
	     //Close the File writer
	     writer.close();   
	     
	}
	

	public static String JsonParse(String companyName) throws IOException, JSONException {
		
		String collect = null;
        //Check if database file is valid
		File f = new File("src/db.json");
		
		if (f.exists()){
			
			InputStream is = new FileInputStream("src/db.json");
			//Convert the Json file contents to string.
			String jsonTxt = IOUtils.toString(is);
                
			//Extract JSONArray from the string
			JSONArray array = new JSONArray(jsonTxt);
			List<String> companyList = new ArrayList<>();
            
			//Loop through the list and search for result.
			for(int index = 0; index < array.length(); ++index) {
                JSONObject companyObject = array.getJSONObject(index);
                
                if(companyName.equals(companyObject.get(queryString))){
                	companyList.add((String) companyObject.get(queryOutput));
                }
            }
        
			collect = companyList.stream().collect(Collectors.joining(","));   
        } else {
        	System.out.println("Database File Not Found");
        }
		
		return collect;
	}
	

	
}

	