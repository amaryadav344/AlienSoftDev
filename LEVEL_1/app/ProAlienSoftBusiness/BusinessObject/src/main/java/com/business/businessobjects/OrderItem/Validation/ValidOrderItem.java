package com.business.businessobjects.OrderItem.Validation;

import java.lang.Class;
import java.lang.String;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
    validatedBy = OrderItemValidator.class
)
public @interface ValidOrderItem {
  String message() default "OrderItem is not allowed";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
