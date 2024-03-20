package cn.javayong.idgenerator.server.grpc;

import cn.javayong.idgenerator.proto.IdGeneratorServiceGrpc;
import cn.javayong.idgenerator.proto.IdResult;
import cn.javayong.idgenerator.server.common.ResponseEntity;
import cn.javayong.idgenerator.server.service.RedisIdGeneratorServiceForSpring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IdGeneratorGprcImpl extends IdGeneratorServiceGrpc.IdGeneratorServiceImplBase {

    private final static Logger logger = LoggerFactory.getLogger(IdGeneratorGprcImpl.class);

    private RedisIdGeneratorServiceForSpring redisIdGeneratorServiceForSpring;

    public void getSeqId(cn.javayong.idgenerator.proto.IdRequest request,
                          io.grpc.stub.StreamObserver<cn.javayong.idgenerator.proto.IdResult> responseObserver) {
        Long seqId = redisIdGeneratorServiceForSpring.createUniqueId(request.getShardingKey());

        IdResult idResult = IdResult.newBuilder().setCode(ResponseEntity.SUCCESS).setId(seqId).build();
        responseObserver.onNext(idResult);
        responseObserver.onCompleted();
    }

    //============================================================================================================
    public void setRedisIdGeneratorServiceForSpring(RedisIdGeneratorServiceForSpring redisIdGeneratorServiceForSpring) {
        this.redisIdGeneratorServiceForSpring = redisIdGeneratorServiceForSpring;
    }

}
