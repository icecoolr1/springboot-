package edu.jluzh.test_layuimini.utils;

import com.baidu.aip.util.Base64Util;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/28 8:35
 * @version:
 * @modified By:
 */
public class FaceService {

    public static String addUserFace(String userImg,String userId,String userInfo){
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            Map<String, Object> map = new HashMap<>();
            String path =userImg;
            byte[] imgData = FileUtil.readFileByBytes(path);
            String imgStr = Base64Util.encode(imgData);
            map.put("image", imgStr);
            map.put("group_id", "test");
            map.put("user_id", userId);
            map.put("user_info", userInfo);
            map.put("liveness_control", "NORMAL");
            map.put("image_type", "BASE64");
            map.put("quality_control", "NONE");

            String param2 = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = FaceAuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param2);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String faceSearch(String img) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try {
            //String path = "D:/image/tmp/test.jpg";
            byte[] imgData = FileUtil.readFileByBytes(img);
            String imgStr = Base64Util.encode(imgData);
            Map<String, Object> map = new HashMap<>();
            map.put("image",imgStr);
            map.put("liveness_control", "NORMAL");
            map.put("group_id_list", "test");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken =  FaceAuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//
//        FaceService.faceSearch();
//    }
}
