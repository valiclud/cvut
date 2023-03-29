package xd36dsv.valiclud.cvi2.simpledb;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBRecord implements Serializable, Comparable<DBRecord> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date tsCreate;
	private Date tsModify;
	private Integer key;
	private String message;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public DBRecord(Date tsCreate, Date tsModify, Integer key,
			String message) {
		super();
		this.tsCreate = tsCreate;
		this.tsModify = tsModify;
		this.key = key;
		this.message = message;
	}
	
	@SuppressWarnings("deprecation")
	public DBRecord(String tsC, String tsM, String k, String message) {
		super();
			
		this.tsCreate = new Date (Date.parse(tsC));
		this.tsModify = new Date (Date.parse(tsM));
		this.key = Integer.valueOf(k);
		this.message = message;
	}

	public Date getTsCreate() {
		return tsCreate;
	}

	public void setTsCreate(Date tsCreate) {
		this.tsCreate = tsCreate;
	}

	public Date getTsModify() {
		return tsModify;
	}

	public void setTsModify(Date tsModify) {
		this.tsModify = tsModify;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		DBRecord other = (DBRecord) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	@Override
	public int compareTo( DBRecord o) {
        return key - o.getKey();
    }

	@Override
	public String toString() {
//		return "DatabaseRecord [tsCreate=" + tsCreate + ", tsModify="
//				+ tsModify + ", key=" + key + ", message=" + message + "]";
		return "\"" + formatter.format(tsCreate) +  "\";\"" + formatter.format(tsModify) + "\";\""
				+ key.toString() + "\";\"" + message + "\"" ;		
	}
}
