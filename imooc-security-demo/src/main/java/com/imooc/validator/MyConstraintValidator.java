package com.imooc.validator;

import com.imooc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * LN
 * 2019/8/28 0028 18:05
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {
    //在这个校验器中可以注入Spring的任何对象来实现校验逻辑
    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        helloService.greeting("tom");
        System.out.println(o);
        return false;
    }
}
