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
		
		try {
		
		File fl	=  new File("./" + "viewer" + ".html");
		
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
		
		String rival_Name = resultBean.getRival_Name();
		String rival_Rate = resultBean.getRival_Rate();
		String rival_Show_1 = resultBean.getRival_Show_1();
		String rival_Show_2 = resultBean.getRival_Show_2();
		String rival_Show_3 = resultBean.getRival_Show_3();
		String rival_Show_4 = resultBean.getRival_Show_4();
		String rival_Show_5 = resultBean.getRival_Show_5();
		String rival_Show_6 = resultBean.getRival_Show_6();
		String elect_Me_1 = resultBean.getElect_Me_1();
		String elect_Me_2 = resultBean.getElect_Me_2();
		String elect_Me_3 = resultBean.getElect_Me_3();
		String elect_Rival_1 = resultBean.getElect_Rival_1();
		String elect_Rival_2 = resultBean.getElect_Rival_2();
		String elect_Rival_3 = resultBean.getElect_Rival_3();
//		String elect_Me_4 = resultBean.getElect_Me_4();
//		String elect_Rival_4 = resultBean.getElect_Rival_4();
		String res = util.ConvertResult(resultBean.getResult());
//		String battle_Type = resultBean.getBattle_Type();

		String template = "<!doctype html>" + crlf
						+ "<html>" + crlf
						+ "<head>" + crlf
						+ "<meta charset=" + Const.ENCODE + ">" + crlf
						+ "<meta name=" + "viewport" + "content=" + "width=device-width, initial-scale=1.0, user-scalable=yes" + ">" + crlf
						+ "<title>2013/08/31(土)21:48</title>" + crlf
						+ "</head>" + crlf
						+ "<body>" + crlf
						+ "<h3>相手見せ合い</h3>" + crlf
						+ "<table border=1 cellpadding=3 hspace=10 vspace=10>" + crlf
	    				+ 	"<tr>" + crlf
    					+ 		"<td>相手名</td>" + crlf
					    + 		"<td>" + rival_Name + "</td>" + crlf
        				+ 		"<td><br></td>" + crlf
    					+ 	"</tr>" + crlf
    					+ 	"<tr>" + crlf
        				+ 		"<td>相手レート</td>" + crlf
        				+ 		"<td>" + rival_Rate  + "</td>" + crlf
        				+ 		"<td><br></td>" + crlf
    					+ 	"</tr>" + crlf
    					+	"<tr>" + crlf
            			+ 		"<td>相手1</td>" + crlf
            			+ 		"<td>" + rival_Show_1 + "</td>" + crlf
    					+       "<td><img src=" + imageLoad.Load(rival_Show_1) + "></td>" + crlf
       					+ 	"</tr>" + crlf
       					+  	"<tr>" + crlf
      					+       "<td>相手2</td>" + crlf
            			+  		"<td>" + rival_Show_2 + "</td>" + crlf
    					+       "<td><img src=" + imageLoad.Load(rival_Show_2) + "></td>" + crlf
      					+   "</tr>" + crlf
      					+   "<tr>" + crlf
      					+       "<td>相手3</td>" + crlf
            			+  		"<td>" + rival_Show_3 + "</td>" + crlf
    					+       "<td><img src=" + imageLoad.Load(rival_Show_3) + "></td>" + crlf
      					+    "</tr>" + crlf
     					+    "<tr>" + crlf
      					+       "<td>相手4</td>" + crlf
            			+  		"<td>" + rival_Show_4 + "</td>" + crlf
    					+       "<td><img src=" + imageLoad.Load(rival_Show_4) + "></td>" + crlf
     					+    "</tr>" + crlf
     					+    "<tr>" + crlf
      					+       "<td>相手5</td>" + crlf
            			+  		"<td>" + rival_Show_5 + "</td>" + crlf
    					+       "<td><img src=" + imageLoad.Load(rival_Show_5) + "></td>" + crlf
    					+    "</tr>" + crlf
     					+    "<tr>" + crlf
      					+       "<td>相手6</td>" + crlf
            			+  		"<td>" + rival_Show_6 + "</td>" + crlf
    					+       "<td><img src=" + imageLoad.Load(rival_Show_6) + "></td>" + crlf

    					+    "</tr>" + crlf
    					+ "</table>" + crlf
    					+ "<br>" + crlf
    					+ "<br>" + crlf
    					+ "<table border=1 cellpadding=5 hspace=10 vspace=10>" + crlf
    					+    "<tr>" + crlf
    					+        "<td><img src=" + imageLoad.Load(rival_Show_1) + "></td>" + crlf
    					+        "<td><img src=" + imageLoad.Load(rival_Show_2) + "></td>" + crlf
    					+    "</tr>" + crlf
    					+    "<tr>" + crlf
    					+        "<td><img src=" + imageLoad.Load(rival_Show_3) + "></td>" + crlf
    					+        "<td><img src=" + imageLoad.Load(rival_Show_4) + "></td>" + crlf
    					+    "</tr>" + crlf
     					+    "<tr>" + crlf
    					+        "<td><img src=" + imageLoad.Load(rival_Show_5) + "></td>" + crlf
    					+        "<td><img src=" + imageLoad.Load(rival_Show_6) + "></td>" + crlf
     					+    "</tr>" + crlf
    					+ "</table>" + crlf
    					+ "</td>" + crlf
    					+ "<br>" + crlf
    					+ "<br>" + crlf
    					+ "<h3>選出</h3>" + crlf
    					+ "<table border=1 cellpadding=5 hspace=10 vspace=10>" + crlf
    					+    "<td>" + crlf
    					+        "<table border=0 >" + crlf
    					+            "<tr>" + crlf
    					+        		"<td><img src=" + imageLoad.Load(elect_Me_1) + "></td>" + crlf
    					+        		"<td><img src=" + imageLoad.Load(elect_Me_2) + "></td>" + crlf
    					+        		"<td><img src=" + imageLoad.Load(elect_Me_3) + "></td>" + crlf
    					+             "</tr>" + crlf
    					+         "</table>" + crlf
    					+         "<h3 align=center>vs.</h3>" + crlf
    					+         "<table border=0 >" + crlf
    					+             "<tr>" + crlf
    					+        		"<td><img src=" + imageLoad.Load(elect_Rival_1) + "></td>" + crlf
    					+        		"<td><img src=" + imageLoad.Load(elect_Rival_2) + "></td>" + crlf
    					+        		"<td><img src=" + imageLoad.Load(elect_Rival_3) + "></td>" + crlf
    					+             "</tr>" + crlf
    					+         "</table>" + crlf
    					+     "</td>" + crlf
    					+ "</table>" + crlf
    					+ "<br>" + crlf
    					+ "<h3>" + res + "</h3>" + crlf
    					+ "</body>" + crlf
    					+ "</html>" + crlf;
				
		return template;
		
	}
	
}
