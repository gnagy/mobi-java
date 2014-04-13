package hu.webhejj.pdb.mobi;


public class MobiBook {

	private String title;
	private MobiBookInfo extraInfo;
	private String text;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MobiBookInfo getExtraInfo() {
		return extraInfo;
	}
	public void setExtraInfo(MobiBookInfo extraInfo) {
		this.extraInfo = extraInfo;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
