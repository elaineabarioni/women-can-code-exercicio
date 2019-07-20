package com.womencancode.projetofinal.validator;

import com.womencancode.projetofinal.exception.DuplicatedKeyException;
import com.womencancode.projetofinal.exception.ServiceException;
import com.womencancode.projetofinal.model.User;
import com.womencancode.projetofinal.repository.UserRepository;

public class UserValidator extends ModelValidator<User> {

    public UserValidator(UserRepository repository) {
        super(repository);
    }

    @Override
    public void customInsertValidation(User model) throws ServiceException {
        UserRepository repository = (UserRepository) getRepository();
        if (repository.findByUserName(model.getUserName()).isPresent())
            throw new DuplicatedKeyException(String.format("Username %s already exist", model.getUserName()));
    }
}
