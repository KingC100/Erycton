package com.Erycton.Gorilla;

import javax.swing.ImageIcon;

import com.Erycton.Util.Const;
import com.Erycton.Util.Reader;

public class ImageLoad {

	/***
	 * アイコンのパスを取得します.
	 * @param pkmn_name - ポケモンの名前.
	 * @return img_path - アイコンのパス.
	 */
	public String Load (String pkmn_name) {
		
		Reader reader = new Reader();
		String img_path = null;
		Integer pkmn_num = null; 
		String import_path = null;
		
		try{
		
			// 引数に対応した番号のファイル名を取得.
			pkmn_num = Get_Number(pkmn_name, Const.POKEMONNAME_NORMAL);	
			// imgフォルダのパスを取得.
			import_path = reader.propReader(Const.POKEMON_IMAGE_PATH);
			// アイコンファイルのパスを作成.
			img_path = import_path + pkmn_num + Const.FILE_PNG;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return img_path;
	}
	
	/**
	 * アイコンの番号を取得します.
	 * @param name - ポケモン名
	 * @param type   - 対戦種別
	 * @return アイコンの番号
	 */
	protected Integer Get_Number(String name, String type){
		Integer i = 0;
		Reader reader = new Reader();
		String ary_pkmn[] = reader.txtReader(type);

		try{
			// 対象ポケモン名がpokemon_name.txtに存在するか確認
			for (String t:ary_pkmn){
				if (name.equals(t)){
					// 見つかったら抜ける.
					break;
				}
				i++;
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
		return i + 1;
	}
	
	/***
	 * アイコンを取得します.
	 * @param txt - ポケモン名
	 * @return icn  - ポケモン名に対応したアイコン
	 */
	public ImageIcon GetImage(String txt){
		
		ImageLoad imageLoad 	= new ImageLoad();
		ImageIcon icn = null;
		String frm_chg = FormeChange(txt);
		String imgpath = imageLoad.Load(txt);
		
		try{
			// ポケモン名と紐付いた数字が存在しない場合は「？」表示.
			Reader reader = new Reader();
			Integer hatena_normal = Get_Number(txt, Const.POKEMONNAME_NORMAL);
			Integer hatena_forme = Get_Number(txt, Const.POKEMONNAME_FORME);
		
			// ポケモン名がフォルムチェンジか判定.
			if (frm_chg.equals(Const.NOT_FIND)){
				// 通常版.
				icn = new ImageIcon(imgpath);
			}else{
				// フォルムチェンジ版.
				icn = new ImageIcon(frm_chg);
			}

			// 通常ポケモンの総数
			Integer normal_max = Integer.parseInt(reader.propReader(Const.NORMAL_MAX));
			// フォルムチェンジの総数
			Integer forme_max  = Integer.parseInt(reader.propReader(Const.FORME_MAX));
		
			// それぞれの関数内で紐付いた番号が存在しない場合ははてなアイコンを設定.
			if(hatena_normal >= normal_max
					&& hatena_forme >= forme_max){
					icn = new ImageIcon(reader.propReader(Const.HATENA_PATH));
				}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return icn;
	}
	
	/***
	 * フォルムチェンジアイコン取得.
	 * @param name - ポケモン名
	 * @return  img_path - フォルムチェンジアイコンのパス
	 */
	protected String FormeChange(String name){

		Reader reader			= new Reader();
		String img_path 		= null; // 返り値
		Integer pkmn_num 	= null; // 番号 
		String import_path 	= null;
		Boolean find				= false;
		
		try{
		
			// ポケモン名を取得(FC対応)
			String ary_pkmn[] = reader.txtReader(Const.POKEMONNAME_FORME);
			// 引数に対応した番号のファイル名を取得.
			pkmn_num = Get_Number(name, Const.POKEMONNAME_FORME);
			// imgフォルダのパスを取得.
			import_path = reader.propReader(Const.POKEMON_IMAGE_PATH);
		
			// 検索.
			for (String t:ary_pkmn){
				if (name.equals(t)){
					find = true;
					break;
				}
			}	
		
			// 見つからなかった場合は"0"を返す.
			if(!(find)){
				return Const.NOT_FIND;
			}
		
			// 番号ファイルのパスを作成.
			img_path = import_path + Const.DIR_FRM + pkmn_num + Const.FILE_PNG;
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return img_path;
	}
	
}
