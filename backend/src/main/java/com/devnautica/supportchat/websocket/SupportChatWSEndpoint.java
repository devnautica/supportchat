package com.devnautica.supportchat.websocket;

import org.apache.log4j.Logger;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/supportchat")
public class SupportChatWSEndpoint {
	private static final Logger log = Logger.getLogger(SupportChatWSEndpoint.class);
	private Session session;
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		log.debug("Session: "+session.getId()+" opened");
	}

	@OnClose
	public void onClose() {
		log.debug("Session: "+session.getId()+" closed");
	}

	@OnMessage
	public String onMessage(String msg) {
		log.debug("Session: "+session.getId()+" received message: "+msg);
		return null;
	}

	@OnError
	public void onError(Throwable e) {
		log.error("Session: "+session.getId()+" fired error: "+e.getMessage(),e);
	}

}
