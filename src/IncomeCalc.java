import java.util.Scanner;
import org.apache.poi.ss.formula.functions.*;

//Lab 1 done by Shaun Frketich, Jared Glaser, and Serafin Escobar.

public class IncomeCalc {
	
	//Main method handles prompting user and method calls to calculate the PV and PMT values.
	public static void main(String[] args) {
		
		//User Prompting and Storage of needed values.
		
		Scanner scanner =new Scanner(System.in);
		System.out.println("How many years do you plan to work?");
		int yearsToWork = scanner.nextInt();
		
		System.out.println("What is your expected Annual Return while employed? (In decimal format)");
		double annReturnEmp = scanner.nextDouble();
		
		System.out.println("How many years do you expect to be retired?");
		int yearsRetired = scanner.nextInt();
	
		System.out.println("What is your expected Annual Return while retired? (in decimal format)");
		double annReturnRet = scanner.nextDouble();
		
		System.out.println("What is your Required Income while retired?");
		int reqIncome = scanner.nextInt();
		
		System.out.println("What is your expected Monthly SSI?");
		int monthlySSI = scanner.nextInt();
		
		//Calculations for the PV and PMT values.
		
		double x = Math.round(calculatePV(annReturnRet/12,yearsRetired*12,-(reqIncome-monthlySSI), 0, false )*100)/100.0d;
		double y = Math.round(calculatePMT(annReturnEmp/12,yearsToWork*12,0,-x, false)*100)/100.0d;
		
		//Formatting and printing to the console for the user to see.
		
		System.out.println("You will need $" + x + " saved in order to retire.");
		System.out.println("This will require you to put away $" + y + " per month.");
	
	}
	
	//Call to the FinanceLib PMT function
	public static double calculatePMT(double r, double n, double p, double f, boolean t)
	{
		return FinanceLib.pmt(r, n, p, f, t);
	}

	//Call to the FinanceLib PV function
	public static double calculatePV(double r, double n, double y, double f, boolean t)
	{
		return FinanceLib.pv(r, n, y, f, t);
	}
}
