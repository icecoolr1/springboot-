package edu.jluzh.test_layuimini.service.impl;

import edu.jluzh.test_layuimini.bean.CarImg;
import edu.jluzh.test_layuimini.mapper.ICarImgMapper;
import edu.jluzh.test_layuimini.service.ICarImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/26 19:32
 * @version:
 * @modified By:
 */
@Service
public class CarImgServiceImpl implements ICarImgService {
    @Autowired
    ICarImgMapper carImgMapper;
    @Override
    public void addCarImg(CarImg img) {
        carImgMapper.addCarImg(img);
    }

    @Override
    public void deleteImg(String licenseNumber) {
        carImgMapper.deleteImg(licenseNumber);
    }

    @Override
    public void updateImg(CarImg img) {

    }

    @Override
    public CarImg findCarImg(String licenseNumber) {
        return null;
    }
}
