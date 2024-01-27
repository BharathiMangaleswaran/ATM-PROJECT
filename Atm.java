 
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Atm extends Account{
	Scanner menuInput=new Scanner(System.in);
	DecimalFormat moneyFormat =new DecimalFormat("'$' ###,##0.00");
	HashMap<Integer ,Integer> data =new HashMap<Integer , Integer>();
	public void getLogin() throws IOException{
		int x=1;
		do {
			try {

				data.put(4007, 2003);
				data.put(989947, 717876);
				System.out.println("Welcome to ATM Project");
				System.out.println("Enter your customer Number");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.print("Enter your PIN Number");
				setPinNumber(menuInput.nextInt());
				
				
			}catch(Exception e) {
				System.out.println("\n" +"Invalid character(s).Only Numbers." +"\n");
				x=2;
			}
			
			int cn=getCustomerNumber();
			int pn=getPinNumber();
			if(data.containsKey(cn) && data.get(cn)==pn) {
				getAccountType();
			}else
				System.out.println("\n" +"Wrong customer Number or Pin number"+"\n");
			
		}while(x==1);
	}
	
	public void getAccountType() {
		System.out.println("Select the account you want to access:");
		System.out.println("Type1-Checaking Account");
		System.out.println("Type2-Saving Account");
		System.out.println("Type3-Exit");
		
		int selection =menuInput.nextInt();
		
		switch (selection) {
		case 1:
			getChecking();
			break;
		case 2:
			getSaving();
			break;
		case 3:
			System.out.println(" Thank You for using this ATM,bye. \n");
			break;
			
		default:
			System.out.println("\n" +"Invalid Choice" +"\n");
			getAccountType();
			
				
			
		}
		
	
	}
	public void getChecking() {
		System.out.println("Checking Account:");
		System.out.println("Type1-View Balance");
		System.out.println("Type2-Withdraw Funds");
		System.out.println("Type3-Deposit Funds");
		System.out.println("Type4-Exit");
		System.out.print("choice");
		
		int selection=menuInput.nextInt();
		
		switch(selection) {
		case 1:
			System.out.println("Checking Account Balance:" +moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thankyou for using this ATM,bye");
			break;
			default:
				System.out.println("\n" +"Invalid choice" +"\n");
				getChecking();
		}
	}

	public void getSaving() {
		System.out.println("Saving Account:");
		System.out.println("Type1-View Balance");
		System.out.println("Type2-Withdraw Funds");
		System.out.println("Type3-Deposit Funds");
		System.out.println("Type4-Exit");
		System.out.println("choice");
		
		int selection=menuInput.nextInt();
		
		switch(selection) {
		case 1:
			System.out.println("Saving Account Balance"  +moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;
		case 2:
			getsavingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getSavingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("ThankYou for using this ATM ,bye");
			break;
			default:
				System.out.println("\n"+"Invalid choice." +"\n");
				getChecking();
			
		}
	}

	
}
