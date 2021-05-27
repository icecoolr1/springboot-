package edu.jluzh.test_layuimini.pojo;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/25 19:22
 * @version:
 * @modified By:
 */
public class FileUploadMessage {
    private int code;//状态码
    private String msg;//消息
    private Object data;//数据
    private Object files;//路径


    public FileUploadMessage() {
    }

    public FileUploadMessage(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getFiles() {
        return files;
    }

    public void setFiles(Object files) {
        this.files = files;
    }

    @Override
    public String
    toString() {
        return "FileUploadMessage{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", files=" + files +
                '}';
    }
}
