package santander.bootcamp.APIRESTSpring.service;

import santander.bootcamp.APIRESTSpring.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}
