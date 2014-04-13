package hu.webhejj.pdb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PalmDataBase {

	private String name;
	private int attributes;
	private int version;
	private Date creationDate;
	private Date modificationDate;
	private Date lastBackupDate;
	private long modificationNumber;
	private String type;
	private String creator;
	private long uniqueIdSeed;

	private List<PalmRecord> palmRecords = new ArrayList<PalmRecord>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAttributes() {
		return attributes;
	}
	public void setAttributes(int attributes) {
		this.attributes = attributes;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	public Date getLastBackupDate() {
		return lastBackupDate;
	}
	public void setLastBackupDate(Date lastBackupDate) {
		this.lastBackupDate = lastBackupDate;
	}
	public long getModificationNumber() {
		return modificationNumber;
	}
	public void setModificationNumber(long modificationNumber) {
		this.modificationNumber = modificationNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public long getUniqueIdSeed() {
		return uniqueIdSeed;
	}
	public void setUniqueIdSeed(long uniqueIdSeed) {
		this.uniqueIdSeed = uniqueIdSeed;
	}
	public List<PalmRecord> getPalmRecords() {
		return palmRecords;
	}
	public void setPalmRecords(List<PalmRecord> palmRecords) {
		this.palmRecords = palmRecords;
	}
}
