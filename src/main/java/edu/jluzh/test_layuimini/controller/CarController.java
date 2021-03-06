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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:    要我说，这个模块的代码烂爆了，因为我改了一次数据库，导致有些方法再也没有用过，所幸的是它跑起来了，
 * 以后有时间(bushi)尽量优化一下
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
    CarImg img = new CarImg();

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
            iCarImgService.deleteImg(i);
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


        String path = (String)session.getAttribute("path");

        //没有添加图片
        if(path==null){
            carService.updateCar(car);
        }else {
            img.setLicenseNumber(car.getLicenseNumber());
            img.setCarId(car.getCarId());
            String pathname =  path.substring(2);
            img.setImgPath(pathname);
            //找到imgid
            //img.setCarImgId(newCar.getCarImg().getCarImgId());
            iCarImgService.updateImg(img);
            carService.updateCar(car);
        }

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

        if(carService.findCarByLi(number)==null){
            carService.addCar(car);
            int id = carService.findCarId(number);

            System.out.println("carid值"+id);
            img.setCarId(id);
            //分割字符串使前端能够访问
            String pathname =  path.substring(2);
            img.setImgPath(pathname);
            System.out.println("img"+img);
            iCarImgService.addCarImg(img);
            result.setStatus("0");
            result.setMessage("Ok");
        }else {
            result.setMessage("车牌号重复!");
            result.setStatus("1");
        }
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
        //分割路径
        assert pathString != null;
        String path = pathString.substring(2);
        System.out.println(pathString);
        fileUploadMessage.setData(pathString);
        fileUploadMessage.setMsg(number);
        src.put("file",path);
        fileUploadMessage.setData(src);
        fileUploadMessage.setFiles(src);
        return fileUploadMessage;
    }

    @PostMapping("/getCarListForUse")
    public UserTable getCarListForUse(int page, int limit){
        PageInfo<Car> pageInfo = carService.findCarsForUse(page, limit);
        table.setCode(0);
        table.setMsg("ok");
        table.setCount(pageInfo.getTotal());
        table.setData(pageInfo.getList());
        System.out.println("文件是"+pageInfo.getList());
        return table;
    }


}
