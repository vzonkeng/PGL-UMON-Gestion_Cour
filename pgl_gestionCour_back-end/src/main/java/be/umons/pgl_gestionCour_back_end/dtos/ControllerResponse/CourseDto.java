package be.umons.pgl_gestionCour_back_end.dtos.ControllerResponse;

import be.umons.pgl_gestionCour_back_end.models.Courses;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private String title;
    private Courses courses;
}
