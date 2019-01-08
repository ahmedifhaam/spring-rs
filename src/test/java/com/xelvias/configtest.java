package com.xelvias;

import com.xelvias.CommonConfigurations.WebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {WebConfig.class},
        loader = AnnotationConfigContextLoader.class
)
public class configtest {

    @Test
    public void whenSpringContext_initiatedWithnoException(){

    }
}
