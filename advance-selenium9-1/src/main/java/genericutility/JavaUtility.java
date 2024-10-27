package genericutility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber(int range) {
		Random random=new Random();
		int number = random.nextInt(range);
		return number;
	}
	
	public Date getSystemDate() {
		return new Date();
	}
	
	
	public String getDateInDDMMYYYY() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yy");
		return sdf.format(date);
	}
	
	
}
