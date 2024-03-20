package cn.javayong.idgenerator.server.test;

import cn.javayong.idgenerator.proto.IdGeneratorServiceGrpc;
import cn.javayong.idgenerator.proto.IdRequest;
import cn.javayong.idgenerator.proto.IdResult;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientTest {

    public static void main(String[] args) {
        String entId = "123";

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        for (int i = 0; i < 1000; i++) {
            IdGeneratorServiceGrpc.IdGeneratorServiceBlockingStub idGeneratorServiceBlockingStub =
                    IdGeneratorServiceGrpc.newBlockingStub(channel);
            IdRequest idRequest = IdRequest.newBuilder().setShardingKey(entId).build();

            IdResult idResult = idGeneratorServiceBlockingStub.getSeqId(idRequest);
            System.out.println(idResult);
        }
    }

}
