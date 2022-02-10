package fr.mai.ntiers.validator;

import org.springframework.core.annotation.AliasFor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(value = RUNTIME)
@Target(value = {FIELD})
@NotBlank
@Pattern(regexp = "^e\\d{8}$")
public @interface Identifiant {

  @AliasFor(annotation = Pattern.class, attribute = "message")
  String messagePattern() default "";

  @AliasFor(annotation = NotBlank.class, attribute = "message")
  String messageBlank() default "";
}
