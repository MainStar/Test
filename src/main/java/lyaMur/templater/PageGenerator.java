package lyaMur.templater;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lyaMur.utils.Constants;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class PageGenerator {

    private static PageGenerator pageGenerator;
    private Configuration cfg;

    public static PageGenerator instance(){
        if (pageGenerator == null){
            pageGenerator = new PageGenerator();
        }
        return pageGenerator;
    }

    public String getPage(String fileName, HashMap<String, Object> data){
        Writer stream = new StringWriter();
        try {

            cfg.setDirectoryForTemplateLoading(new File(Constants.HTML_DIR));
            Template template = cfg.getTemplate(fileName);
            template.process(data, stream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return stream.toString();
    }

    private PageGenerator(){
        cfg = new Configuration();
    }

}
