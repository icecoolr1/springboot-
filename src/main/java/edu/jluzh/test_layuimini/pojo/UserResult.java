package edu.jluzh.test_layuimini.pojo;

/**
 * @description: 在删除用户过程中便于前后端交互信息
 * @author: icecool
 * @date: Created in 2021/5/21 9:31
 * @version:
 * @modified By:
 */
public class UserResult {
    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
