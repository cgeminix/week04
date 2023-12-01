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
public class Address {
    private UUID id;
    private String city;
    private Short country;
    private String number;
    private String street;
    private String zipcode;

    public Address(UUID id) {
        this.id = id;
    }
}
