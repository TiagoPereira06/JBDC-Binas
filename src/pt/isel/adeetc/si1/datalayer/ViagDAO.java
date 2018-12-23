package pt.isel.adeetc.si1.datalayer;

import pt.isel.adeetc.si1.datalayer.common.BaseDAO;
import pt.isel.adeetc.si1.datalayer.common.DatabaseException;
import pt.isel.adeetc.si1.model.Viagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViagDAO extends BaseDAO implements IViagDAO {

    @Override
    public List<Viagem> getViagsUtil(String email, Timestamp dt_init, Timestamp dt_fim) throws DatabaseException {
        Connection conn = null;
        try {
            String statementQuery = "select Viagem.Data_Inicial,Viagem.Email, Bicicleta.* " +
                    "from Viagem " +
                    "inner join Bicicleta on (Bicicleta.ID = Viagem.IDBicicleta) " +
                    "where Viagem.Data_Final is null and Email = ? AND Data_Inicial >= ? AND Data_Inicial <= ?";
            Viagem item;
            ArrayList<Viagem> container = new ArrayList<Viagem>();

            conn = getConnectionFactory().getConnection();

            PreparedStatement stmt = conn.prepareStatement(statementQuery);
            stmt.setString(1,email);
            stmt.setTimestamp(2,dt_init);
            stmt.setTimestamp(3,dt_fim);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                item = new Viagem();
                item.setDt_init(rs.getTimestamp(1));
                item.setEmail(rs.getString(2));
                item.setIdBic(rs.getInt(3));
                container.add(item);
            }
            stmt.close();
            rs.close();
            return container;
        } catch (Exception exception) {
            throw new DatabaseException(
                    "Unable to list Viagens. \nCause: "
                            + exception.getMessage(), exception);
        } finally {
            closeConnection(conn);
        }
    }
}
