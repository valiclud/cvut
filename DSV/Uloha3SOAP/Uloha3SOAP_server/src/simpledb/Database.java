package simpledb;

import java.io.Serializable;

public class Database implements Serializable, Comparable<Database> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dbName;

	public Database(String dbName) {
		super();
		this.dbName = dbName;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dbName == null) ? 0 : dbName.hashCode());
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
		Database other = (Database) obj;
		if (dbName == null) {
			if (other.dbName != null)
				return false;
		} else if (!dbName.equals(other.dbName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Database [dbName=" + dbName + "]";
	}

	@Override
	public int compareTo(Database arg0) {
		return arg0.getDbName().compareTo( dbName );	
	}	
}
