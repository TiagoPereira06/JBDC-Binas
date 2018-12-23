package pt.isel.adeetc.si1.app.console.presentationlayer;

import java.lang.reflect.*;
import java.util.*;


public class Menu {
	public class MenuItem
	{
		public String description;
		public Method method;

		public MenuItem(String description, Method method)
		{
			this.description = description;
			this.method = method;
		}
	}
	
	public ArrayList<MenuItem> menuItems = null;
	
	@SuppressWarnings("rawtypes")
	public Menu() throws NoSuchMethodException 
	{
		menuItems = new ArrayList<MenuItem>();
		Class params[] = {Scanner.class, Console.class};
	
		/*Items do menu*/
		menuItems.add(new MenuItem("Quit", Actions.class.getDeclaredMethod("Quit", params)));
		menuItems.add(new MenuItem("About", Actions.class.getDeclaredMethod("About", params)));
		menuItems.add(new MenuItem("Adicionar um novo Utilizador",  Actions.class.getDeclaredMethod("AddUtilizador", params)));
		//menuItems.add(new MenuItem("Listar Utilizadores",  Actions.class.getDeclaredMethod("ListarUtilizadores", params)));
		//menuItems.add(new MenuItem("Eliminar Utilizador",  Actions.class.getDeclaredMethod("deleteUtilizador", params)));
		//menuItems.add(new MenuItem("Listar Pessoas",  Actions.class.getDeclaredMethod("ListarPessoas", params)));
		menuItems.add(new MenuItem("Eliminar Funcionário",  Actions.class.getDeclaredMethod("deleteFunc", params)));

		//TODO
		// Insert more menu items to the menu. They must be implemented at CustomActions.java
		//menuItems.add(new MenuItem("Option number 3", Actions.class.getDeclaredMethod("OptionNumber3", params)));

	}
}
