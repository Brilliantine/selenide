package mobile.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddUserData {

    private String userFirstName;
    private String userLastName;
    private String patronymic;
    private String userPassword;
    private String userPasswordConfirmation;
    private String login;
    private String phone;
    private String email;
    private String snils;
    private String passport;
}
