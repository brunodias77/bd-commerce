package com.brunodias.bdc.infrastructure.repositories;

import com.brunodias.bdc.domain.entities.User;
import com.brunodias.bdc.domain.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query(nativeQuery = true, value = """
				SELECT users.email AS username, users.password, roles.id AS roleId, roles.authority
			 				FROM users
			 				INNER JOIN user_role ON users.id = user_role.user_id
			 				INNER JOIN roles ON roles.id = user_role.role_id
			 				WHERE users.email = :email
			""")
    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);

    Optional<User> findByEmail(String email);
}
