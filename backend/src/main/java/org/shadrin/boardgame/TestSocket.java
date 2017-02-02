package org.shadrin.boardgame;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.eclipse.jetty.websocket.api.annotations.WebSocket;


@ClientEndpoint
@ServerEndpoint(value="/test/")
@WebSocket
public class TestSocket {
	@OnOpen
	public void onWebSocketConnect(Session session) {
		System.out.println("Socket connected: " + session);
	}
	
	@OnMessage
	public void onWebSocketText(String message) {
		System.out.println("Message received:" + message);
	}
	
	@OnClose
	public void onWebSocketClose(CloseReason reason) {
		System.out.println("Socket closed: " + reason);
	}
	
	@OnError
	public void onWebSocketError(Throwable cause) {
		cause.printStackTrace(System.err);
	}
}
