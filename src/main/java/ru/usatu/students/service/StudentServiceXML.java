package ru.usatu.students.service;

import org.springframework.stereotype.Service;
import ru.usatu.students.model.Student;
import ru.usatu.students.model.StudentList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class StudentServiceXML implements StudentService{

    String path = new File("").getAbsolutePath();
    private final String FILE_PATH = path + "\\src\\main\\resources\\students.xml";

    @Override
    public List<Student> getStudents() throws Exception {
        return getStudentList().getStudents();
    }

    @Override
    public Student getStudent (int id) throws Exception {
        return getStudents().stream().filter(student -> student.getId() == id)
                .findFirst().orElse(new Student());
    }

    @Override
    public Student addStudent(Student student) throws Exception {
        StudentList studentList = getStudentList();
        studentList.getStudents().add(student);
        save(studentList);
        return student;
    }

    @Override
    public void deleteStudent(int id) throws Exception {
        StudentList studentList = getStudentList();
        Student findStudent = studentList.getStudents().stream().filter(student -> student.getId() == id)
                .findFirst().orElse(null);
        if (findStudent != null) {
            studentList.getStudents().remove(findStudent);
            save(studentList);
        }
    }

    @Override
    public Student editStudent(int id, String surname, String name, String patronymic, String number, String phone) throws Exception {
        StudentList studentList = getStudentList();
        Student findStudent = studentList.getStudents().stream().filter(student -> student.getId() == id)
                .findFirst().orElse(null);
        if (findStudent == null) {
            return new Student();
        }

        findStudent.setSurName(surname);
        findStudent.setName(name);
        findStudent.setPatronymic(patronymic);
        findStudent.setNumber(number);
        findStudent.setPhone(phone);
        save(studentList);

        return findStudent;
    }

    private StudentList getStudentList() throws Exception {
        File file = new File(FILE_PATH);
        JAXBContext context = JAXBContext.newInstance(StudentList.class);
       Unmarshaller unmarshaller = context.createUnmarshaller();
       return (StudentList) unmarshaller.unmarshal(file);
    }

    private void save (StudentList studentList) throws Exception {
        File file = new File(FILE_PATH);
        JAXBContext context = JAXBContext.newInstance(StudentList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(studentList, file);
    }

}
