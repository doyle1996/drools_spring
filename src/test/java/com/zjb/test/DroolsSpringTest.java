package com.zjb.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieBase;
import org.kie.api.cdi.KBase;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//加载配置文件
@ContextConfiguration(locations = "classpath:spring.xml")

public class DroolsSpringTest {
    @KBase("kbase")
    private KieBase kieBase;//注入KieBase对象
    @Test
    public void test1(){
        KieSession kieSession = kieBase.newKieSession();
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @KSession("ksession")
    private KieSession kieSession;  //不建议直接注入session对象，建议选用上面的方法
    @Test
    public void Test2(){
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
