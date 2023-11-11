package org.ari_ramirez_AKEYS.AKEYS.DTO;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    @NotEmpty(message = "Please enter valid email")
    private String email;

    @NotEmpty(message = "Can't leave empty")
    @Size(min = 8, max = 40)
    private String password;

    @NotEmpty(message = "Can't leave empty")
    private String firstName;

    @NotEmpty(message = "Can't leave empty")
    private String lastName;

    @NotEmpty(message = "Can't leave empty")
    @Size(min = 8, max = 40)
    private String matchingPassword;





}
