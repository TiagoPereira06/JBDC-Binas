package pt.isel.adeetc.si1.app.console.presentationlayer;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import pt.isel.adeetc.si1.app.console.Configuration;
import pt.isel.adeetc.si1.businesslayer.IStudentService;
import pt.isel.adeetc.si1.businesslayer.ServiceException;
import pt.isel.adeetc.si1.businesslayer.StudentService;
import pt.isel.adeetc.si1.model.Passe_Utilizador;
import pt.isel.adeetc.si1.model.Pessoa;


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
	public void AddUtilizador(Scanner input, Console console) throws ServiceException, ParseException {
		if (!Utilities.YesOrNoQuestion(input, "\nA Pessoa já está no sistema?"))
			AddPessoa(input, console);

		System.out.println("\n Inserir um novo Utilizador");
		System.out.println("Insira os seguintes valores:");

		int id, saldo;
		String email, ref, data_registo, data_aquisi;
		Date dt_reg, dt_aqui;

		id = Utilities.GetInt(input, "ID_Passe?", "Insira um ID válido!");
		email = Utilities.GetString(input, "Email?");
		data_registo = Utilities.GetString(input, "Data Registo(yyyyMMdd)");
		ref = Utilities.GetString(input, "Referência");
		saldo = Utilities.GetInt(input, "Saldo","Insira valores válidos!");
		data_aquisi = Utilities.GetString(input, "Data Aquisição(yyyyMMdd)");

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		java.util.Date parsed = format.parse(data_registo);
		dt_reg = new Date(parsed.getTime());

		parsed = format.parse(data_aquisi);
		dt_aqui = new Date(parsed.getTime());

		studentService.insertUtilizador(id,email,dt_reg,ref,saldo,dt_aqui);
		System.out.println("");
	}


	private void AddPessoa(Scanner input, Console console) {
		System.out.println("\nAdicionando uma nova Pessoa!");
		//TODO
	}

	public void ListarUtilizadores(Scanner input, Console console) throws ServiceException {

		System.out.println("\nListar Utilizadores!");
		List<Passe_Utilizador> curses = studentService.GetPasses();
		Iterator<Passe_Utilizador> it = curses.iterator();

		if (!it.hasNext()) {
			System.out.println("Sem Pessoas!");
		} else {
			Utilities.PrintTableHeaderForPasses();
			while (it.hasNext()) {
				Utilities.PrintPasses(it.next());
			}
		}
	}

	public void deleteUtilizador(Scanner input, Console console) throws ServiceException{
		System.out.println("\nIndique o ID do Utilizador a eliminar!");
		int id = Utilities.GetInt(input,"ID?","Insira valores válidos!");
		studentService.deleteUtilizador(id);
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
