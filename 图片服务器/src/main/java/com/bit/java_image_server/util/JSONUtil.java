package com.bit.java_image_server.util;

import com.bit.java_image_server.exception.AppException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JSONUtil {

    private static final ObjectMapper M = new ObjectMapper();

    //序列化：将java对象序列化为json字符串
    public static String serialize(Object o) {
        try {
            return M.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new AppException("对象序列化为json失败："+o, e);
        }
    }

    //反序列化：将json字符串反序列化为java对象
    public static <T> T deserialize(InputStream is, Class<T> c) {
        try {
            return M.readValue(is, c);
        } catch (IOException e) {
            throw new AppException("json反序列化为对象失败，一般是json中的键在对象中没有对应属性", e);
        }
    }
}
