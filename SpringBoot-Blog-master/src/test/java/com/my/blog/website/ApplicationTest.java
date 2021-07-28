package com.my.blog.website;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Test
    public void test1() throws ParseException {
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.format(
                new Date(Long.parseLong("1487853610" + "000"))));
        System.out.println(simpleDateFormat.format(
                new Date(Long.parseLong("1487853610" + "000"))));
    }

}
