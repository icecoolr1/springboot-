package edu.jluzh.test_layuimini.pojo;

/**
 * @description: 方便前后端交互layui表格的输出
 * @author: icecool
 * @date: Created in 2021/5/20 23:07
 * @version:
 * @modified By:
 */
public class UserTable {
    private int code;//状态码
    private String msg;//消息
    private long count;//总数
    private Object data;//数据

    public UserTable() {
    }

    public UserTable(int code, String msg, long count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
