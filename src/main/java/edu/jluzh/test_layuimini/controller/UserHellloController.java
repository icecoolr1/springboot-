package edu.jluzh.test_layuimini.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import edu.jluzh.test_layuimini.pojo.Base64Req;
import edu.jluzh.test_layuimini.pojo.FaceResult;
import edu.jluzh.test_layuimini.pojo.UserResult;
import edu.jluzh.test_layuimini.utils.BaseToImg;
import edu.jluzh.test_layuimini.utils.FaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/28 9:38
 * @version:
 * @modified By:
 */
@Controller
@RequestMapping("userHello")
public class UserHellloController {
   UserResult result = new UserResult();
   FaceResult faceResult = new FaceResult();
    @RequestMapping("findFace")
    @ResponseBody
    public UserResult userFaceSearch(@RequestBody Base64Req base64Req) throws IOException {
        //将用户图片保存到本地
        String pathString = "D:/image/tmp/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".jpg";
        BaseToImg.GenerateImage(base64Req.getBase64(), pathString);
        //百度api注册用户
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");
        FaceService.addUserFace(pathString,uuidStr,"testForAdd");
        result.setStatus("0");
        result.setMessage("成功");
        return result;
    }
    @RequestMapping("enter")
    @ResponseBody
    private FaceResult userFaceEnter(@RequestBody Base64Req base64Req) throws IOException {
        //这段代码低俗到爆 以后更深入学习json后一定重构
        String pathString = "D:/image/tmp/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".jpg";
        BaseToImg.GenerateImage(base64Req.getBase64(), pathString);
        JSONObject jsonObject = JSONObject.parseObject(FaceService.faceSearch(pathString));
        System.out.println("json字符串"+jsonObject);
        //图像正常识别处理
        if(jsonObject.getJSONObject("result")!=null) {
            //大致思路是把json转存为字符串然后切割 只是为了运行而设计的代码
            JSONArray jsonArray = jsonObject.getJSONObject("result").getJSONArray("user_list");
            List<String> list = (List<String>) JSONArray.parseArray(jsonArray.toString(), String.class);
            String score = list.get(0);
            String[] end = score.split(",");
            System.out.println("测试字符串" + score);

            String truescore = end[0].substring(9);
            String userid = end[2].substring(10).replace("\"", "");
            System.out.println(userid);
            double finalScore = Double.parseDouble(truescore);
            System.out.println("最终得分" + finalScore);
            faceResult.setFinalScore(finalScore);
            faceResult.setMessage(userid);
        }else {
            //错误码处理
            faceResult.setMessage(null);
            faceResult.setFinalScore(0.0);
        }
        return faceResult;
    }


}
