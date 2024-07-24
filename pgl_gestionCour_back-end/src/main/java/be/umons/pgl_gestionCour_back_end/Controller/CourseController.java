package be.umons.pgl_gestionCour_back_end.Controller;

import be.umons.pgl_gestionCour_back_end.dtos.ControllerResponse.CourseDto;
import be.umons.pgl_gestionCour_back_end.dtos.ControllerResponse.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("PGL/")
public interface CourseController {

    @GetMapping("get/allCourses")
    ResponseEntity<ResponseDto> getAllCourses();
    @PostMapping("create/course")
    ResponseEntity<ResponseDto> createCourse(@RequestBody CourseDto courseDto);
    @GetMapping("get/course/{id}")
    ResponseEntity<ResponseDto> getCourseById(@PathVariable int id);
    @PutMapping("update/course/{id}")
    ResponseEntity<ResponseDto> updateCourse(@PathVariable int id, @RequestBody CourseDto courseDetail);
    @DeleteMapping("course/delete")
    ResponseEntity<ResponseDto> deleteCourse(@PathVariable int id);

}
