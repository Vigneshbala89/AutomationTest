package listenerimplimentation;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer{

	int count=0;
	int limit=5;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<limit) {
			count++;
			return true;
		}
		return false;
	}

}
