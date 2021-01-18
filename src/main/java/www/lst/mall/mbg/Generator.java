package www.lst.mall.mbg;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
* mbg生成器
* */
public class Generator {
    public static void main(String[] args) throws Exception {
        //mbg执行过程
        List<String> warnings = new ArrayList<String>();
        //当生成代码重复时，覆盖原代码
        boolean overwrite = true;
        //读取我们的MBG配置文件
        InputStream resourceAsStream = Generator.class.getResourceAsStream("/generatorConfig.xml");
        //File resourceAsStream = new File("generatorConfig.xml");
        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
        Configuration configuration = configurationParser.parseConfiguration(resourceAsStream);
        resourceAsStream.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        //创建MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration,callback,warnings);
        //执行生成代码
        myBatisGenerator.generate(null);
        //输出警告框
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
