package com.Erycton.Util;public class Const {		/* System */	public static final String OS_NAME					= "os.name";	public static final String MAC_OS					= "Mac OS";	public static final String LINUX_OS					= "Linux";	public static final Integer NOT_FOUND				= -1;	/* Layout */	// ウィンドウ名	public static final String	WindowTitle		  		= "Erycton";		// ウィンドウサイズ	public static final Integer BOUNDS_X		  		= 500;	public static final Integer BOUNDS_Y		  		= 500;	public static final Integer BOUNDS_WIDTH	  		= 750;	public static final Integer BOUNDS_HEIGHT	  	    = 350;		// グリッドレイアウト	public static final Integer GRID_LAYOUT_Y 			= 7;	public static final Integer GRID_LAYOUT_X 			= 5;	// テキスト最大入力数	public static final Integer RIVAL_NAME_TXT_NUM		= 14;	public static final Integer RIVAL_RATE_TXT_NUM		= 4;	public static final Integer SET_TEXT_COLUMNS 		= 10;	// メッセージ	public static final String MSG_CONFIRM_EXIT 		= "終了します。";	public static final String CONFIRM 					= "確認";	public static final String MSG_ERR 					= "　　　　　　　　　入力エラー";	public static final String MSG_EXPORT_ERR 			= "ExportError.";	// コントロール名、テキスト	public static final String LBL_TEXT_RIVAL_NAME   	= "相手名 : ";	public static final String LBL_TEXT_RIVAL_RATE 	 	= "相手レート / 対戦数 : ";	public static final String LBL_TEXT_RIVAL_SHOW_1 	= "相手 1 : ";	public static final String LBL_TEXT_RIVAL_SHOW_2 	= " 2 : ";	public static final String LBL_TEXT_RIVAL_SHOW_3 	= " 3 : ";	public static final String LBL_TEXT_RIVAL_SHOW_4 	= "　     4 : ";	public static final String LBL_TEXT_RIVAL_SHOW_5 	= " 5 : ";	public static final String LBL_TEXT_RIVAL_SHOW_6 	= " 6 : ";	public static final String BTN_TEXT_ENTRY		 	= "登録";	public static final String LBL_TEXT_ELECT_ME_1	 	= "自分 1 : ";	public static final String LBL_TEXT_ELECT_ME_2	 	= " 2 : ";	public static final String LBL_TEXT_ELECT_ME_3	 	= " 3 : ";	public static final String LBL_TEXT_ELECT_RIVAL_1 	= "選出 1 : ";	public static final String LBL_TEXT_ELECT_RIVAL_2 	= " 2 : ";	public static final String LBL_TEXT_ELECT_RIVAL_3 	= " 3 : ";	public static final String BTN_TEXT_RESULT			= "対戦結果 : ";	public static final String RBTN_TEXT_WIN			= "勝ち";	public static final String RBTN_TEXT_LOSE			= "負け";	public static final String RBTN_TEXT_CUT			= "切断";	public static final String LBL_TEXT_ERR_EMPTY 		= "　　　　　　　　　　　　";	public static final String LBL_TEXT_ERR 			= "　　　　　　　入力エラー";	public static final String EXPORT_ERR				= "ExportError!";	    /* File & Path */	// propertiesファイル名、パス	public static final String PROPERTIES_PATH 			= "./conf/Erycton.properties";	public static final String DIR_FRM 					= "frm/"; 	public static final String HATENA_PATH 				= "./img/0.png";	// propertiesファイルから読み込むプロパティ名	public static final String POKEMONNAME_NORMAL		= "POKEMON_NAME_NORMAL_PATH";	public static final String POKEMONNAME_FORME 		= "POKEMON_NAME_FORME_PATH";	public static final String POKEMON_IMAGE_PATH 		= "POKEMON_IMAGE_PATH";	public static final String EXPORT_PARTITION			= "EXPORT_PARTITION";	public static final String EXPORT_PARTITION_BAR		= "EXPORT_PARTITION_BAR";	public static final String NORMAL_MAX				= "NORMAL_MAX";	public static final String FORME_MAX				= "FORME_MAX";	// 出力先のパス	public static final String EXPORT_PATH 				= "./export/";	// ファイル拡張子	public static final String FILE_TXT 				= ".txt";	public static final String FILE_PNG					= ".png";		// 対戦区分	public static final String SINGLE 					= "single";		/* 文字列 */	public static final String strnull 					= "";	public static final String str_null 				= " ";	public static final String Empty 					= "";	// imgファイルが見つからなかった際の返り値	public static final String NOT_FIND 				= "0";		// ？アイコン	public static final String HATENA 					= "hatena";		/* 数値・数字 */	public static final char zero 						= '0';	public static final char nine 						= '9';		/* 日付 */	public static final String df						= "yyyy/MM/dd/E/HH/mm/ss";	public static final String partion					= "/";	public static final String YEAR						= "y";	public static final String MONTH 					= "M";	public static final String DAY 						= "d";	public static final String HOUR						= "H";	public static final String MINUTE					= "m";	public static final String SECOND					= "s";	public static final String WEEK						= "E";	/* 出力 */	public static final String ENCODE					= "UTF-8"; 	public static final String WIN						= "WIN";	public static final String LOSE						= "LOSE";	public static final String CUT						= "CUT";	public static final String TOP_ITEMNAME				= "対戦相手名, 対戦相手レート, 相手見せ合い1, 2, 3, 4, 5, 6, 自選出1, 2, 3, 相手選出1, 2, 3, 対戦結果, 対戦時間";	}