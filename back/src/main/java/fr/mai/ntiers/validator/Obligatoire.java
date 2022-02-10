package fr.mai.ntiers.validator;

import org.springframework.core.annotation.AliasFor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(value = RUNTIME)
@Target(value = {FIELD})
@NotBlank
@Size
public @interface Obligatoire {

  @AliasFor(annotation = NotBlank.class, attribute = "message")
  String message() default "";

  @AliasFor(annotation = Size.class, attribute = "min")
  int minLength() default 0;

  @AliasFor(annotation = Size.class, attribute = "max")
  int maxLength() default MAX_VALUE;
}
