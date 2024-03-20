package cn.javayong.idgenerator.server;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {

    private final static Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext
                    (
                            "classpath:spring-app.xml"
                    );
        } catch (Throwable e) {
            logger.error("start grpc id generator error:", e);
        }
    }

}
