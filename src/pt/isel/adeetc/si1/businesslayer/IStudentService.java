package pt.isel.adeetc.si1.businesslayer;

import java.util.List;

import pt.isel.adeetc.si1.model.Student;

public interface IStudentService extends IService {

	List<Student> GetStudents() throws ServiceException;
}
