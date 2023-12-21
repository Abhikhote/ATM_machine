package atm_project_package;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Options extends Account {

	Scanner sc=new Scanner(System.in);
	DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");
	
	HashMap<Integer,Integer> data =new HashMap<>();
	
	public void getLogin() throws IOException
	{
		int x=1;
		do
		{
			try 
			{
				data.put(123456, 555);
				
				System.out.println("Welcome to ATM project");
				System.out.println("Enter Coustomer Number");
				setCustomerNumber(sc.nextInt());
				System.out.println("Enter your pin number");
				setPinNumber(sc.nextInt());
				
			}
			catch(Exception e)
			{
				System.out.println("\n"+"INvalid Character . numbers only."+"\n");
				x=2;
			}
			for(Entry<Integer, Integer> entry:data.entrySet())
			{
				if(entry.getKey()==getCustomerNumber() && entry.getValue()==getPinNumber())
				{
					getAccountType();
					
				}
			}
			System.out.println("Wrong Customer number or pin number ");
			
		}
		while(x==1);
	}
	
	public void getAccountType()
	{
		System.out.println("Select Account that you want to access: ");
		System.out.println("1 : Checking Account ");
		System.out.println("2 : Saving Account");
		System.out.println("3 : Exit");
		System.out.println("Choice: ");
		
		int choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:
			getChecking();
		break;
		case 2:
			getSaving();
		break;
		case 3:
			System.out.println("Thanks for using ATM.");
		break;
		default:
			System.out.println("Invalid Choice");
			getAccountType();
			
		}
		
	}
	
	public void getChecking()
	{
		System.out.println("Checking Account : ");
		System.out.println("1 : View Balance ");
		System.out.println("2 : Withdraw Funds");
		System.out.println("3 : Deposit Funds");
		System.out.println("4 : Exit");
		
		int choice =sc.nextInt();
		
		switch(choice)
		{
		case 1:
			System.out.println("Checking account balance: "+moneyFormat.format(getCheckingBalance()));
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
			System.out.println("Thank you for using ATM");
		break;
		default:
			System.out.println("Invalid Input");
			getChecking();
		}
	}
	
	public void getSaving()
	{

		System.out.println("Saving Account : ");
		System.out.println("1 : View Balance ");
		System.out.println("2 : Withdraw Funds");
		System.out.println("3 : Deposit Funds");
		System.out.println("4 : Exit");
		
		int choice =sc.nextInt();
		
		switch(choice)
		{
		case 1:
			System.out.println("Saving Account balance: "+moneyFormat.format(getCheckingBalance()));
			getAccountType();
		break;
		case 2:
			getSavingWithdrawInput();
			getAccountType();
		break;
		case 3:
			getSavingDepositInput();
			getAccountType();
		break;
		case 4:
			System.out.println("Thank you for using ATM");
		break;
		default:
			System.out.println("Invalid Input");
			getChecking();
		}
		
	}
	
	
}
