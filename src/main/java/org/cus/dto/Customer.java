package org.cus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentId;
    private String roleId;
}
