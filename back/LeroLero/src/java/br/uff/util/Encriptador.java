package br.uff.util;

import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.commons.codec.binary.Base64;

public class Encriptador {

    private static final String FORMATO = "UTF8";
    public static final String SCHEMA_ENCRIPTADOR = "DESede";
    private static final String CHAVE = "N1ngu3mV4iDesc0br1rNunC4";
    private KeySpec ks;
    private SecretKeyFactory skf;
    byte[] arrayBytes;
    
    SecretKey key;

    public String encripta(String senha) {
        String senhaEncriptada = null;
        
        try {
            arrayBytes = CHAVE.getBytes(FORMATO);
            ks = new DESedeKeySpec(arrayBytes);
            skf = SecretKeyFactory.getInstance(SCHEMA_ENCRIPTADOR);
            Cipher cipher = Cipher.getInstance(SCHEMA_ENCRIPTADOR);
            key = skf.generateSecret(ks);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] texto = senha.getBytes(FORMATO);
            byte[] textoEncriptado = cipher.doFinal(texto);
            senhaEncriptada = new String(Base64.encodeBase64(textoEncriptado));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return senhaEncriptada;
    }


    public String desencripta(String senhaEncriptada) {
        String senhaReal = null;
        try {
            arrayBytes = CHAVE.getBytes(FORMATO);
            ks = new DESedeKeySpec(arrayBytes);
            skf = SecretKeyFactory.getInstance(SCHEMA_ENCRIPTADOR);
            Cipher cipher = Cipher.getInstance(SCHEMA_ENCRIPTADOR);
            key = skf.generateSecret(ks);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] textoEncriptado = Base64.decodeBase64(senhaEncriptada);
            byte[] texto = cipher.doFinal(textoEncriptado);
            senhaReal = new String(texto);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return senhaReal;
    }
}