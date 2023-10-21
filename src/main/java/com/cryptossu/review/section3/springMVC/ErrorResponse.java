package com.cryptossu.review.section3.springMVC;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
//@AllArgsConstructor
public class ErrorResponse {

    private List<FieldError> fieldErrors;
    private List<ConstraintViolationError> violationErrors;

    private ErrorResponse(List<FieldError> fieldErrors, List<ConstraintViolationError> violationErrors) {
        this.fieldErrors = fieldErrors;
        this.violationErrors = violationErrors;
    }

    public static ErrorResponse of(BindingResult bindingResult) {
        return new ErrorResponse(FieldError.of(bindingResult), null);
    }

    public static ErrorResponse of(Set<ConstraintViolation<?>> violations) {
        return new ErrorResponse(null, ConstraintViolationError.of(violations));
    }

    @Getter
    @AllArgsConstructor
    public static class FieldError {
        private String field;
        private String rejectedValue;
        private String reason;

        private FieldError(String field, Object rejectValue, String reason) {
            this.field = field;
            this.rejectedValue = rejectValue.toString();
            this.reason = reason;
        }

        public static List<FieldError> of(BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();

            return fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() == null ?
                                    "" : error.getRejectedValue().toString(),
                            error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
    }

    @Getter
    public static class ConstraintViolationError {
        private String propertyPath;
        private Object rejectValue;
        private String reason;

        private ConstraintViolationError(String propertyPath, Object rejectValue, String reason) {
            this.propertyPath = propertyPath;
            this.rejectValue = rejectValue;
            this.reason = reason;
        }

        public static List<ConstraintViolationError> of(Set<ConstraintViolation<?>> constraintViolations) {
            return constraintViolations.stream()
                    .map(constraintViolation -> new ConstraintViolationError(
                            constraintViolation.getPropertyPath().toString(),
                            constraintViolation.getInvalidValue().toString(),
                            constraintViolation.getMessage()))
                    .collect(Collectors.toList());
        }
    }
}
