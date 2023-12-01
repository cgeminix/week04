package vn.edu.iuh.fit.week04.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Company {
    private UUID id;
    private String about;
    private String email;
    private String companyName;
    private String phone;
    private String webUrl;
    private Address address;
}
