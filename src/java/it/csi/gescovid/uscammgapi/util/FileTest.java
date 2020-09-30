package it.csi.gescovid.uscammgapi.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Pattern;

import javax.xml.bind.DatatypeConverter;

public class FileTest {

	public static void main(String[] args) {
		//String inputbase64 = "data:text/html;base64,PGh0bWw+DQogIDxoZWFkPg0KICAgIDx0aXRsZT5QYWdpbmEgZGkgUmVkaXJlY3Q8L3RpdGxlPg0KICAgIDxsaW5rIHJlbD0ibWFuaWZlc3QiIGhyZWY9Im1hbmlmZXN0Lmpzb24iIC8+DQogICAgPG1ldGEgaHR0cC1lcXVpdj0icmVmcmVzaCIgY29udGVudD0iMTtVUkw9Li9ob21lIiAvPg0KICA8L2hlYWQ+DQogIDxib2R5Pg0KICAgIDxwPg0KICAgICAgUmVkaXJlY3QNCiAgICA8L3A+DQogIDwvYm9keT4NCjwvaHRtbD4NCg==";

		//String datatype = inputbase64.substring(inputbase64.indexOf(":")+1,inputbase64.indexOf(";"));
		//System.out.println("datatype::"+datatype);
		
		
		//String base64String = "data:text/html;base64,PGh0bWw+DQogIDxoZWFkPg0KICAgIDx0aXRsZT5QYWdpbmEgZGkgUmVkaXJlY3Q8L3RpdGxlPg0KICAgIDxsaW5rIHJlbD0ibWFuaWZlc3QiIGhyZWY9Im1hbmlmZXN0Lmpzb24iIC8+DQogICAgPG1ldGEgaHR0cC1lcXVpdj0icmVmcmVzaCIgY29udGVudD0iMTtVUkw9Li9ob21lIiAvPg0KICA8L2hlYWQ+DQogIDxib2R5Pg0KICAgIDxwPg0KICAgICAgUmVkaXJlY3QNCiAgICA8L3A+DQogIDwvYm9keT4NCjwvaHRtbD4NCg==";
		//String[] strings = base64String.split(",");
				
		//String tipoFile = strings[0];
		
		//String mynetype = tipoFile.substring(tipoFile.indexOf(":")+1, tipoFile.indexOf(";"));
		//System.out.println("datatype::"+mynetype);
		
		
		String mineType = "d";
		
		if(mineType == null || mineType.isEmpty() || !mineType.contains("/")) {
			
			// desumo il minetype
			String filename = "pippo.d";
			System.out.println("filename: " +filename);
			
			String extension = "";
			
			String[] sub = filename.split(Pattern.quote("."));
			System.out.println("length: " +sub.length);
			
			if(sub.length  == 2) {
				extension = sub[1];
			}else {
				// sono nel caso in cui ho nel nome file un '.'
				int index = sub.length;
				extension = sub[index-1];
			}
			System.out.println("extension: " +extension);
			
			boolean isMineTypeText = extension.equalsIgnoreCase("txt") || extension.equalsIgnoreCase("html") || extension.equalsIgnoreCase("csv") || extension.equalsIgnoreCase("csv");
			boolean isMineTypeImage = extension.equalsIgnoreCase("gif") || 
											extension.equalsIgnoreCase("jpeg") || 
													extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("tiff") || extension.contains("icon");

			boolean isMineTypeApplication = extension.equalsIgnoreCase("pdf") || extension.contains("xls") || extension.contains("doc");
			if(isMineTypeText) mineType = "text/";
			if(isMineTypeImage) mineType = "image/";
			if(isMineTypeApplication) mineType = "application/";
			
			System.out.println("mineType: " + mineType);
			
		}
		
//		
//		String base64String = "data:text/html;base64,PGh0bWw+DQogIDxoZWFkPg0KICAgIDx0aXRsZT5QYWdpbmEgZGkgUmVkaXJlY3Q8L3RpdGxlPg0KICAgIDxsaW5rIHJlbD0ibWFuaWZlc3QiIGhyZWY9Im1hbmlmZXN0Lmpzb24iIC8+DQogICAgPG1ldGEgaHR0cC1lcXVpdj0icmVmcmVzaCIgY29udGVudD0iMTtVUkw9Li9ob21lIiAvPg0KICA8L2hlYWQ+DQogIDxib2R5Pg0KICAgIDxwPg0KICAgICAgUmVkaXJlY3QNCiAgICA8L3A+DQogIDwvYm9keT4NCjwvaHRtbD4NCg==";
//        String[] strings = base64String.split(",");
//        String extension;
//        switch (strings[0]) {//check image's extension
//            case "data:text/html;base64":
//                extension = "html";
//                break;
//            case "data:application/pdf;base64":
//                extension = "pdf";
//                break;
//            default://should write cases for more images types
//                extension = "jpg";
//                break;
//        }
//        //convert base64 string to binary data
//        byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
//        String path = "D:\\ProgettiEclipse\\sanita\\covid\\test_file." + extension;
//        File file = new File(path);
//        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
//            outputStream.write(data);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
		
		
	}

}
