package com.appleieye.maya.api.impl;

import com.appleieye.maya.api.service.CompasticDisc;
import org.springframework.stereotype.Component;

/**
 * @author: wujianjun
 * @date: 2018-04-23
 * @description:
 */

@Component
public class SgtPeppers implements CompasticDisc {

    private String title = "Sgt. Pepper' s Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing " + title +" by " + artist);

    }
}
