package cn.learn.spring.batch.processor.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.ValidatorFactory;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

public class PersonValidator<T> implements Validator<T>, InitializingBean{

    private static final Logger log = LoggerFactory.getLogger(PersonValidator.class);

//    private javax.validation.Validator validator;

    /** * 使用 JSR-303 的 Validator来校验我们的数据，在此处进行JSR-303的Validator的初始化 */
    @Override
    public void afterPropertiesSet() throws Exception {
//        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//        validator = validatorFactory.usingContext().getValidator();
    }

    @Override
    public void validate(T value) throws ValidationException {
    	log.info("validate..." + value.toString());
    	
//        // 使用Validator的validate方法校验数据
//        Set<ConstraintViolation<T>> constraintViolations = validator.validate(value);
//        if (constraintViolations.size() > 0){
//            StringBuilder message = new StringBuilder();
//            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
//                message.append(constraintViolation.getMessage() + "\n");
//            }
//            throw new ValidationException(message.toString());
//        }
    }
}