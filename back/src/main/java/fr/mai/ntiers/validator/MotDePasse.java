package fr.mai.ntiers.validator;

import org.springframework.core.annotation.AliasFor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(value = RUNTIME)
@Target(value = {FIELD})
@NotBlank
@Size(min = 8, max = 128)
@Pattern(regexp = "^(?=.*[A-Z])(?=.*[\\W])(?=.*[0-9])(?=.*[a-z]).{8,128}$")
public @interface MotDePasse {

  @AliasFor(annotation = NotBlank.class, attribute = "message")
  String messageNotBlank() default "";

  @AliasFor(annotation = Size.class, attribute = "message")
  String messageSize() default "";

  @AliasFor(annotation = Pattern.class, attribute = "message")
  String messagePattern() default "";
}
