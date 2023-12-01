package vn.edu.iuh.fit.week04.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Candidate {
    private UUID id;
    private LocalDateTime dob;
    private String email;
    private String fullName;
    private String phone;
    private Address address;

    public Candidate(UUID id) {
        this.id = id;
    }
}
