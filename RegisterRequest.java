package org.edf.cat.mmesi.Irritant.auth;

import org.edf.cat.mmesi.Irritant.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String nni;
    private Role role;
}
