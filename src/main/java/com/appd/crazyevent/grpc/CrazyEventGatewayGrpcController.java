package com.appd.crazyevent.grpc;

import com.appd.crazyevent.grpc.CrazyEventGatewayGrpc;
import com.appd.crazyevent.grpc.Event;
import com.appd.crazyevent.service.EventService;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author kumar
 *
 */
@GRpcService
public class CrazyEventGatewayGrpcController extends CrazyEventGatewayGrpc.CrazyEventGatewayImplBase {
	@Autowired
	private EventService eventService;
    
    private final Logger log = LoggerFactory.getLogger(CrazyEventGatewayGrpcController.class);


    @Override
    public void event(Event event, StreamObserver<com.google.protobuf.Empty> responseObserver) {
    	log.debug("Received GRPC message ?",event);
        // map the GrpcEvent to Event
    	//eventService.addEvent(event);
       // responseObserver.onCompleted();
    }
}
