package ru.ruszhu;

import io.grpc.stub.StreamObserver;
import ru.ruszhu.grpc.GreetingServiceGrpc;
import ru.ruszhu.grpc.GreetingServiceOuterClass.HelloRequest;
import ru.ruszhu.grpc.GreetingServiceOuterClass.HelloResponse;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(HelloRequest request,
                         StreamObserver<HelloResponse> responseObserver) {
        System.out.println(request);

        HelloResponse response = HelloResponse.newBuilder()
                                              .setGreeting("Hello from server, " + request.getName())
                                              .build();
        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}
