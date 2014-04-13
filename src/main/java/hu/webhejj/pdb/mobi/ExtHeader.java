package hu.webhejj.pdb.mobi;

public class ExtHeader {
	
	private int type;
	private byte[] value;
	
	public ExtHeader() {
	}
	public ExtHeader(int type, byte[] value) {
		this.type = type;
		this.value = value;
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public byte[] getValue() {
		return value;
	}
	public void setValue(byte[] value) {
		this.value = value;
	}
}