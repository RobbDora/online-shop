package ro.msg.learning.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "employee_table")
public class Employee {

    @Id
    @SequenceGenerator(name = "emp_seq", sequenceName = "seq_emp")
    @GeneratedValue(generator = "emp_seq")
    @JsonProperty("EmployeeId")
    private Long employeeId;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("Photo")
    private String photo;

    @JsonProperty("HomePhone")
    private String homePhone;

    @JsonProperty("Title")
    private String title;

}
