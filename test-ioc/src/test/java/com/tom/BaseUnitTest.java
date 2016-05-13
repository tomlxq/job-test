package com.tom;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by tom on 2016/5/4.
 */

    @ContextConfiguration(locations = {"classpath:application.xml"})
    @RunWith(SpringJUnit4ClassRunner.class)
    public class BaseUnitTest {
        protected Logger logger = LoggerFactory.getLogger(BaseUnitTest.class);
}
