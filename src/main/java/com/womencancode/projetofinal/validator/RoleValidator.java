package com.womencancode.projetofinal.validator;

import com.womencancode.projetofinal.exception.ServiceException;
import com.womencancode.projetofinal.model.Role;
import com.womencancode.projetofinal.repository.RoleRepository;

public class RoleValidator extends ModelValidator<Role> {
    public RoleValidator(RoleRepository repository) {
        super(repository);
    }

    @Override
    public void customInsertValidation(Role model) throws ServiceException {
        // Do nothing
    }
}
