package hu.webhejj.pdb.mobi;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public class ByteIO {

	public static String readNullTerminatedString(DataInputStream dis, Charset charset) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte b = 0;
		while((b = dis.readByte()) > 0) {
			baos.write(b);
		}
		return new String(baos.toString(charset.name()));
	}
	
	public static String readFixedLengthString(DataInputStream dis, int lenght, Charset charset) throws IOException {
		byte[] buf = new byte[lenght];
		for(int i = 0; i < lenght; i++) {
			buf[i] = dis.readByte();
		}
		return new String(buf, charset);
	}
	
	public static int readInt(byte[] buffer, int offset) {
        int ch1 = buffer[offset++];
        int ch2 = buffer[offset++];
        int ch3 = buffer[offset++];
        int ch4 = buffer[offset++];
        return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));
	}
	
	public static void writeFile(String path, byte[] bytes) throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		fos.write(bytes);
		fos.close();
	}
	
	public static void writeFile(String path, String string, Charset charset) throws IOException {
		Writer writer = new OutputStreamWriter(new FileOutputStream(path), charset);
		writer.write(string);
		writer.close();
	}
}
