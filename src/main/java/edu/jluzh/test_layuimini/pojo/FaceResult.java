package edu.jluzh.test_layuimini.pojo;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/28 19:02
 * @version:
 * @modified By:
 */
@Data
public class FaceResult {
    Double finalScore;
    String message;
}
