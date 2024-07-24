package be.umons.pgl_gestionCour_back_end.mapper;

import be.umons.pgl_gestionCour_back_end.dtos.ControllerResponse.CourseDto;
import be.umons.pgl_gestionCour_back_end.models.Courses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseMapper {

    public Courses convertCourseDtoToCourse(CourseDto courseDto){
        return Courses.builder()
                .title(courseDto.getTitle())
                .build();
    }
}
