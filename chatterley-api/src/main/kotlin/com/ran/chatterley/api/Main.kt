package com.ran.chatterley.api

import com.ran.chatterley.api.service.ApiService
import com.ran.chatterley.schema.idp.service.IdpServiceGrpc
import io.grpc.ManagedChannelBuilder
import io.grpc.ServerBuilder
import io.grpc.protobuf.services.ProtoReflectionService

fun main() {
    val idpPort = 50051
    val idpHost = "localhost"
    val idpChannel = ManagedChannelBuilder
            .forAddress(idpHost, idpPort)
            .usePlaintext()
            .build()
    val idpStub = IdpServiceGrpc.newBlockingStub(idpChannel)

    val apiPort = 50050
    val apiService = ApiService(idpStub)
    val apiServer = ServerBuilder
            .forPort(apiPort)
            .addService(apiService)
            .addService(ProtoReflectionService.newInstance())
            .build()
            .start()
    println("Api server started")

    Runtime.getRuntime().addShutdownHook(Thread {
        apiServer.shutdown()
        println("Api server stopped")
    })

    apiServer.awaitTermination()
}
