package testBase64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class Main {
    public static void main(String[] args) {
        System.out.println("============== Start Base 64 Encoding & Decoding ! ==================");
        String aString = "abc";

        System.out.print("Byte length of abc is ");
        System.out.println(aString.length());

        byte[] aStringBytes = aString.getBytes(StandardCharsets.UTF_8);

        StringBuilder sb = new StringBuilder();

        for (byte aStringByte : aStringBytes) {
            sb.append(String.format("%8s", Integer.toBinaryString(aStringByte))
                            .replaceAll(" ", "0"));
        }
        System.out.println("abc in Binary is ");
        System.out.println(sb);

        System.out.print("binary length of abc is ");
        System.out.println(sb.length());

        System.out.print("decimal index per 6 bit is ");
        for (int i = 0; i < sb.length(); i=i+6) {
            System.out.print(Integer.parseInt(sb.substring(i, i+6), 2) + " ");
        }
        System.out.println();

        Base64.Encoder encoder = Base64.getEncoder();
        String base64EncodedAString = encoder.encodeToString(aStringBytes);
        byte[] base64EncodedAStringBytes = encoder.encode(aStringBytes);

        System.out.print("Base64 Encoded abc is ");
        System.out.println(base64EncodedAString);

        System.out.print("Base64 Encoded abc length is ");
        System.out.println(base64EncodedAString.length());
        
        Base64.Decoder decoder = Base64.getDecoder();
        
        byte[] decodedAStringBytes = decoder.decode(base64EncodedAStringBytes);

        StringBuilder sb2 = new StringBuilder();

        for (byte aStringByte : decodedAStringBytes) {
            sb2.append(String.format("%8s", Integer.toBinaryString(aStringByte))
                            .replaceAll(" ", "0"));
        }

        System.out.println("Base64 Decoded abc in Binary is ");
        System.out.println(sb2);

        String decodedAString = new String(decodedAStringBytes, StandardCharsets.UTF_8);
        System.out.print("Base64 Decoded abc is ");
        System.out.println(decodedAString);

        System.out.println("============== End Base 64 Encoding & Decoding ! ==================");
    }
}
