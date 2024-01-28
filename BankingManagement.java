/* Name        :      Banking Management System 
 * Author      :      Yogesh Purohit
 * Date        :      26/9/2022
 * Description :      Java Program
 * Software    :      Notepad(Text Editor) and Command Prompt(Console Screen)
 */
import java.util.Scanner;
import java.io.IOException;
	class BankDetails
	{
		private String acc_no;
		private String name;
		private String acc_type;
		private String mobile_no;
		private long balance;
		int n=0;
		Scanner sc=new Scanner(System.in);
		
		public void openAccount()
		{
			System.out.println("Enter Account Number :");
			acc_no=sc.next();
			do{
				n=0;	
				System.out.println("Enter Account Type[Current/Savings] :");
				acc_type=sc.next();
				if( (acc_type.equals("Current")) || (acc_type.equals("Savings")) )
				{
					n=1;
				}
				else
				{
					System.out.println("Please Enter One of them [Current/Savings]......");
				}
			}while(n==0);
			System.out.println("Enter Account Holder Name :");
			name=sc.next();
			System.out.println("Enter Mobile Number of Account Holder : ");
			mobile_no=sc.next();
			do{
				n=0;
				if(acc_type.equals("Savings"))
				{			
					System.out.println("Enter Initial Balance to Deposit [For Savings >=500] ");
					balance=sc.nextLong();
					if(balance<500)
					{
						System.out.println("Please Enter Sufficient Amount");
					}
					else
					{
						n=1;
					}
				}
				else 
				{
					if(acc_type.equals("Current"))
					{
						System.out.println("Enter Initial Balance to Deposit  [For Current >=1000] : ");
						balance=sc.nextLong();
						if(balance<1000)
						{
							System.out.println("Please Enter Sufficient Amount");
						}
						else
						{
							n=1;
						}
					}	
				}
			}while (n==0);			
		}
		
		public void modifyAccount()
		{
			System.out.println("\n\t\tModification of Account...............");
			System.out.println("--------------------------------------------------------------");
			System.out.println("Enter New Account Number :");
			acc_no=sc.next();
			System.out.println("Enter Account Type[Current/Savings] :");
			acc_type=sc.next();
			System.out.println("Enter Account Holder Name :");
			name=sc.next();
			System.out.println("Enter New Mobile Number of Account Holder : ");
			mobile_no=sc.next();

		}
		public void showAccount()
		{
			System.out.println("Name of Account Holder : "+name);
			System.out.println("Account Number : "+acc_no);
			System.out.println("Account Type : "+acc_type);
			System.out.println("Balance : "+balance);
			System.out.println("Mobile Number  : "+mobile_no);

		}
		
		public void deposit()
		{
			long amount;
			System.out.println("Enter the Amount you want to deposit : ");
			amount=sc.nextLong();
			balance=balance+amount;
		}
		
		public void withdraw()
		{
			long amount;
			System.out.println("Enter the Amount you want to Withdraw : ");
			amount=sc.nextLong();
			if(balance>=amount)
			{
				balance=balance-amount;
				System.out.println("Balance After Withdrawl : "+balance);
			}
			else
			{
				System.out.println("Your Balance is Less than "+amount+" \tTransaction Failed due to Insufficient Balance");
			}
		}
		
		public boolean search(String ac_no)
		{
			if(acc_no.equals(ac_no))
			{
				showAccount();
				return(true);
			}
			else
			{
				return(false);
			}
		}
	}
	
	
	public class BankingManagement
	{
	public static void main(String args[])
	{
		try{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}catch(Exception e){
			System.out.println(e);
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("How many numbers of Customers do You want to Input :");
		int n=sc.nextInt();
		BankDetails c[]=new BankDetails[50];
		for(int i=0;i<n;i++)
		{
			try{
				new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			}catch(Exception e){
				System.out.println(e);
			}
			System.out.println("\t\tCustomer No. "+(i+1));
			System.out.println("------------------------------------------------------------------------");
			c[i] = new BankDetails();
			c[i].openAccount();
			System.out.println("-----------------------------------------------------------------");
			System.out.println("Press any Key to Contnue");
			sc.next().charAt(0);
		}
		
		int ch;
		do
		{
			try{
				new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			}catch(Exception e){
				System.out.println(e);
			}
			System.out.println("\n\n\t\t*********Banking System Application**************");
			System.out.println("\n\t1.Add New Account.\n\t2.Display All Account Details.\n\t3.Search by Account Number.\n\t4.Deposit the Amount.\n\t5.Withdraw the amount.\n\t6.Modify the Account\n\t7.Remove the Account\n\t8.Exit");
			System.out.println("\nEnter Your Choice : ");
			ch=sc.nextInt();
			switch(ch)
			{
				case 1:
					try{
						new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
					}catch(Exception e){
						System.out.println(e);
					}
					n=(n+1);
					System.out.println("\t\tCustomer No. "+(n));
					System.out.println("------------------------------------------------------------------------");
					c[n-1]=new BankDetails();
					c[n-1].openAccount();
					System.out.println("-----------------------------------------------------------------");
				case 2:
					try{
						new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
					}catch(Exception e){
						System.out.println(e);
					}
					for(int i=0;i<n;i++)
					{
						System.out.println("------------------------------------------------------------------------");
						c[i].showAccount();
						System.out.println("------------------------------------------------------------------------");
					}
					System.out.println("Press any Key to Contnue");
					sc.next().charAt(0);
					break;
				case 3:
					try{
						new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
					}catch(Exception e){
						System.out.println(e);
					}
					System.out.println("Enter Account no. You want to Search : ");
					String ac_no=sc.next();
					boolean found=false;
					for(int i=0;i<n;i++)
					{
						found=c[i].search(ac_no);
						if(found)
						{
							break;
						}
					}
					if(!found)
					{
						System.out.println("Search Failed ! Account Does not Exists !........");
					}
					System.out.println("Press any Key to Contnue");
					sc.next().charAt(0);
					break;
				case 4:
					try{
						new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
					}catch(Exception e){
						System.out.println(e);
					}
					System.out.println("Enter Account No. : ");
					ac_no=sc.next();
					found=false;
					for(int i=0;i<n;i++)
					{
						found=c[i].search(ac_no);
						if(found)
						{
							c[i].deposit();
							break;
						}
					}
					if(!found)
					{
						System.out.println("Search Failed ! Account Does not Exists !........");
					}
					System.out.println("Press any Key to Contnue");
					sc.next().charAt(0);
					break;
				case 5:
					try{
						new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
					}catch(Exception e){
						System.out.println(e);
					}
					System.out.println("Enter Account No. : ");
					ac_no=sc.next();
					found=false;
					for(int i=0;i<n;i++)
					{
						found=c[i].search(ac_no);
						if(found)
						{
							c[i].withdraw();
							break;
						}
					}
					if(!found)
					{
						System.out.println("Search Failed ! Account Does not Exists !........");
					}
					System.out.println("Press any Key to Contnue");
					sc.next().charAt(0);
					break;
				case 6:
					try{
						new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
					}catch(Exception e){
						System.out.println(e);
					}
					System.out.println("Enter Account No. : ");
					ac_no=sc.next();
					found=false;
					for(int i=0;i<n;i++)
					{
						found=c[i].search(ac_no);
						if(found)
						{
							c[i].modifyAccount();
							break;
						}
					}
					if(!found)
					{
						System.out.println("Search Failed ! Account Does not Exists !........");
					}
					System.out.println("Press any Key to Contnue");
					sc.next().charAt(0);
					break;
				case 7:
					try{
						new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
					}catch(Exception e){
						System.out.println(e);
					}
					System.out.println("Enter Account No. : ");
					ac_no=sc.next();
					found=false;
					for(int i=0;i<n;i++)
					{
						found=c[i].search(ac_no);
						if(found)
						{
							c[i]=c[n-1];
							n=n-1;
							break;
						}
					}
					if(!found)
					{
						System.out.println("Search Failed ! Account Does not Exists !........");
					}
					System.out.println("Press any Key to Contnue");
					sc.next().charAt(0);
					break;
				case 8:
					System.out.println("See you Soon.............");
					break;
			}
		}while(ch!=8);
	}
}