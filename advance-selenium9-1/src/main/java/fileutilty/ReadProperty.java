package fileutilty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
	
	FileInputStream fis;
	public String fetchProperty(String key) {
		
		try {
			fis = new FileInputStream("./src/test/resources/demo.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties pObj=new Properties();
		try {
			pObj.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String data = pObj.getProperty(key);
		return data;
	}

}
