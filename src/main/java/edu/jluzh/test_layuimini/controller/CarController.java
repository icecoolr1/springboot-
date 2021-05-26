package edu.jluzh.test_layuimini.controller;

import com.github.pagehelper.PageInfo;
import edu.jluzh.test_layuimini.bean.Car;
import edu.jluzh.test_layuimini.bean.CarImg;
import edu.jluzh.test_layuimini.pojo.FileUploadMessage;
import edu.jluzh.test_layuimini.pojo.UserResult;
import edu.jluzh.test_layuimini.pojo.UserTable;
import edu.jluzh.test_layuimini.service.ICarImgService;
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
    @Autowired
    ICarImgService iCarImgService;
    UserResult result = new UserResult();
    UserTable table = new UserTable();
    FileUploadMessage fileUploadMessage = new FileUploadMessage();

    //返回车辆信息
    @PostMapping("/getCarList")
    public UserTable getCarList(int page, int limit,String licenseNumber){

        //PageInfo<Car> pageInfoAll = carService.findAllCar(page, limit);
        //PageInfo<Car> carPageInfo = carService.findCarByLicence(page, limit, licenseNumber);
        PageInfo<Car> carPageInfoWithImg = carService.findAllCarWithImg(page, limit);
        PageInfo<Car> carPageInfoWithLicense = carService.findAllCarWithImgByLicense(page, limit,licenseNumber);
        table.setCode(0);
        table.setMsg("成功");
        System.out.println(licenseNumber);
        if (licenseNumber==null){
            table.setCount(carPageInfoWithImg.getTotal());
            table.setData(carPageInfoWithImg.getList());
        }else {
            table.setCount(carPageInfoWithLicense.getTotal());
            table.setData(carPageInfoWithLicense.getList());
        }
        return table;
    }

    //删除车辆
    @PostMapping("/delete")
    public UserResult deleteCarlist(@RequestParam(value = "params[]") int[] params){
        for (int i : params) {
            //先删附表 再删除主表
            String Li = carService.findLicense(i);
            iCarImgService.deleteImg(Li);
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
    public UserResult addCar(Car car,HttpSession session){
        //获取上传图片路径
        String path = (String)session.getAttribute("path");
        String number = car.getLicenseNumber();
        CarImg img = new CarImg();
        img.setLicenseNumber(number);
        System.out.println("车牌号"+number);

        carService.addCar(car);
        //分割字符串使前端能够访问
        String pathname =  path.substring(2);
        img.setImgPath(pathname);
        iCarImgService.addCarImg(img);
        result.setStatus("0");
        result.setMessage("Ok");

        return result;
    }

    @PostMapping("/BaiDuApi")
    public FileUploadMessage RecNumber(@RequestParam("file") MultipartFile file,HttpSession session) throws Exception {
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
        //在session中保存文件存放路径
        session.setAttribute("path",pathString);
        System.out.println(pathString);
        fileUploadMessage.setData(pathString);
        fileUploadMessage.setMsg(number);
        src.put("src",pathString);
        fileUploadMessage.setData(src);
        return fileUploadMessage;
    }
}
