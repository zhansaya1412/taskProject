package kz.bitlab.techorda2025.thirdProject.db;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
    private Long id;
    private String email;
    private String fullName;
    private String password;
}
