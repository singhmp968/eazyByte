package eazySchool.eazySchool.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Contact {
    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Name must be at least 2 characters long")
    private String name;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number must be 10 digits")
    private String mobileNum;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide email address")
    private String email;

    @NotBlank(message = "Subject is required")
    @Size(min = 3, message = "Subject must be at least 2 characters long")
    private String subject;

    @NotBlank(message = "Message is required")
    @Size(min = 3, message = "Message must be at least 2 characters long")
    private String message;

}
