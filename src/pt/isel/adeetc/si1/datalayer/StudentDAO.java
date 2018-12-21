package pt.isel.adeetc.si1.datalayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pt.isel.adeetc.si1.datalayer.common.DatabaseException;
import pt.isel.adeetc.si1.datalayer.common.BaseDAO;
import pt.isel.adeetc.si1.model.Student;

public class StudentDAO extends BaseDAO implements IStudentDAO {

	@Override
	public List<Student> GetStudents() throws DatabaseException {
		Connection conn = null;

		try {
			//String statementQuery = "select BIAluno, NomeAluno, MoradaAluno, DataNascimento, NIFAluno from Aluno";
			String statementQuery = "select Email, Nome, NIF from Pessoa";
			Student item;
			ArrayList<Student> container = new ArrayList<Student>();

			conn = getConnectionFactory().getConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(statementQuery);

			while (rs.next()) {
				item = new Student();
				//item.BI = rs.getInt(1);
				item.Email = rs.getString(1);
				item.Name = rs.getString(2);
				//item.Address = rs.getString(3);
				//item.BirthDate = rs.getDate(4);
				item.NIF = rs.getInt(3);
				container.add(item);
			}

			return container;
		} catch (Exception exception) {
			throw new DatabaseException(
					"Unable to list the students. \nCause: "
							+ exception.getMessage(), exception);
		} finally {
			closeConnection(conn);
		}
	}
}