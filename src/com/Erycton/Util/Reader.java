package com.Erycton.Util;
//import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Properties;

public class Reader {

public String[] txtReader() {
    FileReader stream = null;
    LineNumberReader lnr = null;
    String name[] = null;
    String line;

    try {
    		// Propertiesファイルから読み込み.
    		stream = new FileReader(propReader(Const.POKEMONNAME));
    		
    		// LineNumberReaderオブジェクト作成.
    		lnr = new LineNumberReader(stream);

    		// ファイル(pokemon_name.txt)からポケモン名の取得.
      		while ((line = lnr.readLine()) != null) {
      			line.toString();
      			name = line.split(",");
      			}
      		
      		// close.
  			stream.close();
  			return name;
  			
    		} catch (IOException e) {
    			e.printStackTrace();
      		} catch (Exception e) {
    			e.printStackTrace();
      		}
    	
	return name;
	}

// Propertiesファイルの読み込み.
public String propReader(String prop_Name) {
	Properties configuration = new Properties();
	String path =  null;	// 対象ファイルのパス
	try {
			// InputStreamオブジェクト作成.
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(Const.PROPERTIES_PATH), "UTF-8"));

			// 読み込み.
			configuration.load(in);

			// 対象パス情報を取得.
			path = (configuration.getProperty(prop_Name));
			
			in.close();
			
			return path;
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	return path;
	}
}