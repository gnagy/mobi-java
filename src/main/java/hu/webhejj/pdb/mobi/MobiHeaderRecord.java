package hu.webhejj.pdb.mobi;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MobiHeaderRecord {

	public static enum Compression {
		NONE(1),
		PALMDOC(2),
		HUFF_CDIC(17480);
		
		private int value;
		private Compression(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
		public static Compression getEnum(int intValue) {
			for(Compression type: Compression.values()) {
				if(type.getValue() == intValue) {
					return type;
				}
			}
			throw new IllegalArgumentException("Unknown enum value " + intValue);
		}		
	}
	
	public static enum Encryption {
		NONE(0),
		OLD_MOBIPOCKET(1),
		MOBIPOCKET(2);
		
		private int value;
		private Encryption(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
		public static Encryption getEnum(int intValue) {
			for(Encryption type: Encryption.values()) {
				if(type.getValue() == intValue) {
					return type;
				}
			}
			throw new IllegalArgumentException("Unknown enum value " + intValue);
		}		
	}
	
	public static enum MobiType {
		MOBIPOCKET_BOOK(2),
		PALMDOC_BOOK(3),
		AUDIO(4),
		NEWS(257),
		NEWS_FEED(258),
		NEWS_MAGAZINE(259),
		PICS(513),
		WORD(514),
		XLS(515),
		PPT(516),
		TEXT(517),
		HTML(518);	
		
		private int value;
		private MobiType(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
		public static MobiType getEnum(int intValue) {
			for(MobiType type: MobiType.values()) {
				if(type.getValue() == intValue) {
					return type;
				}
			}
			throw new IllegalArgumentException("Unknown enum value " + intValue);
		}
	}
	
	public static enum TextEncoding {
		CP1252(1252),
		UTF8(65001);
		
		private int value;
		private TextEncoding(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
		public static TextEncoding getEnum(int intValue) {
			for(TextEncoding type: TextEncoding.values()) {
				if(type.getValue() == intValue) {
					return type;
				}
			}
			throw new IllegalArgumentException("Unknown enum value " + intValue);
		}
		public Charset toCharset() {
			switch(this) {
			case UTF8: return Charset.forName("UTF-8");
			case CP1252: return Charset.forName("CP1252");
			}
			return null;
		}
	}	
	
	private Compression compresson;
	private int textLength;
	private int recordCount;
	private int recordSize;
	private Encryption encryption;
	private MobiType mobiType;
	private TextEncoding textEncoding;
	private long id;
	private long version;
	private long minVersion;
	private String fullName;
	
	private int firstNonBookIndex;
	private int firstImageIndex;
	
	private int locale;
	private int inputLanguage;
	private int outputLanguage;
	
	private int extraDataFlags;
	
	private List<ExtHeader> extHeaders = new ArrayList<ExtHeader>();
	
	public Compression getCompresson() {
		return compresson;
	}
	public void setCompresson(Compression compresson) {
		this.compresson = compresson;
	}
	public int getTextLength() {
		return textLength;
	}
	public void setTextLength(int textLenght) {
		this.textLength = textLenght;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getRecordSize() {
		return recordSize;
	}
	public void setRecordSize(int recordSize) {
		this.recordSize = recordSize;
	}
	public Encryption getEncryption() {
		return encryption;
	}
	public void setEncryption(Encryption encryption) {
		this.encryption = encryption;
	}
	public MobiType getMobiType() {
		return mobiType;
	}
	public void setMobiType(MobiType mobiType) {
		this.mobiType = mobiType;
	}
	public TextEncoding getTextEncoding() {
		return textEncoding;
	}
	public void setTextEncoding(TextEncoding textEncoding) {
		this.textEncoding = textEncoding;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public long getMinVersion() {
		return minVersion;
	}
	public void setMinVersion(long minVersion) {
		this.minVersion = minVersion;
	}
	public int getFirstNonBookIndex() {
		return firstNonBookIndex;
	}
	public void setFirstNonBookIndex(int firstNonBookIndex) {
		this.firstNonBookIndex = firstNonBookIndex;
	}
	public int getFirstImageIndex() {
		return firstImageIndex;
	}
	public void setFirstImageIndex(int firstImageIndex) {
		this.firstImageIndex = firstImageIndex;
	}
	public int getLocale() {
		return locale;
	}
	public void setLocale(int locale) {
		this.locale = locale;
	}
	public int getInputLanguage() {
		return inputLanguage;
	}
	public void setInputLanguage(int inputLanguage) {
		this.inputLanguage = inputLanguage;
	}
	public int getOutputLanguage() {
		return outputLanguage;
	}
	public void setOutputLanguage(int outputLanguage) {
		this.outputLanguage = outputLanguage;
	}
	public int getExtraDataFlags() {
		return extraDataFlags;
	}
	public void setExtraDataFlags(int extraDataFlags) {
		this.extraDataFlags = extraDataFlags;
	}
	public List<ExtHeader> getExtHeaders() {
		return extHeaders;
	}
	public void setExtHeaders(List<ExtHeader> extHeaders) {
		this.extHeaders = extHeaders;
	}
}
