package pt.isel.adeetc.si1.app.console.presentationlayer;

import java.util.Scanner;

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
	
	
	/* Student*/
	public static void PrintTableHeaderForStudents()
	{
		System.out.printf("%-5s%-15s%-20s%-15s%-15s\n","BI", "Name", "Address", "BirthDate", "NIF");
		System.out.println("******************************************************************");
	}
	
	public static void PrintStudent(Student student)
	{
		String name = student.Name.length()>15?student.Name.substring(0, 14):student.Name;
		String address = student.Address.length()>20?student.Address.substring(0, 19):student.Address;
		System.out.printf("%-5d%-15s%-20s%-15s%-15d\n",student.BI, name, address, student.BirthDate.toString(), student.NIF );
	}
}
