package xd36dsv.valiclud.sem.evaluation;

import java.io.Serializable;

public class Message implements Serializable, Comparable<Message> {

	private static final long serialVersionUID = -2216201827847740003L;
	private String nodeName;
	private String message;
	private int uid;
	

	public Message(String nodeName, String message, int uid) {
		super();
		this.nodeName = nodeName;
		this.message = message;
		this.uid = uid;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getNodeName() {
		return nodeName;
	}
	
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + uid;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (uid != other.uid)
			return false;
		return true;
	}
	
	@Override
	public int compareTo( Message o) {
        return uid - o.getUid();
    }
}
