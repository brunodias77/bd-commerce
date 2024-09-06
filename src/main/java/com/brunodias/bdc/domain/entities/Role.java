package com.brunodias.bdc.domain.entities;

import org.hibernate.validator.constraints.UUID;
import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    private UUID id;
    private String authority;

    public Role() {
    }

    public Role(UUID id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAuthority'");
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((authority == null) ? 0 : authority.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Role other = (Role) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (authority == null) {
            if (other.authority != null)
                return false;
        } else if (!authority.equals(other.authority))
            return false;
        return true;
    }

}
