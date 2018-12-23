package pt.isel.adeetc.si1.datalayer;

import pt.isel.adeetc.si1.datalayer.common.BaseDAO;
import pt.isel.adeetc.si1.datalayer.common.DatabaseException;
import pt.isel.adeetc.si1.model.Funcionário;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncDAO extends BaseDAO implements IFuncDAO {

    @Override
    public List<Funcionário> getFuncs() throws DatabaseException {
        Connection conn = null;
        try {
            String statementQuery = "select Num, Email from Funcionário";
            Funcionário item;
            ArrayList<Funcionário> container = new ArrayList<Funcionário>();

            conn = getConnectionFactory().getConnection();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(statementQuery);
            while (rs.next()) {
                item = new Funcionário();
                item.setNum(rs.getInt(1));
                item.setEmail(rs.getString(2));
                container.add(item);
            }
            stmt.close();
            rs.close();
            return container;
        } catch (Exception exception) {
            throw new DatabaseException(
                    "Unable to list Funcionários. \nCause: "
                            + exception.getMessage(), exception);
        } finally {
            closeConnection(conn);
        }
    }

    @Override
    public boolean deleteFunc(int num) throws DatabaseException {
        String comandSql = "DELETE FROM Funcionário WHERE Num = ?";
        Connection conn = null;
        int rows;
        try {
            conn = getConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(comandSql);
            stmt.setInt(1, num);
            rows = stmt.executeUpdate();// rows = 0 quando delete não afetar nenhuma linha da tabela
            conn.commit();
            stmt.close();
        } catch (Exception e) {
            throw new DatabaseException(
                    "Unable to delete Funcionário. \nCause: "
                            + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
        return rows != 0;
    }
}
