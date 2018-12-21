package pt.isel.adeetc.si1.datalayer;

import java.util.List;

import pt.isel.adeetc.si1.datalayer.common.DatabaseException;
import pt.isel.adeetc.si1.datalayer.common.BaseDAO;
import pt.isel.adeetc.si1.model.Student;

public interface IStudentDAO {
	List<Student> GetStudents() throws DatabaseException;
}
