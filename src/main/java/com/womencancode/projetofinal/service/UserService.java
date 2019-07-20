package com.womencancode.projetofinal.service;

import com.womencancode.projetofinal.exception.EntityNotFoundException;
import com.womencancode.projetofinal.exception.ServiceException;
import com.womencancode.projetofinal.model.User;
import com.womencancode.projetofinal.repository.UserRepository;
import com.womencancode.projetofinal.validator.ModelValidator;
import com.womencancode.projetofinal.validator.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    private ModelValidator validator;

    public UserService(@Autowired UserRepository repository) {
        this.repository = repository;
        this.validator = ValidatorFactory.getValidator(User.class, repository);
    }

    public User insertUser(User user) throws ServiceException {
        validator.validateInsert(user);
        return repository.insert(user);
    }

    public List<User> insertUser(List<User> users) throws ServiceException {
        validator.validateInsert(users);
        return repository.insert(users);
    }

    public User updateUser(User user) throws ServiceException {
        validator.validateId(user.getId());
        return repository.save(user);
    }

    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public User findById(String id) throws ServiceException {
        String message = String.format("User %s not found", id);
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(message));
    }

    public void delete(String id) throws ServiceException {
        validator.validateId(id);
        repository.deleteById(id);
    }
}