package br.uff.servlets;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public final class EncriptaSenha {

    public String novaSenha(String senha) {
        MessageDigest md = null;
        
        try {
            md = MessageDigest.getInstance("SHA-256");
	} catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
	
        try {
            md.update(senha.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
	}

	byte raw[] = md.digest();
	String hash = DatatypeConverter.printHexBinary(raw).toUpperCase();
	return hash;
    }
}
