package co.edu.uniandes.dse.parcialprueba.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.EspecialidadEntity;
import co.edu.uniandes.dse.parcialprueba.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialprueba.repositories.EspecialidadRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.MedicoRespository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicoEspecialidadService {
    @Autowired
    MedicoRespository medicoRespository;

    @Autowired
    EspecialidadRepository especialidadRespository;

    @Transactional
    public EspecialidadEntity addEspecialidad(Long idMedico, Long idEspecialidad) throws EntityNotFoundException{
        log.info("Inicia proceso de agregar especialidad");
        Optional<EspecialidadEntity> especialidadEntity = especialidadRespository.findById(idEspecialidad);
        if (especialidadEntity.isEmpty()){
            throw new EntityNotFoundException("No hay una especialidad con dicho ID");
        }
        Optional<MedicoEntity> medicoEntity = medicoRespository.findById(idMedico);
        if (medicoEntity.isEmpty()){
            throw new EntityNotFoundException("No hay una médico con dicho ID");
        }
        medicoEntity.get().getEspecialidades().add(especialidadEntity.get());
        log.info("Termina proceso de agregar especialidad");
        return especialidadEntity.get();
    }


}
