package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 前后端接口需要的统一字段
 */
@Getter
@Setter
@ToString
public class Response {
    //当前接口响应是否操作成功
    private boolean ok;
    //操作失败时，前端要展示的错误信息
    private String reason;
}
