package com.Erycton.Gorilla;

import com.Erycton.Util.*;

public class ImageLoad {

	public String Load (String pkmn_name) {
		
		String img_path = null; // 返り値
		Reader reader = new Reader();
		Integer pkmn_num = null; // 番号 
		String import_path = null;
		
		// 引数に対応した番号のファイル名を取得.
		pkmn_num = Get_Number(pkmn_name);
		
		import_path = reader.propReader(Const.POKEMON_IMAGE_PATH);
				
		// 番号ファイルのパスを作成.
		img_path = import_path + pkmn_num + Const.FILE_PNG;
		
		return img_path;
		
	}
	
	protected Integer Get_Number(String name){
		Integer i = 0;
		Reader reader = new Reader();
		String ary_pkmn[] = reader.txtReader();
		
		// 対象ポケモン名がpokemon_name.txtに存在するか確認
		for (String t:ary_pkmn){
			if (name.equals(t)){
				break;
			}
			i++;
		}	
		
		return i + 1;
	}
	
}
