package StudentData.StudentData.service;

import StudentData.StudentData.model.Student;
import StudentData.StudentData.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudents(){
        return this.studentRepo.findAll();
    }

    public String addStudent(Student newStudent){
        if (studentRepo.existsByName(newStudent.getName())){
            return "Already Exists";
        }else {
            this.studentRepo.save(newStudent);
            return "Saved";
        }
    }

    public String updateStudent(Integer id, Student updatedStudent){
        Student oldStudent = this.studentRepo.findById(id).get();
        oldStudent.setAge(updatedStudent.getAge());
        oldStudent.setName(updatedStudent.getName());

        this.studentRepo.save(oldStudent);
        return "Student is Updated";
    }

    public void deleteStudent(Integer studentId){
        if(this.studentRepo.findById(studentId).isPresent()){
            this.studentRepo.deleteById(studentId);
        }
    }
    public Student getStudent(Integer id){
        Student selStudent = null;
        if(this.studentRepo.findById(id).isPresent()){
            selStudent = this.studentRepo.findById(id).get();
        }
        return selStudent;
    }
}
