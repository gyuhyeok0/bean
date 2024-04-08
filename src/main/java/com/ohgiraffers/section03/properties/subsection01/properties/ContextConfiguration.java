package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.GenericGroovyApplicationContext;

import java.util.Date;

@Configuration
/* 필기  resources 폴더 하위에 읽어오는 annotation */
@PropertySource("section03/properties/subsection01/properties/product-info.properties")
public class ContextConfiguration {

    /* 필기
        @Value
        ${} : 치환자(placeholder) 문법을 이용하여 properties 에 저장된
               key 를 입력하면 value 에 해당하는 값을 꺼내올 수 있다.

     */

    @Value("${bread.carpbread.name}")           //필기 product 파일에 설정합 값불러오기
    private String carpBreadName;
    @Value("${bread.carpbread.price}")
    private int carpBreadPrice;

    @Value("${beverage.milk.name}")
    private String milkname;
    @Value("${beverage.milk.price}")
    private int milkprice;
    @Value("${beverage.milk.capacity")
    private int milkcapacity;

    @Bean
    public Product carpBread() {
        return new Bread(carpBreadName, carpBreadPrice , new Date());           //필기 어플리케이션에 넣어줄 정보
    }

    @Bean
    public Product milk(){
        return new Beverage(milkname,milkprice,milkcapacity);
    }

    @Bean
    public Product water(@Value("${beverage.water.name}")String waterNAme,
                         @Value("${beverage.water.name}")int waterPrice,
                         @Value("${beverage.water.name}")int waterCapacity) {

        return new Beverage(waterNAme,waterPrice,waterCapacity);
    }
    @Bean
    @Scope("prototype")
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}
