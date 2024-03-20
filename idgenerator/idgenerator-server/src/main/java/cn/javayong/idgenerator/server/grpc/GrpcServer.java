package cn.javayong.idgenerator.server.grpc;

import cn.javayong.idgenerator.server.MainApplication;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrpcServer {

    private final static Logger logger = LoggerFactory.getLogger(MainApplication.class);

    private IdGeneratorGprcImpl idGeneratorGprc;

    private final int port = 50051;

    private Server server;

    public void start() {
        try {
            logger.info("开始启动ID生成器服务");
            server = ServerBuilder.forPort(port)
                    .addService(idGeneratorGprc)
                    .build()
                    .start();
        } catch (Throwable e) {
            logger.error("grpc server start error:", e);
        }
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (server != null) {
                server.shutdown();
            }
        }));
        logger.info("结束启动ID生成器服务 listening on " + port);
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    //============================================================================================================
    public void setIdGeneratorGprc(IdGeneratorGprcImpl idGeneratorGprc) {
        this.idGeneratorGprc = idGeneratorGprc;
    }

}
