package com.Erycton.Util;import java.text.SimpleDateFormat;import java.util.Date;import com.Erycton.Data.ResultBean;public class Util {		/***	 * 改行コードを取得.	 * @return - 改行コード	 */	public static String GetSeparator(){				String crlf = System.getProperty("line.separator");				return crlf;	}	/***	 * 対戦結果変換(Boolean <--> String)	 * @param resultBean	 * @return	 */	public String ConvertResult(ResultBean resultBean){				String res = null;				switch(resultBean.getResult()){			case 0: res = Const.WIN;	 break;			case 1: res = Const.LOSE;	 break;			case 2: res = Const.CUT; 	 break;		}		return res;	}		/***	 * 日付の項目を取得	 * @param str[] - 取得する項目名	 * @return  res - 日時等	 */	public String[] getDate(){				// 現在時刻でDateオブジェクト作成.		Date now = new Date(System.currentTimeMillis());		// 年/月/日/時/分/秒/曜日のフォーマット作成.		SimpleDateFormat sdf_now = new SimpleDateFormat(Const.df);		// Date → フォーマットに嵌める → toString() → "/"でsplitして格納. 		String[] str_now = ((sdf_now.format(now)).toString().split("/"));	    		return str_now;	}		// nullチェック	public boolean isNull(String str) {		boolean bl = false;		if (str.equals(null) || str == null || str.equals(Const.strnull) || str.equals(Const.str_null)){			bl = false;		} else {			bl = true;		}				return bl;	}	// 数値チェック	public static boolean isNumric(String str) {		boolean bl = false;		char chr = Const.zero;		for (int i = 0; i < str.length(); i++) {			chr = str.charAt(i);			if (chr < Const.zero || chr > Const.nine) {				return bl;			}else{				bl = true;			}		}		return bl;	}	// 数値範囲チェック	public boolean isRange(Integer num, Integer rng_sml, Integer rng_big) {		boolean bl = false;		if ( rng_big >= num && num >= rng_sml) {			bl = true;		}else{			bl = false;		}		return bl;	}	// 対戦結果チェック	public Integer isResult(boolean win, boolean lose, boolean cut) {		// 0 - win		// 1 - lose		// 2 - cut		Integer num = 2;		if ( win == true				&& lose == false				&& cut  == false ){			num =  0;		} else if ( lose == true				&& win   == false				&& cut   == false ){			num =  1;		} else {			num =  2;		}		return num;	}}