package edu.jluzh.test_layuimini.controller;

import com.github.pagehelper.PageInfo;
import edu.jluzh.test_layuimini.bean.Car;
import edu.jluzh.test_layuimini.pojo.FileUploadMessage;
import edu.jluzh.test_layuimini.pojo.UserResult;
import edu.jluzh.test_layuimini.pojo.UserTable;
import edu.jluzh.test_layuimini.service.ICarService;
import edu.jluzh.test_layuimini.utils.LicensePlate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/22 19:24
 * @version:
 * @modified By:
 */
@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    ICarService carService;
    UserResult result = new UserResult();
    UserTable table = new UserTable();
    FileUploadMessage fileUploadMessage = new FileUploadMessage();

    //返回车辆信息
    @PostMapping("/getCarList")
    public UserTable getCarList(int page, int limit,String licenseNumber){

        PageInfo<Car> pageInfoAll = carService.findAllCar(page, limit);
        PageInfo<Car> carPageInfo = carService.findCarByLicence(page, limit, licenseNumber);
        table.setCode(0);
        table.setMsg("成功");
        if (licenseNumber==null){
            table.setCount(pageInfoAll.getTotal());
            table.setData(pageInfoAll.getList());
        }else {
            table.setCount(carPageInfo.getTotal());
            table.setData(carPageInfo.getList());
        }
        return table;
    }

    //删除车辆
    @PostMapping("/delete")
    public UserResult deleteCarlist(@RequestParam(value = "params[]") int[] params){

        for (int i : params) {
            carService.deleteCarList(i);
        }
        result.setStatus("0");
        result.setMessage("Ok");
        return result;
    }

    //编辑车辆
    @PostMapping("/editCar")
    public UserResult updateCar(HttpSession session,Car car){
        Integer id = (Integer) session.getAttribute("carId");
        car.setCarId(id);
        carService.updateCar(car);
        result.setStatus("0");
        result.setMessage("Ok");
        return result;
    }

    @PostMapping("/carAdd")
    public UserResult addCar(Car car){
        carService.addCar(car);
        result.setStatus("0");
        result.setMessage("Ok");
        return result;
    }

    @PostMapping("/BaiDuApi")
    public FileUploadMessage RecNumber(@RequestParam("file") MultipartFile file) throws Exception {
        fileUploadMessage.setCode(0);
        Map<String,String> src = new HashMap<>();

        String pathString = null;
        if(!file.isEmpty()){
            //设置文件路径
            pathString = "D:/image/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" +file.getOriginalFilename();
            //保存到文件服务器
            file.transferTo(new File(pathString));
        }
        String number = LicensePlate.licensePlate(pathString);
        System.out.println(pathString);
        fileUploadMessage.setData(pathString);
        fileUploadMessage.setMsg(number);
        src.put("src",pathString);
        fileUploadMessage.setData(src);
        return fileUploadMessage;
    }
}
