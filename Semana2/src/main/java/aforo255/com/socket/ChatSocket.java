package aforo255.com.socket;

import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat/{username}")
@ApplicationScoped
public class ChatSocket {

	private final ConcurrentHashMap<String, Session> sessionMap = new ConcurrentHashMap<>();

	@OnOpen
	public void onOpen(Session session, @PathParam("username") String username) {

		sessionMap.put(username, session);
		sendMessage(String.format("User %s logged in", username));
	}

	@OnMessage
	public void oMessage(String message, @PathParam("username") String username) {

		sendMessage(String.format(">> %s: %s", username, message));
	}

	@OnClose
	public void onClose(Session session, @PathParam("username") String username) {
		sessionMap.remove(username);
		sendMessage(String.format("User %s logged out", username));
	}

	@OnError
	public void onError(Session session, @PathParam("username") String username, Throwable throwable) {
		sessionMap.remove(username);
		throwable.printStackTrace();
		sendMessage(String.format("User %s logged out because of an error", username));
	}

	public void sendMessage(String message) {
		sessionMap.values().forEach(it -> it.getAsyncRemote().sendObject(message, sendResult -> {
			if (sendResult.getException() != null) {
				sendResult.getException().printStackTrace();
			}
		}));
	}
}
