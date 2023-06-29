package ru.ruszhu;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import ru.ruszhu.grpc.GreetingServiceGrpc;
import ru.ruszhu.grpc.GreetingServiceGrpc.GreetingServiceBlockingStub;
import ru.ruszhu.grpc.GreetingServiceOuterClass.HelloRequest;
import ru.ruszhu.grpc.GreetingServiceOuterClass.HelloResponse;

public class Client {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                                                      .usePlaintext()
                                                      .build();

        GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

        HelloRequest request = HelloRequest.newBuilder()
                                           .setName("John")
                                           .build();

        HelloResponse response = stub.greeting(request);

        System.out.println(response);

        channel.shutdownNow();
    }
}
