package com.ran.chatterley.idp

import com.ran.chatterley.idp.api.service.IdpService
import io.grpc.ServerBuilder
import io.grpc.protobuf.services.ProtoReflectionService

fun main() {
    val idpPort = 50051
    val idpService = IdpService()
    val idpServer = ServerBuilder
            .forPort(idpPort)
            .addService(idpService)
            .addService(ProtoReflectionService.newInstance())
            .build()
            .start()
    println("Idp server started")

    Runtime.getRuntime().addShutdownHook(Thread {
        idpServer.shutdown()
        println("Idp server stopped")
    })

    idpServer.awaitTermination()
}
