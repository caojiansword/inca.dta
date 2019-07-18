package com.inca.utils.excel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface ExcelVOAttribute {
 
    //导出到Excel中的名字.
    public abstract String name();
 
    //配置列的名称,对应A,B,C,D....
    public abstract String column();
 
    //提示信息.
    public abstract String prompt() default "";
 
    //设置只能选择不能输入的列内容
    public abstract String[] combo() default {};
 
    //是否导出数据,应对需求:有时我们需要导出一份模板,这是标题需要但内容需要用户手工填写.
    public abstract boolean isExport() default true;
}