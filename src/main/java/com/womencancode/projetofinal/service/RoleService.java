package com.womencancode.projetofinal.service;

import com.womencancode.projetofinal.exception.EntityNotFoundException;
import com.womencancode.projetofinal.exception.ServiceException;
import com.womencancode.projetofinal.model.Role;
import com.womencancode.projetofinal.repository.RoleRepository;
import com.womencancode.projetofinal.validator.ModelValidator;
import com.womencancode.projetofinal.validator.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private RoleRepository repository;
    private ModelValidator validator;

    public RoleService(@Autowired RoleRepository repository) {
        this.repository = repository;
        this.validator = ValidatorFactory.getValidator(Role.class, repository);
    }

    public Role insertRole(Role role) throws Exception {
        validator.validateInsert(role);
        return repository.insert(role);
    }

    public List<Role> findAll() {
        return repository.findAll();
    }

    public Role findById(String id) throws ServiceException {
        return repository.findById(id).orElseThrow(() -> {
            String message = String.format("Role %s not found.", id);
            return new EntityNotFoundException(message);
        });
    }
}
