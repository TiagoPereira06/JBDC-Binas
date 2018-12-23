package pt.isel.adeetc.si1.app.console.presentationlayer;

import java.lang.reflect.*;
import java.util.*;


public class Menu {
    public class MenuItem {
        public String description;
        public Method method;

        public MenuItem(String description, Method method) {
            this.description = description;
            this.method = method;
        }
    }

    public ArrayList<MenuItem> menuItems = null;

    @SuppressWarnings("rawtypes")
    public Menu() throws NoSuchMethodException {
        menuItems = new ArrayList<MenuItem>();
        Class params[] = {Scanner.class, Console.class};

        /*Items do menu*/
        menuItems.add(new MenuItem("Quit", Actions.class.getDeclaredMethod("Quit", params)));
        menuItems.add(new MenuItem("About", Actions.class.getDeclaredMethod("About", params)));
        menuItems.add(new MenuItem("Adicionar um novo Utilizador", Actions.class.getDeclaredMethod("insertUtilizador", params)));
        menuItems.add(new MenuItem("Eliminar Funcionário", Actions.class.getDeclaredMethod("deleteFunc", params)));
        menuItems.add(new MenuItem("Viagens por Utilizador", Actions.class.getDeclaredMethod("viagUtil", params)));
        menuItems.add(new MenuItem("Criar Viagem", Actions.class.getDeclaredMethod("viag", params)));
        menuItems.add(new MenuItem("Terminar Viagem", Actions.class.getDeclaredMethod("viagTerm", params)));

        // Insert more menu items to the menu. They must be implemented at CustomActions.java

    }
}
