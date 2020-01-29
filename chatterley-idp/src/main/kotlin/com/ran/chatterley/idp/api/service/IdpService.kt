package com.ran.chatterley.idp.api.service

import com.ran.chatterley.schema.idp.SignInRequest
import com.ran.chatterley.schema.idp.SignInResponse
import com.ran.chatterley.schema.idp.SignUpRequest
import com.ran.chatterley.schema.idp.SignUpResponse
import com.ran.chatterley.schema.idp.service.IdpServiceGrpc.IdpServiceImplBase
import io.grpc.stub.StreamObserver

class IdpService : IdpServiceImplBase() {

    override fun signUp(request: SignUpRequest, responseObserver: StreamObserver<SignUpResponse>) {
        println("Sign up request: $request")
        val response = SignUpResponse.newBuilder().apply {
            accessToken = request.username + request.password
            refreshToken = request.password + request.username
        }.build()
        println("Sign up response: $response")

        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }

    override fun signIn(request: SignInRequest, responseObserver: StreamObserver<SignInResponse>) {
        println("Sign in request: $request")
        val response = SignInResponse.newBuilder().apply {
            accessToken = request.password + request.username
            refreshToken = request.username + request.password
        }.build()
        println("Sign in response: $response")

        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }
}
