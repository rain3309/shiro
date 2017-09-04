package com.rain.shiro.core.security;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;

import com.rain.shiro.common.exception.Exceptions;

public class Encodes {
	
	/**
	 * Hex编码
	 * @param bytes
	 * @return
	 */
	public static String encodeHex(byte[] bytes) {
		return Hex.encodeHexString(bytes);
	}
	
	/**
	 * Hex解码
	 * @param input
	 * @return
	 */
	public static byte[] decodeHex(String input) {
		try {
			return Hex.decodeHex(input.toCharArray());
		} catch (DecoderException e) {
			throw Exceptions.unchecked(e);
		}
	} 
	
	/**
	 * Base64编码
	 * @param args
	 */
	public static String encodeBase64(byte[] input) {
		return Base64.encodeBase64String(input);
	}
	/**
	 * Base64编码, URL安全(将Base64中的URL非法字符'+'和'/'转为'-'和'_', 见RFC3548).
	 */
	public static String encodeUrlSafeBase64(byte[] input) {
		return Base64.encodeBase64URLSafeString(input);
	}
	
	/**
	 * Base64解码
	 * @param args
	 */
	public static byte[] decodeBase64(String input) {
		return Base64.decodeBase64(input);
	}
	/**
	 * html转码
	 * @param html
	 * @return
	 */
	public static String escapeHtml(String html) {
		return StringEscapeUtils.escapeHtml4(html);
	}
	
	/**
	 * html解码
	 * @param escapeHtml
	 * @return
	 */
	public static String unescapeHtml(String escapeHtml) {
		return StringEscapeUtils.unescapeHtml4(escapeHtml);
	}
	
	public static void main(String[] args) {
		byte[] bb = new byte[8];
//		String input = encodeHex(bb);
//		byte[] bytes = decodeHex(input);
//		System.out.println(bytes);
//		byte[] bytes = decodeBase64("javase");
		String str = encodeBase64(bb);
		System.out.println(str);
	}

}
