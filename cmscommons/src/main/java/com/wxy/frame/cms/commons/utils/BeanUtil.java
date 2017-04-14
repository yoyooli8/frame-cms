package com.wxy.frame.cms.commons.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * @Description: com.wxy.frame.cms.commons.utils
 * @date 2017/4/14.
 * Created by 石头 on 2017/4/14.
 */
public class BeanUtil {
    public static void copyProperties(Object source, Object target){
        Class actualEditable = target.getClass();
        PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(actualEditable);
        List ignoreList = null;
        for(int len = 0; len < targetPds.length; ++len) {
            PropertyDescriptor targetPd = targetPds[len];
            Method writeMethod = targetPd.getWriteMethod();
            if(writeMethod != null && (ignoreList == null || !ignoreList.contains(targetPd.getName()))) {
                PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());
                if(sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod();
                    if(readMethod != null && ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
                        try {
                            if(!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                                readMethod.setAccessible(true);
                            }

                            Object ex = readMethod.invoke(source, new Object[0]);
                            if(!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }
                            if(ex !=null){
                                if((ex instanceof  String) && !StringUtils.isEmpty(String.valueOf(ex))){
                                    writeMethod.invoke(target, new Object[]{ex});
                                }else if(!(ex instanceof  String)){
                                    writeMethod.invoke(target, new Object[]{ex});
                                }
                            }
                        }catch (Throwable e) {
                            throw new FatalBeanException("Could not copy property \'" + targetPd.getName() + "\' from source to target", e);
                        }
                    }
                }
            }
        }
    }
}
