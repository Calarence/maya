package com.appleieye.maya.api.impl;

import com.appleieye.maya.api.service.CompasticDisc;
import com.appleieye.maya.api.service.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: wujianjun
 * @date: 2018-04-23
 * @description:
 */

@Component
public class CDPlayer implements MediaPlayer {



    private CompasticDisc cd;

    @Autowired
    public CDPlayer(CompasticDisc cd){
        this.cd = cd;
    }


    public void play() {
        cd.play();
    }
}
