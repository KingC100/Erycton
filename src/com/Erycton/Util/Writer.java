package com.Erycton.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.Erycton.Data.ResultBean;

public class Writer {
	public boolean Export(ResultBean resultBean, Boolean type){

	    boolean bl = false;
		try{

	    Util util = new Util();
	    boolean orFirst = false;	    
	    String file_Name, battle_Type;
	    if(type){
	    	battle_Type = Const.DOUBLE;
	    }else{
	    	battle_Type = Const.SINGLE;
	    }

	    // 日付取得.
	    String year   = util.getDate(Const.YEAR);
	    String month  = util.getDate(Const.MONTH);
	    String day	  = util.getDate(Const.DAY);
	    String hour	  = util.getDate(Const.HOUR);
	    String minute = util.getDate(Const.MINUTE);
	    String second = util.getDate(Const.SECOND);
	    String dow	  = util.getDate(Const.WEEK);

	    // 出力ファイル名作成.
	    file_Name = year + month + day + Const.FILE_TXT;

	    // Beanに年月日を投げる.	    
	    resultBean.setEntry_Time(year + Const.NEN + month + Const.GETSU + day + Const.HI + "(" + dow + ")" + " " + hour + ":" + minute + ":" + second);
	    // DB挿入時は"yyyy-MM-dd HH:mm:ss"
//	    resultBean.setEntry_Time(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second + "(" + dow + ")");

	    String dir_path = Const.EXPORT_PATH + battle_Type;
	    File dir		= new File(dir_path);
	    // ファイルオブジェクト作成.
	    File fl =  new File(dir_path + File.separator + file_Name);

	    // 既に同名ファイルが存在する場合は既存ファイルへ書き込み.
	    if(fl.exists()){
	    	orFirst = true;
	    }else{
	    	// ファイルが存在しない場合, フォルダが存在するか確認.
	    	if(dir.exists()){
	    		}else{
	    		// フォルダを再帰的に作成.
	    		dir.mkdirs();
	    	}
	    	// ファイル作成.
	    	fl.createNewFile();
	    }
	    
	    FileOutputStream fos = new FileOutputStream(fl,true);
	    OutputStreamWriter osw = new OutputStreamWriter(fos, Const.ENCODE);
	    osw.write(Create_Sentence(orFirst, resultBean, type));
	    osw.flush();
	    osw.close();

	    // 成功.
	    bl = true;
	    return bl;
		} catch(IOException e){
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
	    return bl;
	}

	// 書き込み文の作成.
	public String Create_Sentence(boolean orFirst, ResultBean resultBean, Boolean type){
		Util util = new Util();
		Reader reader = new Reader();
		String sps = reader.propReader(Const.EXPORT_PARTITION) + Const.str_null; // Const.TAB
		String bar = reader.propReader(Const.EXPORT_PARTITION_BAR);
		String str   = null;
		StringBuffer sb = new StringBuffer();
		// 改行文字の取得
		String crlf = Util.GetSeparator();

		// 同名ファイルが存在しない場合テンプレートを追加.
		if(orFirst){
		}else{
			if(type){
				sb.append(Const.TOP_ITEMNAME_DOUBLE + crlf);
			}else{
				sb.append(Const.TOP_ITEMNAME_SINGLE + crlf);
			}
			sb.append( bar + crlf);
		}

		// 入力データの書き込み.
		sb.append(resultBean.getRival_Name());
		sb.append( sps );
		sb.append(resultBean.getRival_Rate());
		sb.append( sps );

		sb.append(resultBean.getRival_Show_1());
		sb.append( sps );
		sb.append(resultBean.getRival_Show_2());
		sb.append( sps );
		sb.append(resultBean.getRival_Show_3());
		sb.append( sps );
		sb.append(resultBean.getRival_Show_4());
		sb.append( sps );
		sb.append(resultBean.getRival_Show_5());
		sb.append( sps );
		sb.append(resultBean.getRival_Show_6());
		sb.append( sps );

		sb.append(resultBean.getElect_Me_1());
		sb.append( sps );
		sb.append(resultBean.getElect_Me_2());
		sb.append( sps );
		sb.append(resultBean.getElect_Me_3());
		sb.append( sps );
		if(type){
			sb.append(resultBean.getElect_Me_4());
			sb.append( sps );
		}

		sb.append(resultBean.getElect_Rival_1());
		sb.append( sps );
		sb.append(resultBean.getElect_Rival_2());
		sb.append( sps );
		sb.append(resultBean.getElect_Rival_3());
		sb.append( sps );
		if(type){
			sb.append(resultBean.getElect_Rival_4());
			sb.append( sps );
		}

		sb.append(util.ConvertResult(resultBean));
		sb.append( sps );
		sb.append(resultBean.getEntry_Time());

		// 区切り線
		sb.append(crlf);
		sb.append( bar + crlf);


		str = sb.toString();

		return str;
	}
	
	// Propertiesファイルの読み込み.
	public Boolean propWriter(String prop_Name, Boolean prop_Content) {

		Boolean bl = false;
//		
//		try {
////				Properties prop = new Properties();
//				FileOutputStream fos = new FileOutputStream(Const.PROPERTIES_PATH);
//				
//				String res = null;
//				if (prop_Content){
//					res = Const.SINGLE;
//				}else{
//					res = Const.DOUBLE;
//				}
//				
//				PropertiesConfiguration config = new PropertiesConfiguration(Const.PROPERTIES_PATH);
//				config.addProperty(prop_Name, res);
//				config.save();
//				fos.close();
//				
//				bl = true;
//			
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (ConfigurationException e) {
//				e.printStackTrace();
//			}
		
		return bl;
		}

}