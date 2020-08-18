package com.nirja.grpcDemo.user;

import com.nirja.grpcDemo.User.APIResponse;
import com.nirja.grpcDemo.User.Empty;
import com.nirja.grpcDemo.User.LoginRequest;
import com.nirja.grpcDemo.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase {

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		System.out.println("Inside login");
		String username = request.getUsername();
		String password = request.getPassword();
		
		APIResponse.Builder response = APIResponse.newBuilder();
		if(username.contentEquals(password)) {
			response.setResponseCode(0).setResponsemessage("SUCCESS");
		}
		else {
			response.setResponseCode(100).setResponsemessage("INVALID");
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
		
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.logout(request, responseObserver);
	}

}
