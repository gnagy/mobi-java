package hu.webhejj.pdb.mobi;


public class LZ77 {

	
	  /**
	   * Decompress the given buffer using the LZ77-based PalmDoc compression
	   * algorithm.
	   *
	   * @param data a block of PalmDoc data to decompress.
	   * @param outputSize the length of the data array when decompressed.
	   * @return a byte array containing the uncompressed data.
	   */
	public static byte[] decompressLZ77Buffer(byte[] data, int offset, int length) {
		
		int outputSize = calculateLZ77BufferLength(data, offset, length);
		byte[] output = new byte[outputSize];
		int i = offset;
		int j = 0;

		while (i < length) {
			// Get the next compressed input byte
			int c = ((int) data[i++]) & 0x00FF;

			if (c >= 0x00C0) {
				// type C command (space + char)
				output[j++] = ' ';
				output[j++] = (byte) (c & 0x007F);
			} else if (c >= 0x0080) {
				// type B command (sliding window sequence)

				// Move this to high bits and read low bits
				c = (c << 8) | (((int) data[i++]) & 0x00FF);
				// 3 + low 3 bits (Beirne's 'n'+3)
				int windowLen = 3 + (c & 0x0007);
				// next 11 bits (Beirne's 'm')
				int windowDist = (c >> 3) & 0x07FF;
				int windowCopyFrom = j - windowDist;

				windowLen = Math.min(windowLen, outputSize - j);
				while (windowLen-- > 0)
					output[j++] = output[windowCopyFrom++];
			} else if (c >= 0x0009) {
				// self-representing, no command
				output[j++] = (byte) c;
			} else if (c >= 0x0001) {
				// type A command (next c chars are literal)
				c = Math.min(c, outputSize - j);
				while (c-- > 0)
					output[j++] = data[i++];
			} else {
				// c == 0, also self-representing
				output[j++] = (byte) c;
			}
		}

		return output;
	}

	  /**
	   * Calculate the decompressed length of the given buffer.  This is the same
	   * as decompressing the buffer, but without saving the data anywhere.  If
	   * the text of this PalmDoc is not compressed, there is no computation
	   * involved and the record length is the same as the buffer length.
	   *
	   * @param data a block of PalmDoc data to calculate the length of.
	   * @return the uncompressed length of the given data buffer.
	   */
	public static int calculateLZ77BufferLength(byte[] data, int offset, int length) {
		int i = offset;
		int len = 0;
		while (i < length) {
			// Get the next compressed input byte
			int c = ((int) data[i++]) & 0x00FF;

			if (c >= 0x00C0) {
				// type C command (space + char)
				len += 2;
			} else if (c >= 0x0080) {
				// type B command (sliding window sequence)

				// Move this to high bits and read low bits
				c = (c << 8) | (((int) data[i++]) & 0x00FF);
				// 3 + low 3 bits (Beirne's 'n'+3)
				len += 3 + (c & 0x0007);
			} else if (c >= 0x0009) {
				// self-representing, no command
				len++;
			} else if (c >= 0x0001) {
				// type A command (next c chars are literal)
				len += c;
				i += c;
			} else {
				// c == 0, also self-representing
				len++;
			}
		}

		return len;
	}
}
