package pt.isel.adeetc.si1.app.console.presentationlayer;

import java.util.Scanner;

import pt.isel.adeetc.si1.model.Passe_Utilizador;
import pt.isel.adeetc.si1.model.Pessoa;
import pt.isel.adeetc.si1.model.Student;


public class Utilities {
	public static int GetInt(Scanner input, String caption, String onErrorCaption)
	{
		int result;
		do {
			System.out.print(caption);
			if (input.hasNextInt()) 
			{
				result = input.nextInt();
				input.nextLine();
				
				return result;
			}
			else 
			{
				input.nextLine();
				System.out.println(onErrorCaption);
				System.out.println();
			}
		}
		while(true);
	}
	
	public static  String GetString(Scanner input, String caption)
	{
		System.out.print(caption);
		return input.nextLine();
	}
	
	public static  boolean AreYouSure(Scanner input)
	{
		return YesOrNoQuestion(input, "Are you sure");
	}
	
	public static  boolean YesOrNoQuestion(Scanner input, String questionCaption)
	{
		String question = null;
		while(true)
		{
			question = GetString(input, questionCaption + "[(Y)es/(N)o]:");
			if(question.toUpperCase().equals("Y"))
			{
				return true;
			} 
			else if (question.toUpperCase().equals("N"))
			{
				return false;
			}
		}
	}

	/*
	 * 0 no
	 * 1 yes
	 * -1 quit 
	 * */
	public static  int YesOrNoQuitQuestion(Scanner input, String questionCaption)
	{
		String question = null;
		while(true)
		{
			question = GetString(input, questionCaption + "[(Y)es/(N)o/(Q)uit]:");
			
			if(question.toUpperCase().equals("Y"))
			{
				return 1;
			}
			else if (question.toUpperCase().equals("N"))
			{
				return 0;
			}
			else if (question.toUpperCase().equals("Q"))
			{
				return -1;
			}
		}
	}
	
	
	/* Pessoa*/
	public static void PrintTableHeaderForPessoas()
	{
		//System.out.printf("%-5s%-15s%-20s%-15s%-15s\n","BI", "Name", "Address", "BirthDate", "NIF");
		System.out.printf("%-40s%-20s%-15s\n","Email", "Name", "NIF");
		System.out.println("******************************************************************");
	}
	
	public static void PrintPessoa(Pessoa pessoa)
	{
		//String name = student.Name.length()>15?student.Name.substring(0, 14):student.Name;
		//String address = student.Address.length()>20?student.Address.substring(0, 19):student.Address;
		//System.out.printf("%-5d%-15s%-20s%-15s%-15d\n",student.BI, name, address, student.BirthDate.toString(), student.NIF );
		System.out.printf("%-40s%-20s%-15d\n",pessoa.getEmail(), pessoa.getName(), pessoa.getNif());
	}

    public static void PrintTableHeaderForPasses() {
		System.out.printf("%-5s%-30s%-20s%-10s%-8s%-20s\n","ID", "Email", "Data_Registo", "Referência","Saldo", "Data_Aquisição");
		System.out.println("**********************************************************************************");
    }

	public static void PrintPasses(Passe_Utilizador passe) {
		System.out.printf("%-5d%-30s%-20s%-10s%-8d%-20s\n",passe.getId(),passe.getEmail(),passe.getDt_reg(),passe.getRef(),passe.getSaldo(),passe.getDt_aqui());
	}
}
