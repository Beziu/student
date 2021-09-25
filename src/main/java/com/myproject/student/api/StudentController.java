package com.myproject.student.api;

import com.myproject.student.model.Student;
import com.myproject.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * GET
     * http://localhost:8080/api/v1/student
     */
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    /**
     * POST
     * http://localhost:8080/api/v1/student
     * {
     *     "name": "Grzegorz Dziubak",
     *     "email":"grzegorz@gmail.com"
     * }
     */
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    /**
     * DELETE
     * http://localhost:8080/api/v1/student/1
     */
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    /**
     * PUT
     * http://localhost:8080/api/v1/student/1?name=Maria&email=maria@gmail.com
     */
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}
