package com.example.springsourcestudy.基础知识.tool.资源api;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源工具测试(spring-core)
 *
 * @author OneKeInUrSoul
 * @since 2023/07/30
 */
public class ResourceToolTest {
    @Test
    void testUrl() throws IOException {
        Resource urlResource = new UrlResource("https://dldir1.qq.com/qqfile/qq/PCQQ9.7.12/QQ9.7.12.29112.exe");
        InputStream inputStream = urlResource.getInputStream();
        IOUtils.copy(inputStream, System.out);
    }

    @Test
    void testClassPath() throws IOException {
        Resource classPathResource = new ClassPathResource("bean.xml");
        InputStream inputStream = classPathResource.getInputStream();
        byte[] bytes = IOUtils.toByteArray(inputStream);
        System.out.println(new String(bytes));
    }

    /**
     * 测试路径匹配资源模式解析器
     *
     * @throws IOException ioexception
     */
    @Test
    void testPathMatchingResourcePatternResolver() throws IOException {
         PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
         Resource[] resources = pathMatchingResourcePatternResolver.getResources("classpath*:bean.xml");
         for (Resource resource : resources) {
             System.out.println(resource);
         }
    }
}
