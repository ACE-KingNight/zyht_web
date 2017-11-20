package com;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com
 * @author wangzhenxin
 * @date 2017-10-11 11:55
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Customer;
import com.domain.PackageInformation;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import ognl.SimpleNode;

/**
 * @author wangzhenxin
 * @ClassName testOgnl
 * @Description 类描述
 * @date 2017-10-11
 */
public class testOgnl  {
    public static void main(String[] args) throws OgnlException{
        Customer customer = new Customer();
        PackageInformation packageInformation = new PackageInformation();
        customer.setName("com/aaa");
        customer.setSex("man");
        packageInformation.setIsCall(true);
        OgnlContext context = new OgnlContext();
        context.put("customer",customer);
        context.put("packageInformation",packageInformation);
        context.setRoot(customer);
        SimpleNode expr = (SimpleNode) Ognl.parseExpression("name");
        Object rootName = Ognl.getValue(expr, context.getRoot());
        System.out.println("根对象的名字是:"+rootName);

        SimpleNode exprsex = (SimpleNode) Ognl.parseExpression("sex");
        Object sex = Ognl.getValue(exprsex,context.getRoot());
        System.out.println("性别是:"+sex);
    }
}
