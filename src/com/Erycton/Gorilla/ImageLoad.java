package com.Erycton.Gorilla;

import java.io.File;

import javax.swing.ImageIcon;

import com.Erycton.Util.*;

public class ImageLoad {

	public String Load (String pkmn_name) {
		
		Reader reader = new Reader();
		String img_path = null; // 返り値
		Integer pkmn_num = null; // 番号 
		String import_path = null;
		
		// 引数に対応した番号のファイル名を取得.
		pkmn_num = Get_Number(pkmn_name, Const.POKEMONNAME_NORMAL);
		
		import_path = reader.propReader(Const.POKEMON_IMAGE_PATH);
				
		// 番号ファイルのパスを作成.
		img_path = import_path + pkmn_num + Const.FILE_PNG;
		
		return img_path;
		
	}
	
	protected Integer Get_Number(String name, String type){
		Integer i = 0;
		Reader reader = new Reader();
		String ary_pkmn[] = reader.txtReader(type);
		
		// 対象ポケモン名がpokemon_name.txtに存在するか確認
		for (String t:ary_pkmn){
			if (name.equals(t)){
				break;
			}
			i++;
		}	
		
//		if (name.equals(Const.HATENA)){
//			return 0;
//		}
		
		return i + 1;
	}
	
	public ImageIcon GetImage(String txt){
		
		ImageLoad imageLoad 	= new ImageLoad();
		String frm_chg = FormeChange(txt);
		ImageIcon icn = null;
		
		
		if (frm_chg.equals(Const.NOT_FIND)){
			icn	= new ImageIcon(imageLoad.Load(txt));
		}else{
			icn	= new ImageIcon(frm_chg);
		}
		
		Integer hatena_normal = Get_Number(txt, Const.POKEMONNAME_NORMAL);
		Integer hatena_forme = Get_Number(txt, Const.POKEMONNAME_FORME);
		if(hatena_normal >= Const.NUMBERMAX_NORMAL
				&& hatena_forme >= Const.NUMBERMAX_FORME){
			icn = new ImageIcon(Const.HATENA_PATH);
		}
		
		
		// アイコンを取得
//		ImageIcon icn	= new ImageIcon(imageLoad.Load(txt));
		return icn;
		
	}
	
	protected String FormeChange(String name){

		Reader reader			= new Reader();
		
		String img_path 		= null; // 返り値
		Integer pkmn_num 		= null; // 番号 
		String import_path 		= null;
		Boolean find			= false;
		
		// アイコンを取得(FC対応)
		String ary_pkmn[] = reader.txtReader(Const.POKEMONNAME_FORME);
		
		// 回す
		for (String t:ary_pkmn){
			if (name.equals(t)){
				find = true;
				break;
			}
		}	
		
		if(!(find)){
			return Const.NOT_FIND;
		}
		
		// 引数に対応した番号のファイル名を取得.
		pkmn_num = Get_Number(name, Const.POKEMONNAME_FORME);
		
		import_path = reader.propReader(Const.POKEMON_IMAGE_PATH);
				
		// 番号ファイルのパスを作成.
		img_path = import_path + Const.DIR_FRM + File.separator + pkmn_num + Const.FILE_PNG;
		
		return img_path;
	
	}
	
}
