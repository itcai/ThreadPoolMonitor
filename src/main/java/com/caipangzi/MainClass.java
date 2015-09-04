package com.caipangzi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: Jason Tsai
 * Date: 15/9/4
 * Time: 10:32
 * To change this template use File | Settings | File Templates.
 */
public class MainClass {

    public static void main(String[] args) {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        Tester tester = (Tester) act.getBean("Tester");
        tester.go();
    }

}
