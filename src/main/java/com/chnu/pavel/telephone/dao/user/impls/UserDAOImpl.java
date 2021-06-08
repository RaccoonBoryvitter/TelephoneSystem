package com.chnu.pavel.telephone.dao.user.impls;

import com.chnu.pavel.telephone.dao.user.interfaces.UserDAO;
import com.chnu.pavel.telephone.model.User;
import com.chnu.pavel.telephone.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.UserDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 07.06.2021|22:01
 * @Version UserDAOImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {

    private UserRepository repository;

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User create(User entityObj) {
        return repository.insert(entityObj);
    }

    @Override
    public User updateById(Long id, User entityObj) {
        User upToDate = findById(id);
        upToDate.setUsername(entityObj.getUsername());
        upToDate.setEmail(entityObj.getEmail());
        upToDate.setEnabled(true);
        upToDate.setRole(entityObj.getRole());
        upToDate.setModifiedAt(entityObj.getModifiedAt());
        return repository.save(upToDate);
    }

    @Override
    public User deleteById(Long id) {
        User deleted = findById(id);
        repository.deleteById(id);
        if(!repository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
