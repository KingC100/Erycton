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
			String[] dt = util.getDate();
			String year	 = dt[0];
			String month  = dt[1];
			String day	 	 = dt[2];
			String dow		 = dt[3];
			String hour 	 = dt[4];
			String minute = dt[5];
			String second	 = dt[6];

			// 出力ファイル名作成.
			file_Name = year + month + day + Const.FILE_TXT;

			// Beanに年月日を投げる.	    
			resultBean.setEntry_Time(year + Const.NEN + month + Const.GETSU + day + Const.HI + "(" + dow + ")" + " " + hour + ":" + minute + ":" + second);
			
			// ディレクトリパス取得.
			String dir_path	= Const.EXPORT_PATH + battle_Type;
			File dir				= new File(dir_path);
			File fl					=  new File(dir_path + File.separator + file_Name);
			
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
			OutputStreamWriter osw = new OutputStreamWriter(fos, Const.ENCODE); // UTF-8.
			// 書き込み.
			osw.write(Create_Sentence(orFirst, resultBean, type));
			// 出力して閉じる.
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

	/***
	 * 出力内容の作成.
	 * @param orFirst - ファイルが既存か
	 * @param resultBean - 入力内容
	 * @param type - 対戦種別
	 * @return
	 */
	public String Create_Sentence(boolean orFirst, ResultBean resultBean, Boolean type){
		
		Util util = new Util();
		Reader reader = new Reader();
		String sps = reader.propReader(Const.EXPORT_PARTITION) + Const.str_null; // Const.TAB
		String bar = reader.propReader(Const.EXPORT_PARTITION_BAR);
		String str   = null;
		StringBuffer sb = new StringBuffer();
		
		// 改行文字の取得.
		String crlf = Util.GetSeparator();

		// 同名ファイルが存在しない場合テンプレートを追加.
		if(!(orFirst)){
			if(type){
				sb.append(Const.TOP_ITEMNAME_DOUBLE + crlf);
			}else{
				sb.append(Const.TOP_ITEMNAME_SINGLE + crlf);
			}
			sb.append(bar + crlf);
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
		
		// 自分選出4枠目.
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

		// 相手選出4枠目.
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

}