package com.Erycton.Gorilla;import java.awt.GridLayout;import java.awt.Panel;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.event.MouseAdapter;import java.awt.event.MouseEvent;import javax.swing.*;import javax.swing.event.*;import com.Erycton.Data.ResultBean;import com.Erycton.Util.*;@SuppressWarnings("serial")public class Gorilla extends JFrame implements ActionListener {    private static JTextField txt_RIVAL_NAME;    private static JTextField txt_RIVAL_SHOW_1;    private static  JTextField txt_RIVAL_SHOW_2;    private static  JLabel lbl_RIVAL_RATE;    private static  JTextField txt_RIVAL_RATE;    private static  JTextField txt_RIVAL_SHOW_3;    private static  JTextField txt_RIVAL_SHOW_4;    private static  JTextField txt_RIVAL_SHOW_5;    private static  JTextField txt_RIVAL_SHOW_6;    private static  JTextField txt_ELECT_ME_1;    private static  JTextField txt_ELECT_ME_2;    private static  JTextField txt_ELECT_ME_3;    private static  JTextField txt_ELECT_RIVAL_1;    private static  JTextField txt_ELECT_RIVAL_2;    private static  JTextField txt_ELECT_RIVAL_3;    public Gorilla() {        // フレーム関係の初期化        setTitle(Const.WindowTitle);        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));        Panel pnl_PHASE_1 = new Panel();//        FlowLayout flowLayout_1 = (FlowLayout) pnl_PHASE_1.getLayout();        getContentPane().setLayout(new GridLayout(Const.GRID_LAYOUT_X, Const.GRID_LAYOUT_Y)); //7*2        getContentPane().add(pnl_PHASE_1);//        pnl_PHASE_1.setLayout(new GridLayout(1,1));                        JLabel lbl_RIVAL_NAME = new JLabel("相手名 : ");                        lbl_RIVAL_NAME.setHorizontalAlignment(SwingConstants.LEFT);                        pnl_PHASE_1.add(lbl_RIVAL_NAME);                                txt_RIVAL_NAME = new JTextField();                                txt_RIVAL_NAME.setHorizontalAlignment(SwingConstants.LEFT);                                pnl_PHASE_1.add(txt_RIVAL_NAME);                                txt_RIVAL_NAME.setColumns(14);                                        lbl_RIVAL_RATE = new JLabel("相手レート / 対戦数 : ");                                        lbl_RIVAL_RATE.setHorizontalAlignment(SwingConstants.LEFT);                                        pnl_PHASE_1.add(lbl_RIVAL_RATE);                                                txt_RIVAL_RATE = new JTextField();                                                txt_RIVAL_RATE.setHorizontalAlignment(SwingConstants.LEFT);                                                pnl_PHASE_1.add(txt_RIVAL_RATE);                                                txt_RIVAL_RATE.setToolTipText("");                                                txt_RIVAL_RATE.setColumns(4);        Panel pnl_PHASE_2_1 = new Panel();        getContentPane().add(pnl_PHASE_2_1);        JLabel lbl_RIVAL_SHOW_1 = new JLabel("相手 1 : ");        pnl_PHASE_2_1.add(lbl_RIVAL_SHOW_1);        txt_RIVAL_SHOW_1 = new JTextField();        txt_RIVAL_SHOW_1.setColumns(10);        pnl_PHASE_2_1.add(txt_RIVAL_SHOW_1);        // アイコンの表示.//        ImageLoad imgload = new ImageLoad();        final JLabel pic_RIVAL_SHOW_1 	= new JLabel();//        ImageIcon icn_RIVAL_SHOW_1	= new ImageIcon(imgload.Load(Const.Empty));//        pic_RIVAL_SHOW_1.setIcon(icn_RIVAL_SHOW_1);        pnl_PHASE_2_1.add(pic_RIVAL_SHOW_1);        JLabel lbl_RIVAL_SHOW_2 = new JLabel(" 2 : ");        pnl_PHASE_2_1.add(lbl_RIVAL_SHOW_2);        txt_RIVAL_SHOW_2 = new JTextField();        txt_RIVAL_SHOW_2.setToolTipText("");        txt_RIVAL_SHOW_2.setColumns(10);        pnl_PHASE_2_1.add(txt_RIVAL_SHOW_2);        JLabel lbl_RIVAL_SHOW_3 = new JLabel(" 3 : ");        pnl_PHASE_2_1.add(lbl_RIVAL_SHOW_3);        txt_RIVAL_SHOW_3 = new JTextField();        txt_RIVAL_SHOW_3.setToolTipText("");        txt_RIVAL_SHOW_3.setColumns(10);        pnl_PHASE_2_1.add(txt_RIVAL_SHOW_3);        		// ENTRY!!                JButton btn_ENTRY = new JButton("登録");                Panel pnl_PHASE_2_2 = new Panel();                getContentPane().add(pnl_PHASE_2_2);                JLabel lbl_RIVAL_SHOW_4 = new JLabel("　    4 : ");                pnl_PHASE_2_2.add(lbl_RIVAL_SHOW_4);                txt_RIVAL_SHOW_4 = new JTextField();                txt_RIVAL_SHOW_4.setColumns(10);                pnl_PHASE_2_2.add(txt_RIVAL_SHOW_4);                JLabel lbl_RIVAL_SHOW_5 = new JLabel(" 5 : ");                pnl_PHASE_2_2.add(lbl_RIVAL_SHOW_5);                txt_RIVAL_SHOW_5 = new JTextField();                txt_RIVAL_SHOW_5.setToolTipText("");                txt_RIVAL_SHOW_5.setColumns(10);                pnl_PHASE_2_2.add(txt_RIVAL_SHOW_5);                JLabel lbl_RIVAL_SHOW_6 = new JLabel(" 6 : ");                pnl_PHASE_2_2.add(lbl_RIVAL_SHOW_6);                txt_RIVAL_SHOW_6 = new JTextField();                txt_RIVAL_SHOW_6.setToolTipText("");                txt_RIVAL_SHOW_6.setColumns(10);                pnl_PHASE_2_2.add(txt_RIVAL_SHOW_6);                JPanel pnl_PHASE2_3 = new JPanel();                getContentPane().add(pnl_PHASE2_3);                JLabel lbl_ELECT_ME_1 = new JLabel("自分 1 : ");                pnl_PHASE2_3.add(lbl_ELECT_ME_1);                txt_ELECT_ME_1 = new JTextField();                txt_ELECT_ME_1.setToolTipText("");                txt_ELECT_ME_1.setColumns(10);                pnl_PHASE2_3.add(txt_ELECT_ME_1);                JLabel lbl_ELECT_ME_2 = new JLabel(" 2 : ");                pnl_PHASE2_3.add(lbl_ELECT_ME_2);                txt_ELECT_ME_2 = new JTextField();                txt_ELECT_ME_2.setToolTipText("");                txt_ELECT_ME_2.setColumns(10);                pnl_PHASE2_3.add(txt_ELECT_ME_2);                JLabel lbl_ELECT_ME_3 = new JLabel(" 3 : ");                pnl_PHASE2_3.add(lbl_ELECT_ME_3);                txt_ELECT_ME_3 = new JTextField();                txt_ELECT_ME_3.setColumns(10);                pnl_PHASE2_3.add(txt_ELECT_ME_3);                Panel pnl_PHASE_3 = new Panel();                getContentPane().add(pnl_PHASE_3);                JLabel lbl_ELECT_RIVAL_1 = new JLabel("選出 1 : ");                pnl_PHASE_3.add(lbl_ELECT_RIVAL_1);                txt_ELECT_RIVAL_1 = new JTextField();                txt_ELECT_RIVAL_1.setColumns(10);                pnl_PHASE_3.add(txt_ELECT_RIVAL_1);                JLabel lbl_ELECT_RIVAL_2 = new JLabel(" 2 : ");                pnl_PHASE_3.add(lbl_ELECT_RIVAL_2);                txt_ELECT_RIVAL_2 = new JTextField();                txt_ELECT_RIVAL_2.setToolTipText("");                txt_ELECT_RIVAL_2.setColumns(10);                pnl_PHASE_3.add(txt_ELECT_RIVAL_2);                JLabel lbl_ELECT_RIVAL_3 = new JLabel(" 3 : ");                pnl_PHASE_3.add(lbl_ELECT_RIVAL_3);                txt_ELECT_RIVAL_3 = new JTextField();                txt_ELECT_RIVAL_3.setToolTipText("");                txt_ELECT_RIVAL_3.setColumns(10);                pnl_PHASE_3.add(txt_ELECT_RIVAL_3);                final JPanel pnl_PHASE_4 = new JPanel();                getContentPane().add(pnl_PHASE_4);                JLabel btn_RESULT = new JLabel("対戦結果 : ");                pnl_PHASE_4.add(btn_RESULT);                // ButtonGroup Create                ButtonGroup grp = new ButtonGroup();                final JRadioButton rbtn_WIN = new JRadioButton("勝ち");                pnl_PHASE_4.add(rbtn_WIN);                                final JRadioButton rbtn_LOSE = new JRadioButton("負け");                pnl_PHASE_4.add(rbtn_LOSE);                                final JRadioButton rbtn_CUT = new JRadioButton("切断");                pnl_PHASE_4.add(rbtn_CUT);                    			final JLabel lbl_ERR = new JLabel("　　　　　　　　　　　　");                pnl_PHASE_4.add(lbl_ERR);                // ButtonGroup Add                grp.add(rbtn_WIN);                grp.add(rbtn_LOSE);                grp.add(rbtn_CUT);                                txt_RIVAL_SHOW_1.getDocument().addDocumentListener(new DocumentListener(){                	public void changedUpdate(DocumentEvent de){                		ImageLoad imageLoad 		= new ImageLoad();                		ImageIcon icn_RIVAL_SHOW_1	= new ImageIcon(imageLoad.Load(txt_RIVAL_SHOW_1.getText()));                        pic_RIVAL_SHOW_1.setIcon(icn_RIVAL_SHOW_1);                        repaint();                        System.out.println("i");                        System.out.println("a");                	}					public void insertUpdate(DocumentEvent e) {	            		ImageLoad imageLoad 		= new ImageLoad();	            		ImageIcon icn_RIVAL_SHOW_1	= new ImageIcon(imageLoad.Load(txt_RIVAL_SHOW_1.getText()));                        pic_RIVAL_SHOW_1.setIcon(icn_RIVAL_SHOW_1);                        repaint();                        System.out.println("i");					}					public void removeUpdate(DocumentEvent e) {	            		ImageLoad imageLoad 		= new ImageLoad();	            		ImageIcon icn_RIVAL_SHOW_1	= new ImageIcon(imageLoad.Load(txt_RIVAL_SHOW_1.getText()));                        pic_RIVAL_SHOW_1.setIcon(icn_RIVAL_SHOW_1);                        repaint();                        System.out.println("u");					};					                });                                // 登録処理.                getContentPane().add(btn_ENTRY);                btn_ENTRY.addMouseListener(new MouseAdapter() {                	@Override                	public void mouseClicked(MouseEvent e) {	                		                		String rival_Name 		= null;                		String rival_Rate		= null;                		String rival_Show_1		= null;                		String rival_Show_2		= null;                		String rival_Show_3		= null;                		String rival_Show_4		= null;                		String rival_Show_5		= null;                		String rival_Show_6		= null;                		String elect_Me_1		= null;                		String elect_Me_2		= null;                		String elect_Me_3		= null;                		String elect_Rival_1	= null;                		String elect_Rival_2	= null;                		String elect_Rival_3	= null;                		                 		// 入力情報をコンポーネントから取得.                		rival_Name		= txt_RIVAL_NAME.getText();              		 	rival_Rate		= txt_RIVAL_RATE.getText();              		 	rival_Show_1	= txt_RIVAL_SHOW_1.getText();              		 	rival_Show_2	= txt_RIVAL_SHOW_2.getText();              		 	rival_Show_3	= txt_RIVAL_SHOW_3.getText();              		 	rival_Show_4	= txt_RIVAL_SHOW_4.getText();              		 	rival_Show_5	= txt_RIVAL_SHOW_5.getText();              		 	rival_Show_6	= txt_RIVAL_SHOW_6.getText();              		 	elect_Me_1		= txt_ELECT_ME_1.getText();              		 	elect_Me_2		= txt_ELECT_ME_2.getText();              		 	elect_Me_3		= txt_ELECT_ME_3.getText();              		 	elect_Rival_1	= txt_ELECT_RIVAL_1.getText();              		 	elect_Rival_2	= txt_ELECT_RIVAL_2.getText();              		 	elect_Rival_3	= txt_ELECT_RIVAL_3.getText();              		 	              		 	// 配列に格納.                  		String ttl[] =  {rival_Name, rival_Rate, rival_Show_1, rival_Show_2, rival_Show_3,                  							rival_Show_4, rival_Show_5, rival_Show_6, elect_Me_1, elect_Me_2, elect_Me_3,                  							elect_Rival_1, elect_Rival_2, elect_Rival_3};                  		                  		// 入力情報をチェック(対戦結果を除く).                  		Check check = new Check();                  		boolean tres = check.Chk_Total(ttl);               		                 	   // 対戦結果のチェック.                       boolean bl_Win = rbtn_WIN.isSelected();                       boolean bl_Los = rbtn_LOSE.isSelected();                       boolean bl_Cut = rbtn_CUT.isSelected();                       Util util = new Util();                       Integer res = util.isResult(bl_Win, bl_Los, bl_Cut);                       boolean rres = check.Chk_Result(res);	              		                       // 入力エラー処理                       if(!(tres) || !(rres)){                    	   // ウィンドウにエラーの表示                    	   lbl_ERR.setText("　　　　　　　入力エラー");                    	   repaint();                    	   return;                       }else{                    	   lbl_ERR.setText("");               				repaint();                       }                               		// Throw to Beans                		ResultBean resultBean = new ResultBean();                		resultBean.setRival_Name(rival_Name);                		resultBean.setRival_Rate(rival_Rate);                		resultBean.setRival_Show_1(rival_Show_1);                		resultBean.setRival_Show_2(rival_Show_2);                		resultBean.setRival_Show_3(rival_Show_3);                		resultBean.setRival_Show_4(rival_Show_4);                		resultBean.setRival_Show_5(rival_Show_5);                		resultBean.setRival_Show_6(rival_Show_6);                		resultBean.setElect_Me_1(elect_Me_1);                		resultBean.setElect_Me_2(elect_Me_2);                		resultBean.setElect_Me_3(elect_Me_3);                		resultBean.setElect_Rival_1(elect_Rival_1);                		resultBean.setElect_Rival_2(elect_Rival_2);                		resultBean.setElect_Rival_3(elect_Rival_3);                		resultBean.setResult(res);                		                		/* export. */                		Writer wrt = new Writer();                		boolean bl_wrt = wrt.Export(resultBean);                		// Failed?                		if (!(bl_wrt)){                			lbl_ERR.setText("ExportError!");                		}              		                		// TextBox initialize.                		Gorilla.init();                		// RadioButton iniialize.                		rbtn_WIN.setSelected(true);                        	}                });                       pack();    }    @Override	public void actionPerformed(ActionEvent e) {    }    public static void main(String[] args) {        JFrame frame = new Gorilla();        // Set - WindowSize//        frame.setBounds(500, 500, 500, 500);        frame.setVisible(true);        init();        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    }        protected static void init(){		txt_RIVAL_NAME.setText("");		txt_RIVAL_RATE.setText("");		txt_RIVAL_SHOW_1.setText("");		txt_RIVAL_SHOW_2.setText("");		txt_RIVAL_SHOW_3.setText("");		txt_RIVAL_SHOW_4.setText("");		txt_RIVAL_SHOW_5.setText("");		txt_RIVAL_SHOW_6.setText("");		txt_ELECT_ME_1.setText("");		txt_ELECT_ME_2.setText("");		txt_ELECT_ME_3.setText("");		txt_ELECT_RIVAL_1.setText("");		txt_ELECT_RIVAL_2.setText("");		txt_ELECT_RIVAL_3.setText("");    }   }