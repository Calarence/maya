package com.appleieye.maya.api.impl;

import com.appleieye.maya.api.CDPlayerConfig;
import com.appleieye.maya.api.Config;
import com.appleieye.maya.api.service.CompasticDisc;
import com.appleieye.maya.api.service.MediaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author: wujianjun
 * @date: 2018-04-23
 * @description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Config.class)
@ContextConfiguration(locations = "classpath:config.xml")
public class CDPlayerTest {


   @Autowired
    private CompasticDisc cd;

   @Autowired
   private MediaPlayer player;

   @Test
    public void cdShouldNotBeNull(){
       assertNotNull(cd);
   }

   @Test
    public void play(){
       player.play();
   }

}
