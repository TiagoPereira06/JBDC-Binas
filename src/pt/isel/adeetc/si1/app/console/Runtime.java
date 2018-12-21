package pt.isel.adeetc.si1.app.console;

import pt.isel.adeetc.si1.app.console.presentationlayer.Console;

public class Runtime {

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		if(!Configuration.getInstance().ConfigurationLoadSucess)
		{
			System.out.println("Unable to load configuration.");
			System.out.println("Unable to proceed!. Pleaase check the following error:");
			System.out.println(Configuration.getInstance().ConfigurationLoadDescription);
			return;
		} 
		
		try {
			(new Console()).run();
		} catch (Exception e) {
			System.out.println("Sorry something silly happend!!!");
			System.out.println("Cause: " + e.getMessage());
			System.out.println("Program aborted.");
			e.printStackTrace();
		}
	}
}
