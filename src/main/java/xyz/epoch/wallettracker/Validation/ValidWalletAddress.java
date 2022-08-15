package xyz.epoch.wallettracker.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({ElementType.METHOD, ElementType.FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = WalletAddressValidator.class)
@Documented
public @interface ValidWalletAddress {

    String message() default "Invalid Wallet Address";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
