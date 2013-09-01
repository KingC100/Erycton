package com.Erycton.Gorilla;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.Erycton.Data.ResultBean;
import com.Erycton.Util.Const;
import com.Erycton.Util.Util;

public class ViewerCreater {
	
	public Boolean HTMLExport(ResultBean resultBean){
		
		Boolean bl = false;
		Util util = new Util();
		String battle_Type = null;
		
		try {
			
		boolean type = util.str_bl(resultBean.getBattle_Type());
		
		if(type){
			battle_Type = Const.DOUBLE;
		}else{
			battle_Type = Const.SINGLE;
		}
		
		// 日付取得.
		String[] dt = util.getDate();
		String year	  = dt[0];
		String month  = dt[1];
		String day	  = dt[2];

		// 出力ファイル名作成.
		String file_Name = year + month + day + Const.FILE_HTML;
				
		// ディレクトリパス取得.
		String dir_path	= Const.EXPORT_PATH + battle_Type + Const.EXPORT_HTML_PATH;
		File dir				= new File(dir_path);
		File fl					= new File(dir_path + File.separator + file_Name);
		
		dir.mkdir();
				
		FileOutputStream fos = new FileOutputStream(fl,true);
		OutputStreamWriter osw = new OutputStreamWriter(fos, Const.ENCODE); // UTF-8.
		
		// 書き込み.
		osw.write(HTMLWrite(resultBean));
		// 出力して閉じる.
		osw.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return bl;
	}

	protected String HTMLWrite(ResultBean resultBean){
		
		Util util = new Util();
		ImageLoad imageLoad = new ImageLoad();
		
		// 改行文字の取得.
		String crlf = util.GetSeparator();
		
		String rival_Name 	 = resultBean.getRival_Name();
		String rival_Rate 	 = resultBean.getRival_Rate();
		String rival_Show_1  = resultBean.getRival_Show_1();
		String rival_Show_2  = resultBean.getRival_Show_2();
		String rival_Show_3  = resultBean.getRival_Show_3();
		String rival_Show_4  = resultBean.getRival_Show_4();
		String rival_Show_5  = resultBean.getRival_Show_5();
		String rival_Show_6  = resultBean.getRival_Show_6();
		String elect_Me_1 	 = resultBean.getElect_Me_1();
		String elect_Me_2	 = resultBean.getElect_Me_2();
		String elect_Me_3 	 = resultBean.getElect_Me_3();
		String elect_Rival_1 = resultBean.getElect_Rival_1();
		String elect_Rival_2 = resultBean.getElect_Rival_2();
		String elect_Rival_3 = resultBean.getElect_Rival_3();
		String time			 = resultBean.getEntry_Time();
		String elect_Me_4 	 = resultBean.getElect_Me_4();
		String elect_Rival_4 = resultBean.getElect_Rival_4();
		String res			 = util.ConvertResult(resultBean.getResult());
		boolean battle_Type	 = util.str_bl(resultBean.getBattle_Type()); 
		
		// ダブルバトル時の処理.
		String me_4	   = Const.str_null;
		String rival_4 = Const.str_null;
		
		if(battle_Type){
			me_4		= " <td><img src=" + Const.IMG_PATH_EXT + imageLoad.GetImage(elect_Me_4) + "></td> " + crlf;
			rival_4 	= " <td><img src=" + Const.IMG_PATH_EXT + imageLoad.GetImage(elect_Rival_4) + "></td> " + crlf;
		}
		
		// html本文作成.
		String template = "<!doctype html>" + crlf
						+ "<html>" + crlf
						+ "<head>" + crlf
						+ "<meta charset=" + Const.ENCODE + ">" + crlf
						+ "<meta name=" + "viewport" + "content=" + "width=device-width, initial-scale=1.0, user-scalable=yes" + ">" + crlf
						+ "<title>" + resultBean.getHtml_FileName() + "</title>" + crlf
						+ "</head>" + crlf
						+ "<body>" + crlf
						+ "<table border=2 cellpadding=3 hspace=10 vspace=10 width=650>" + crlf
						+ "<td>" + crlf
						+ "<table border=2 cellpadding=3 hspace=10 vspace=10>" + crlf
	    				+ 	"<tr>" + crlf
    					+ 		"<td>相手名</td>" + crlf
					    + 		"<td>" + rival_Name + "</td>" + crlf
    					+ 	"</tr>" + crlf
    					+ 	"<tr>" + crlf
        				+ 		"<td>相手レート</td>" + crlf
        				+ 		"<td>" + rival_Rate  + "</td>" + crlf
    					+ 	"</tr>" + crlf
    					+	"<tr>" + crlf
            			+ 		"<td>相手1</td>" + crlf
            			+ 		"<td>" + rival_Show_1 + "</td>" + crlf
       					+ 	"</tr>" + crlf
       					+  	"<tr>" + crlf
      					+       "<td>相手2</td>" + crlf
            			+  		"<td>" + rival_Show_2 + "</td>" + crlf
      					+   "</tr>" + crlf
      					+   "<tr>" + crlf
      					+       "<td>相手3</td>" + crlf
            			+  		"<td>" + rival_Show_3 + "</td>" + crlf
      					+    "</tr>" + crlf
     					+    "<tr>" + crlf
      					+       "<td>相手4</td>" + crlf
            			+  		"<td>" + rival_Show_4 + "</td>" + crlf
     					+    "</tr>" + crlf
     					+    "<tr>" + crlf
      					+       "<td>相手5</td>" + crlf
            			+  		"<td>" + rival_Show_5 + "</td>" + crlf
    					+    "</tr>" + crlf
     					+    "<tr>" + crlf
      					+       "<td>相手6</td>" + crlf
            			+  		"<td>" + rival_Show_6 + "</td>" + crlf
    					+    "</tr>" + crlf
    					+ "</table>" + crlf
    					+ "</td>" + crlf
    					+ "<td>" + crlf
    					+ "<table border=2 cellpadding=5 hspace=10 vspace=10>" + crlf
    					+    "<tr>" + crlf
    					+        "<td><img src=" + Const.IMG_PATH_EXT + imageLoad.GetImage(rival_Show_1) + "></td>" + crlf
    					+        "<td><img src=" + Const.IMG_PATH_EXT + imageLoad.GetImage(rival_Show_2) + "></td>" + crlf
    					+    "</tr>" + crlf
    					+    "<tr>" + crlf
    					+        "<td><img src=" + Const.IMG_PATH_EXT + imageLoad.GetImage(rival_Show_3) + "></td>" + crlf
    					+        "<td><img src=" + Const.IMG_PATH_EXT + imageLoad.GetImage(rival_Show_4) + "></td>" + crlf
    					+    "</tr>" + crlf
     					+    "<tr>" + crlf
    					+        "<td><img src=" + Const.IMG_PATH_EXT + imageLoad.GetImage(rival_Show_5) + "></td>" + crlf
    					+        "<td><img src=" + Const.IMG_PATH_EXT + imageLoad.GetImage(rival_Show_6) + "></td>" + crlf
     					+    "</tr>" + crlf
    					+ "</table>" + crlf
    					+ "</td>" + crlf
    					+ "<td>" + crlf
    					+ "<table border=2 cellpadding=5 hspace=10 vspace=10>" + crlf
    					+    "<td>" + crlf
    					+        "<table border=0 >" + crlf
    					+            "<tr>" + crlf
    					+        		"<td><img src=" + Const.IMG_PATH_EXT + imageLoad.GetImage(elect_Rival_1) + "></td>" + crlf
    					+        		"<td><img src=" + Const.IMG_PATH_EXT + imageLoad.GetImage(elect_Rival_2) + "></td>" + crlf
    					+        		"<td><img src=" + Const.IMG_PATH_EXT + imageLoad.GetImage(elect_Rival_3) + "></td>" + crlf
    					+				me_4 // 4枠目
    					+             "</tr>" + crlf
    					+         "</table>" + crlf
    					+         "<h3 align=center>vs.</h3>" + crlf
    					+         "<table border=0 >" + crlf
    					+             "<tr>" + crlf
    					+        		"<td><img src=" + Const.IMG_PATH_EXT + imageLoad.GetImage(elect_Me_1) + "></td>" + crlf
    					+        		"<td><img src=" + Const.IMG_PATH_EXT + imageLoad.GetImage(elect_Me_2) + "></td>" + crlf
    					+        		"<td><img src=" + Const.IMG_PATH_EXT + imageLoad.GetImage(elect_Me_3) + "></td>" + crlf
    					+				rival_4 // 4枠目
    					+             "</tr>" + crlf
    					+         "</table>" + crlf
    					+     "</td>" +crlf
    					+	  "<td>" + crlf
    					+	  	"<h3 align=center>" + crlf
    					+		res + crlf
    					+		"</h3" + crlf
    					+	  "</td>" + crlf
    					+ "</table>" + crlf
    					+ "</td>" + crlf
						+ "<h3>" + time + "</h3>" + crlf
    					+ "</body>" + crlf
    					+ "</html>" + crlf;
				
		return template;	
	}
}
