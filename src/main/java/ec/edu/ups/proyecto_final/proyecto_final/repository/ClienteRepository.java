package ec.edu.ups.proyecto_final.proyecto_final.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.proyecto_final.proyecto_final.models.cliente;

@Repository
public interface ClienteRepository extends MongoRepository<cliente, String> {
    // Puedes agregar consultas personalizadas aquí si es necesario
    cliente findByCedula(String cedula);
}