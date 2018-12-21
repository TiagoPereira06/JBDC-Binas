package pt.isel.adeetc.si1.app.console.presentationlayer;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import pt.isel.adeetc.si1.app.console.Configuration;
import pt.isel.adeetc.si1.businesslayer.IStudentService;
import pt.isel.adeetc.si1.businesslayer.ServiceException;
import pt.isel.adeetc.si1.businesslayer.StudentService;
import pt.isel.adeetc.si1.businesslayer.IService;
import pt.isel.adeetc.si1.model.Student;



public class Actions {
	
	private IStudentService studentService;
	
	
	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public Actions()
	{
		/* Creates a new StudentService but allows for future refactoring to support Dependency Injection */
		studentService = new StudentService();
	}
	
	/*Menu actions menu methods*/
	
	/*Option 0*/
	public void Quit(Scanner input, Console console) 
	{
		Boolean exit = Utilities.YesOrNoQuestion(input, "Are you sure?");
		if(exit) 
		{
			System.out.println("Thank you for using the program! Bye!");
			console.Terminate();
		}
	}
	
	/*Option 1*/
	public void About(Scanner input, Console console) 
	{
		pt.isel.adeetc.si1.app.console.Configuration.AboutConfiguration about = Configuration.getInstance().About;
		
		System.out.println("");
		System.out.println(about.SchoolName);
		System.out.println(about.DepartmentName);
		System.out.println(about.GroupNumber + "# Group number of " + about.Curse);
		System.out.println("");
	}

	/*Option 2*/
	public void ListStudents(Scanner input, Console console) throws ServiceException
	{
		System.out.println("\nListing the Students. Bora lá"); //TODO
		
		List<Student> curses = studentService.GetStudents(); //TODO

		Iterator<Student> it = curses.iterator(); //TODO


		if(!it.hasNext())
		{
			System.out.println("No available students!");
		}
		else
		{
			Utilities.PrintTableHeaderForStudents();
			while (it.hasNext()) 
			{
				Utilities.PrintStudent(it.next());
			}
		}
		System.out.println("");
	}
	
	public void XXX(Scanner input, Console console){
	    System.out.println("XXX");
	}
	
	//TODO
	// Insert more action menu items. 
	// The methods must have the following signature "public void [METHODNAME](Scanner input) throws BusinessException"

	/*Option 3*/
	public void OptionNumber3(Scanner input, Console console) throws ServiceException
	{
		System.out.println();
		System.out.println("Not yet implemented!!!");
		System.out.println();
	}
}
