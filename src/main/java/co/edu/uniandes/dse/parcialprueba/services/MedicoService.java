package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.MedicoRespository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicoService {

    @Autowired
    MedicoRespository medicoRespository;

    @Transactional
    public MedicoEntity createMedico(MedicoEntity medicoEntity) throws IllegalOperationException{
        log.info("Inicia creación medico");
        if (!medicoEntity.getRegistroMedico().startsWith("RM")){
            throw new IllegalOperationException("El registro médico tiene que comenzar por RM");
        }
        log.info("Termina creación medico");
        return medicoRespository.save(medicoEntity);
    }
}
