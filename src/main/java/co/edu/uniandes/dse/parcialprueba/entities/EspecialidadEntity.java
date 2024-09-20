package co.edu.uniandes.dse.parcialprueba.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity

public class EspecialidadEntity extends BaseEntity {
    private String nombre;
    private String descripcion;

    @ManyToMany
    private List<MedicoEntity> especialidades = new ArrayList<>();
}
