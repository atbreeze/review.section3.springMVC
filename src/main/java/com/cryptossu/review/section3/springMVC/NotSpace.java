package com.cryptossu.review.section3.springMVC;

import org.hibernate.validator.internal.constraintvalidators.bv.NotBlankValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
// 애너테이션을 정의할때 인터페이스 키워드를 사용하여 정의하고, 상단에 Target과 Retention은 적용대상과 유지기간을 지정하는 역할을 함
@Constraint(validatedBy = {NotBlankValidator.class})
public @interface NotSpace {
    String message() default "공백이 아니어야 합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
