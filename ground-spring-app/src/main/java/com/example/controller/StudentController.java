package com.example.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.database.ExportsIPBean;
import com.database.ExportsOPBean;
import com.database.business.service.ExportService;
import com.database.core.GDException;
import com.example.model.Course;
import com.example.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
    @Autowired
	private ExportService exportsJDBC_BS;

	@GetMapping("/students/{studentId}/courses")
	public List<Course> retrieveCoursesForStudent(@PathVariable String studentId) {
		return studentService.retrieveCourses(studentId);
	}

	@PostMapping("/students/{studentId}/courses")
	public ResponseEntity<Void> registerStudentForCourse(@PathVariable String studentId, @RequestBody Course newCourse) throws GDException {
	
		Course course = studentService.addCourse(studentId, newCourse);

		if (course == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(course.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/students/{studentId}/courses/{courseId}")
	public Course retrieveDetailsForCourse(@PathVariable String studentId, @PathVariable String courseId) {
		return studentService.retrieveCourse(studentId, courseId);
	}
	
	
	@PostMapping(path="/putExample/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course>  putRequest(@PathVariable String id, @RequestBody Course newCourse) throws GDException {
		return ResponseEntity.status(HttpStatus.OK).body(newCourse);
	}

	
	
	@GetMapping(path="/hello1", produces = MediaType.APPLICATION_JSON_VALUE)
	public ExportsOPBean retrieveCoursesForStudent() throws GDException {
		System.out.println("Hellooooooooooooo");
		ExportsIPBean bean = new ExportsIPBean();
		bean.setExportReqtId("1");
		System.out.println("KKKKK="+exportsJDBC_BS);
		ExportsOPBean res =exportsJDBC_BS.getLoginList(bean);
		return res;
	}

	@GetMapping(path="/hello2", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getPassword() throws GDException {
		ExportsIPBean bean1 = new ExportsIPBean();
		String name =exportsJDBC_BS.getUserPassword(bean1);
		return name;
	}

	
	
	


}
