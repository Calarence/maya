package com.appleieye.maya.api;

import com.appleieye.maya.api.impl.CDPlayer;
import com.appleieye.maya.api.impl.SgtPeppers;
import com.appleieye.maya.api.service.CompasticDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wujianjun
 * @date: 2018-04-23
 * @description:
 */

@Configuration
public class Config {

    @Bean
    public SgtPeppers sgtPeppers(){
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(CompasticDisc cd){
        return new CDPlayer(cd);
    }
}
