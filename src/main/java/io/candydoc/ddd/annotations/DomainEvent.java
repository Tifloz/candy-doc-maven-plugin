package io.candydoc.ddd.annotations;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainEvent {
  String description() default "";
}
