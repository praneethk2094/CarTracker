package com.java.training.entities;

import lombok.Data;

import javax.persistence.Embeddable;

/**
 * Created by diksh on 6/26/2017.
 */
@Data
@Embeddable
public class Tires {
    private byte frontLeft;
    private byte frontRight;
    private byte rearLeft;
    private byte rearRight;

}
