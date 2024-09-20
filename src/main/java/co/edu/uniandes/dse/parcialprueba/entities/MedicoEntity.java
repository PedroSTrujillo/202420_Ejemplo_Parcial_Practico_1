package co.edu.uniandes.dse.parcialprueba.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class MedicoEntity extends BaseEntity {
    private String nombre;
    private String apellido;
    private String registroMedico;

    @ManyToMany
    private List<EspecialidadEntity> especialidades = new ArrayList<>();

}
