package edu.jluzh.test_layuimini.bean;


import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/26 16:01
 * @version:
 * @modified By:
 */
@Data
public class CarImg implements Serializable {
    private Integer imgId;
    private Integer carId;
    private String licenseNumber;
    private String imgPath;
}
