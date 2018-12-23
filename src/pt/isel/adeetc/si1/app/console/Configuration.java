package pt.isel.adeetc.si1.app.console;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import pt.isel.adeetc.si1.datalayer.common.BaseDAO;
import pt.isel.adeetc.si1.datalayer.common.sqlserver.SQLServerConnectionFactory;

public class Configuration {

    public static final String configurationFileName = "configuration.config";

    public boolean ConfigurationLoadSucess = true;
    public String ConfigurationLoadDescription = "OK";

    public AboutConfiguration About;

    public class AboutConfiguration {
        public AboutConfiguration(Properties properties) {
            SchoolName = properties.getProperty("schoolName");
            DepartmentName = properties.getProperty("departmentName");
            GroupNumber = properties.getProperty("groupNumber");
            Curse = properties.getProperty("curse");
        }

        public String SchoolName;
        public String DepartmentName;
        public String GroupNumber;
        public String Curse;

    }

    public DataBaseConfiguration Database;

    public class DataBaseConfiguration {
        public static final String DatabaseType_Key = "databaseType";
        public static final String DatabaseType_SQLSERVER = "sqlserver";
        public static final String DatabaseType_MYSQL = "mysql";
        public static final String DatabaseType_ORACLE = "oracle";

        public DataBaseConfiguration(Properties properties) {
            Server = properties.getProperty("server");
            Port = properties.getProperty("port");
            InstanceName = properties.getProperty("instanceName");
            Database = properties.getProperty("database");
            Username = properties.getProperty("username");
            Password = properties.getProperty("password");
            IntegratedSecurity = Boolean.parseBoolean(properties
                    .getProperty("integratedSecurity"));
            databaseType = properties.getProperty(DatabaseType_Key);

            /* Setup ConnectionFactory */
            if (DatabaseType_SQLSERVER.equals(databaseType)) {
                BaseDAO.setConnectionFactory(SQLServerConnectionFactory
                        .getInstance());
            }

        }

        public String Server;
        public String Port;
        public String InstanceName;
        public String Database;
        public String Username;
        public String Password;
        public boolean IntegratedSecurity;
        public String databaseType;

    }

    private static Configuration Instance = new Configuration();

    public static Configuration getInstance() {
        return Instance;
    }

    private Configuration() {
        try {

            Properties properties = new Properties();
            InputStream iStream = Configuration.class.getClassLoader().getResourceAsStream("pt/isel/adeetc/si1/app/console/" + configurationFileName);
            properties.loadFromXML(iStream);

            Database = new DataBaseConfiguration(properties);
            About = new AboutConfiguration(properties);

            iStream.close();
        } catch (Exception exception) {
            ConfigurationLoadDescription = exception.getMessage();
            ConfigurationLoadSucess = false;
        }
    }
}
