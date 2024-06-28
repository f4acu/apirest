package com.uch.apirest.controlador;

import com.uch.apirest.modelo.Direccion;
import com.uch.apirest.modelo.Name;
import com.uch.apirest.modelo.Phone;
import com.uch.apirest.repositorio.NameRepository;
import com.uch.apirest.repositorio.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NameController {

    @Autowired
    private NameRepository nameRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @GetMapping("/names")
    public List<Name> getName() {
        return nameRepository.findAll();
    }

    @PostMapping("/names")
    public Name createName(@RequestBody Name name) {
        Direccion direccion = name.getDireccion();
        direccion.setName(name);

        for (Phone phone : name.getPhones()) {
            phone.setName(name);
        }
        return nameRepository.save(name);
    }

    @PutMapping("/names/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Name updateName(@PathVariable("id") Long id, @RequestBody Name nameDetails) {
        Optional<Name> optionalName = nameRepository.findById(id);

        if (optionalName.isPresent()) {
            Name existingName = optionalName.get();
            existingName.setNombre(nameDetails.getNombre());
            existingName.setEdad(nameDetails.getEdad());

            Direccion existingDireccion = existingName.getDireccion();
            Direccion newDireccion = nameDetails.getDireccion();

            existingDireccion.setCalle(newDireccion.getCalle());
            existingDireccion.setNumero(newDireccion.getNumero());
            existingDireccion.setCiudad(newDireccion.getCiudad());

            existingDireccion.setName(existingName);

            existingName.getPhones().clear();
            for (Phone phone : nameDetails.getPhones()) {
                phone.setName(existingName);
                existingName.addPhones(phone);
            }

            return nameRepository.save(existingName);
        } else {
            throw new RuntimeException("Name no encontrado con id " + id);
        }
    }
    @DeleteMapping("/names/{id}")
    public void deleteName(@PathVariable Long id) {
        Optional<Name> optionalName = nameRepository.findById(id);

        if (optionalName.isPresent()) {
            nameRepository.delete(optionalName.get());
        } else {
            throw new RuntimeException("Name no encontrado con id " + id);
        }
    }
}