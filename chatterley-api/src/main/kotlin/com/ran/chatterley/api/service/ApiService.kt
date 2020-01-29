package com.ran.chatterley.api.service

import com.ran.chatterley.schema.idp.SignInRequest
import com.ran.chatterley.schema.idp.SignInResponse
import com.ran.chatterley.schema.idp.SignUpRequest
import com.ran.chatterley.schema.idp.SignUpResponse
import com.ran.chatterley.schema.idp.service.IdpServiceGrpc.IdpServiceBlockingStub
import com.ran.chatterley.schema.api.service.ApiServiceGrpc.ApiServiceImplBase
import io.grpc.stub.StreamObserver

class ApiService(private val idpStub: IdpServiceBlockingStub) : ApiServiceImplBase() {

    override fun signUp(request: SignUpRequest, responseObserver: StreamObserver<SignUpResponse>) {
        println("Sign up request: $request")
        val response = idpStub.signUp(request)
        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }

    override fun signIn(request: SignInRequest, responseObserver: StreamObserver<SignInResponse>) {
        println("Sign in request $request")
        val response = idpStub.signIn(request)
        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }
}
