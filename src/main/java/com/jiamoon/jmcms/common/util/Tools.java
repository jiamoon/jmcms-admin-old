package com.jiamoon.jmcms.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.UUID;

/**
 * 常用工具类
 */
public class Tools {
    /**
     * 记录日志信息
     */
    //private static Logger logger = LogManager.getLogger(Tools.class);
    /**
     * 用于处理json字符串的静态对象
     */
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 获取当前网络ip
     *
     * @param req
     * @return
     */
    public static String getIpAddr(ServletRequest req) {
        HttpServletRequest request = (HttpServletRequest) req;
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    /**
     * 返回BootstrapTable需要的数据
     *
     * @param list
     * @param total
     * @return
     */
    public static HashMap<String, Object> getBootstrapTableData(Object list, long total) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("rows", list);
        map.put("total", total);
        return map;
    }

    /**
     * 对象转xml,默认utf-8格式
     *
     * @param object
     * @return xml字符串
     * @throws Exception
     */
    public static String convertToXml(Object object) throws Exception {
        return convertToXml(object, "UTF-8");
    }

    /**
     * 对象转xml
     *
     * @param object   需要转换的对象
     * @param encoding 编码格式
     * @return xml字符串
     * @throws JAXBException
     */
    public static String convertToXml(Object object, String encoding) throws JAXBException {
        String result = "";
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            StringWriter writer = new StringWriter();
            marshaller.marshal(object, writer);
            result = writer.toString();
        } catch (JAXBException e) {
            //logger.error("对象转xml字符串的错误日志-->>" + e.getMessage(), e);
        }
        //logger.debug("生成对象转XML字符串的调试日志-->>" + result);
        return result;
    }

    /**
     * xml字符串转Java对象
     *
     * @param xml      xml字符串
     * @param clazz<T> Java对象类型
     * @return Java对象
     * @throws JAXBException
     */
    public static <T> T converyToJavaBean(String xml, Class<T> clazz) throws JAXBException {
        T t = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            t = (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            //logger.error("xml转实体bean的错误日志-->>"+e.getMessage(), e);
        }
        return t;
    }

    /**
     * 对象转json字符串
     *
     * @param object 需要转换的对象
     * @return 转换后的json字符串
     * @throws IOException
     */
    public static synchronized String objectToJson(Object object) throws IOException {
        Writer writer = null;
        String json = "";
        try {
            writer = new StringWriter();
            objectMapper.writeValue(writer, object);
            json = writer.toString();
        } catch (IOException e) {
            //logger.error("实体对象转JSON字符串的错误日志-->>"+e.getMessage(),e);
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                //logger.error("实体对象转JSON字符串关闭writer的错误日志-->>"+e.getMessage(),e);
            }
        }
        //logger.debug("生成实体转JSON字符串的调试日志-->>"+json);
        return json;
    }

    /**
     * json转对象
     *
     * @param json     需要转换的json字符串
     * @param clazz<T> 需要转换的对象类型
     * @return
     * @throws IOException
     */
    public static synchronized <T> T jsonToObject(String json, Class<T> clazz) throws IOException {
        T object = null;
        try {
            object = objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            //logger.error("JSON字符串转实体bean的错误日志-->>"+e.getMessage(),e);
        }
        return object;
    }

    /**
     * 获得异常的详细信息
     *
     * @param e 异常对象
     * @return
     */
    public static String getErrorInfo(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw, true));
        String info = sw.toString();
        try {
            sw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return info;
    }

    /**
     * 生成一个uuid
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
