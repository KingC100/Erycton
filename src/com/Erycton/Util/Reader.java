package com.Erycton.Util;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Properties;

public class Reader {

	/***
	 * ポケモン名取得(通常, フォルムチェンジ)
	 * @param type - 戦闘種別
	 * @return name - ポケモン名(配列)
	 */
	public String[] txtReader(String type) {
		//    FileReader stream = null;
		String name[] = null;
		String line;

		try {

			// Propertiesファイルから読み込み.
    		LineNumberReader lnr = null;
    		FileInputStream fis = new FileInputStream(propReader(type));
    		InputStreamReader in = new InputStreamReader(fis, Const.ENCODE);
    		
    		// LineNumberReaderオブジェクト作成.
    		lnr = new LineNumberReader(in);

    		// ファイル(pokemon_name.txt)からポケモン名の取得.
      		while ((line = lnr.readLine()) != null) {
      			line.toString();
      			name = line.split(",");
      			}
      		
      		// close.
      		fis.close();
      		lnr.close();
  			
    		} catch (IOException e) {
    			e.printStackTrace();
      		} catch (Exception e) {
    			e.printStackTrace();
      		}
    	
	return name;
	}

	/***
	 * プロパティファイルから情報を取得.
	 * @param prop_Name - 取得するプロパティファイル名
	 * @return path - 
	 */
	public String propReader(String prop_Name) {
		
		Properties prop = new Properties();
		String content =  null;

		try {
			
			// InputStreamオブジェクト作成.
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(Const.PROPERTIES_PATH), Const.ENCODE));

			// 読み込み.
			prop.load(bf);

			// 対象パス情報を取得.
			content = (prop.getProperty(prop_Name));
			
			bf.close();
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	return content;
	}
}