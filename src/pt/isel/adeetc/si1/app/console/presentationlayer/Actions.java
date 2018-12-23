package pt.isel.adeetc.si1.app.console.presentationlayer;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import pt.isel.adeetc.si1.app.console.Configuration;
import pt.isel.adeetc.si1.businesslayer.IBusiness;
import pt.isel.adeetc.si1.businesslayer.ServiceException;
import pt.isel.adeetc.si1.businesslayer.Business;
import pt.isel.adeetc.si1.model.Funcionário;
import pt.isel.adeetc.si1.model.Viagem;


public class Actions {

    private IBusiness business;


    public IBusiness getBusiness() {
        return business;
    }

    public void setBusiness(IBusiness business) {
        this.business = business;
    }

    public Actions() {
        /* Creates a new Business but allows for future refactoring to support Dependency Injection */
        business = new Business();
    }

    /*Menu actions menu methods*/

    /*Option 0*/
    public void Quit(Scanner input, Console console) {
        Boolean exit = Utilities.YesOrNoQuestion(input, "Are you sure?");
        if (exit) {
            System.out.println("Thank you for using the program! Bye!");
            console.Terminate();
        }
    }

    /*Option 1*/
    public void About(Scanner input, Console console) {
        pt.isel.adeetc.si1.app.console.Configuration.AboutConfiguration about = Configuration.getInstance().About;

        System.out.println("");
        System.out.println(about.SchoolName);
        System.out.println(about.DepartmentName);
        System.out.println(about.GroupNumber + "# Group number of " + about.Curse);
        System.out.println("");
    }

    /*Option 2*/
    public void AddUtilizador(Scanner input, Console console) throws ServiceException, ParseException {
        String email = null;
        int id, saldo;
        String ref, data_registo, data_aquisi;
        Date dt_reg, dt_aqui;

        if (Utilities.YesOrNoQuestion(input, "\nPretende inserir uma nova Pessoa no sistema?"))
            email = AddPessoa(input, console);

        System.out.println("\n Inserir um novo Utilizador");
        System.out.println("Insira os seguintes valores:");

        id = Utilities.GetInt(input, "ID_Passe?", "Insira um número de ID válido!");
        if (email == null)
            email = Utilities.GetString(input, "Email?");
        data_registo = Utilities.GetString(input, "Data Registo(yyyyMMdd)");
        ref = Utilities.GetString(input, "Referência");
        saldo = Utilities.GetInt(input, "Saldo", "Insira valores inteiros!");
        data_aquisi = Utilities.GetString(input, "Data Aquisição(yyyyMMdd)");

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        java.util.Date parsed = format.parse(data_registo);
        dt_reg = new Date(parsed.getTime());

        parsed = format.parse(data_aquisi);
        dt_aqui = new Date(parsed.getTime());

        Utilities.printResult(business.insertUtilizador(id, email, dt_reg, ref, saldo, dt_aqui), "Inserção de Utilizador");
    }


    private String AddPessoa(Scanner input, Console console) throws ServiceException {
        System.out.println("\nCriação de uma nova Pessoa!");
        System.out.println("Insira os seguintes valores:");

        String email, nome;
        int nif;

        email = Utilities.GetString(input, "Email?");
        nome = Utilities.GetString(input, "Nome?");
        nif = Utilities.GetInt(input, "NIF?", "Insira valores inteiros!");

        return business.insertPessoa(email, nome, nif); //retorna o Email da Pessoa criada
    }
    // Insert more action menu items.
    // The methods must have the following signature "public void [METHODNAME](Scanner input) throws BusinessException"

    /*Option 3*/
    public void deleteFunc(Scanner input, Console console) throws ServiceException {
        List<Funcionário> curses = business.getFuncs();
        Iterator<Funcionário> it;
        boolean delete;
        do {
            System.out.println("\nIndique o Número do Funcionário a eliminar!");
            it = curses.iterator();
            if (!it.hasNext()) {
                System.out.println("Sem Funcionários!");
                return;
            } else {
                Utilities.PrintTableHeaderForFuncs();
                while (it.hasNext()) {
                    Utilities.PrintFuncs(it.next());
                }
            }
            delete = business.deleteFunc(Utilities.GetInt(input, "\nNum?", "Insira valores inteiros!"));
            Utilities.printResult(delete, "Eliminação de Funcionário");
        }
        while (!delete);

    }

    /*Option 4 */
    public void viagUtil(Scanner input, Console console) throws ServiceException {
        System.out.println("Conjunto de Viagens em curso de um determinado utilizador!");
        System.out.println("Insira os seguintes valores:");
        String email;
        Timestamp dt_init, dt_fim;

        email = Utilities.GetString(input, "Email do Utilizador?");
        System.out.println("Intervalo de datas:");
        dt_init = Timestamp.valueOf(Utilities.GetString(input, "Data de inicio? (yyyy-mm-dd hh:mm:ss)"));
        dt_fim = Timestamp.valueOf(Utilities.GetString(input, "Data de Fim? (yyyy-mm-dd hh:mm:ss)"));

        List<Viagem> curses = business.getViagsUtil(email, dt_init, dt_fim);
        Iterator<Viagem> it = curses.iterator();

        if (!it.hasNext()) {
            System.out.println("O utilizador " + email + " não tem viagens em curso de " + dt_init + " a " + dt_fim + ".");
        } else {
            Utilities.PrintTableHeaderForViagens();
            while (it.hasNext()) {
                Utilities.PrintViagens(it.next());
            }
        }
    }

    /*Option 5 */
    public void viag(Scanner input, Console console) throws ServiceException {
        System.out.println("Criação de uma Viagem!");
        System.out.println("Insira os seguintes valores:");
        String email;
        Timestamp dt_init, dt_fim;
        int idBic, idEstD, idEstI;

        email = Utilities.GetString(input, "Email?");
        dt_init = Timestamp.valueOf(Utilities.GetString(input, "Data de inicio? (yyyy-mm-dd hh:mm:ss)"));
        dt_fim = Timestamp.valueOf(Utilities.GetString(input, "Data Final? (yyyy-mm-dd hh:mm:ss)")); // Com ou sem Data Final??
        idEstI = Utilities.GetInt(input, "ID Estação Inicio?", "Insira valores válidos");
        idEstD = Utilities.GetInt(input, "ID Estação Destino?", "Insira valores válidos");
        do {
            idBic = Utilities.GetInt(input, "ID Bicicleta?", "Insira valores válidos!");
        }
        while (!business.checkBic(idBic));//Bicicleta válida(sem viagens em curso atualmente) ou inexistente no sistema
        Utilities.printResult(business.insertViagem(email, dt_init, dt_fim, idEstI, idEstD, idBic), "Inserção de Viagem");
    }

    /*Option 6 */
    public void viagTerm(Scanner input, Console console) throws ServiceException {
        String email, messg = null;
        Timestamp dt_init;
        int avl = 0;

        System.out.println("Viagem a concluir");
        email = Utilities.GetString(input, "Email?");
        dt_init = Timestamp.valueOf(Utilities.GetString(input, "Data Inicial?"));

        System.out.println("Dados a atualizar:");
        if (Utilities.YesOrNoQuestion(input, "Pretende avaliar a Viagem?")) {
            while (avl < 1 || avl > 5)
                avl = Utilities.GetInt(input, "Avaliação da Viagem", "Avaliação [1-5]");
            if (Utilities.YesOrNoQuestion(input, "Pretende deixar uma mensagem?"))
                messg = Utilities.GetString(input, "Mensagem:");
        }
        Utilities.printResult(business.updateViagem(email, dt_init, avl, messg), "Atualização de Viagem)");
    }
}
