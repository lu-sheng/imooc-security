package com.imooc.validator;


import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * LN
 * 2019/8/28 0028 18:01
 */
//可以标注在哪里,这里指定的是方法上和字段上
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = )
public @interface MyConstraint {

}
