package Run;

import Test.ClientTest;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientTest ct=new ClientTest();
		if(ct.test() ==1)
			System.out.println("Success");
		else
			System.out.println("Failed");
		

	}

}
