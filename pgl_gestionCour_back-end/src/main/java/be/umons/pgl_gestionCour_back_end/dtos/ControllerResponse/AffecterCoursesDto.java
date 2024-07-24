package be.umons.pgl_gestionCour_back_end.dtos.ControllerResponse;

import be.umons.pgl_gestionCour_back_end.models.Courses;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AffecterCoursesDto {

    private String login;
    private String FirstName;
    private String LastName;
    private String address;
    private String role;
    private LocalDateTime inscriptionDate;
    private String password;
    private LocalDateTime affectationDate;
    private int person_id;
    private int course_id;
}
