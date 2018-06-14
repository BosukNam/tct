package com.util.encDec;

import java.beans.Encoder;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;

public class EncDecription {

	public static void main(String[] args) {
		try {
			SHA256("1234");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public static void SHA256(String input) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xFF) + 0x100, 16).substring(1));
		}

		System.out.println(sb.toString());
		// Ex) ‘1234’ ->
		// ‘03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4’
	}

	/*
	public static void Base64Sample(String testString) throws UnsupportedEncodingException {

		Encoder encoder = Base64.getEncoder(); // 현재 컴퓨터에서는 지원 안됨
		String encodedString = encoder.encodeToString(testString.getBytes("UTF-8"));
		System.out.println(encodedString);

		Decoder decoder = Base64.getDecoder();
		byte[] decodedBytes = decoder.decode(encodedString);
		String decodedString = new String(decodedBytes, "UTF-8");

		System.out.println(decodedString);
		// 입력 : This is a Base64 test.
		// 출력 : VGhpcyBpcyBhIEJhc2U2NCB0ZXN0Lg==
	}
	*/
}
