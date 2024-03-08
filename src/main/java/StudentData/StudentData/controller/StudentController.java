package StudentData.StudentData.controller;

import StudentData.StudentData.model.Student;
import StudentData.StudentData.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/std/{id}")
    public Student getStudent(@PathVariable Integer id){
        return this.studentService.getStudent(id);
    }

    @GetMapping("/all-std")
    public List<Student> getAllStudent(){
        return this.studentService.getAllStudents();
    }

    @PostMapping("/add")
    public String addNewStudent(@RequestBody Student studentData){
        return this.studentService.addStudent(studentData);
    }

    @PutMapping("/update/{studentId}")
    public String updateStudent(@PathVariable Integer studentId, Student newData){
        return this.studentService.updateStudent(studentId, newData);
    }

    @DeleteMapping("/delete/{studentId}")
    public void delete(@PathVariable  Integer studentId){
        this.studentService.deleteStudent(studentId);
    }
}
