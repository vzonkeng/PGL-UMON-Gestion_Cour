package be.umons.pgl_gestionCour_back_end.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "affecterCours")
public class AffecterCours {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    @OneToMany
    @JoinColumn(name="course_id") // colonne qui contiendra les clés étrangères pointant vers Person avec comme role enseignant
    private List<Courses> courses; // liste des cours associés a une personne
    private String login;
    private String FirstName;
    private String LastName;
    private String address;
    private String role;
    private LocalDateTime inscriptionDate;
    private String password;
    private LocalDateTime affectationDate;
    private int person_id;

}
