package pt.isel.adeetc.si1;

public class Main {

    static private final String connectionURL = "jdbc:sqlserver://localhost;databaseName=si1;"; //TODO: ALTERAR

    public static void main(String[] args) throws ClassNotFoundException {

        loadDriver();

        /*
        ...
        ...
        ...

        TODO: CONNECTION, USER_ITEMS,..

        CLASSES A OBSERVAR DE EXEMPLOS DO STOR: ProductDAO, Product,..
        USAR PREPARED STATEMENTS E INCIAR OS RECURSOS NO BLOCO TRY DE FORMA A QUE OS MESMOS SEJAM FECHADOS APÓS SUA UTILIZAÇÃO

         */
    }



    public static void loadDriver() throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }

    /*
    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(connectionURL, "sa1","sa1");
        con.setAutoCommit(false);
        return con;
    }
    */

}