package com.brunodias.bdc.domain.projections;

import java.util.UUID;

public interface UserDetailsProjection {
    String getUsername();

    String getPassword();

    UUID getRoleId();

    String getAuthority();
}
