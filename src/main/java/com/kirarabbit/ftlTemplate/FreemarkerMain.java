package com.kirarabbit.ftlTemplate;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class FreemarkerMain {

    private static final Configuration cfg;

    static {
        cfg = new Configuration(Configuration.VERSION_2_3_23);
        try {
            // 设置模板路径
            cfg.setDirectoryForTemplateLoading(new File("static/template"));
            // 设置默认编码
            cfg.setDefaultEncoding("utf-8");
            //若发生错误，HTML_DEBUG_HANDLER会生成错误信息到生成页面;RETHROW_HANDLER错误信息会输出到控制台
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param modeName       模板名称
     * @param targetFileName 生成后的HTML名称
     * @param params         传入模板的参数
     * @Author: IT实战联盟Tony
     * @Date: 15:57 2018/2/9
     * @Description:生成静态页面
     */
    public static void createHtmlByMode(String modeName, String targetFileName, Map<String, Object> params) throws Exception {
        Writer out = null;
        //生成demo存放路径
        String folder = "static/template";
        //通过匹配路径格式拼接完整生成路径
        String outFile = folder + File.separator + targetFileName;
        try {
            File file = new File(FreemarkerMain.class.getResource("/").getPath()+File.separator+folder);
            //生成空HTML文件
            if (!file.exists()) {
                file.createNewFile();
            }

            // 创建模版对象
            Template template = cfg.getTemplate(modeName);

            // 设置输出流
            out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");// 设置编码 UTF-8

            // 模版数据插入参数，通过输出流插入到HTML中
            template.process(params, out);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //
    public static void main(String[] args) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("title", "IT实战联盟");
        params.put("author", "tony");
        params.put("publishTime", "2018-02-09");
        params.put("seeNum", "888");
        params.put("seeNum", "888");
        params.put("imgPath", "http://www.baidu.com");
        params.put("content", "扫码关注IT实战联盟");

        FreemarkerMain.createHtmlByMode("template.ftl", "new1234.html", params);
    }

}