package kr.co.springFramePractice.cli.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Person person = new Person("", 200);
        PersonValidation validation = new PersonValidation();
        if (validation.supports(person.getClass())) {
            BindException error = new BindException(person, "person");
            validation.validate(person, error);

            System.out.println(error.hasErrors());
            log.error(">>>>>>>> 에러1 : " + error.hasErrors());
            log.error(">>>>>>>> 에러2 : " + error.getAllErrors());

        } else {
            log.error("invalid Class");
        }
    }
}
