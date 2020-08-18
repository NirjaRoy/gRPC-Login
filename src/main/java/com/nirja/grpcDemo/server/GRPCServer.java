package com.nirja.grpcDemo.server;

import java.io.IOException;

import com.nirja.grpcDemo.user.UserService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GRPCServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Builder for server
		Server server = ServerBuilder.forPort(7134).addService(new UserService()).build();
		server.start();
		System.out.println("Server started at "+ server.getPort());
		server.awaitTermination();
	}
}
