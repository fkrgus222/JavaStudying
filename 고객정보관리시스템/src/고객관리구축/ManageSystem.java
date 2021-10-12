package 고객관리구축;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog; //package 클래스
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;  


/*
 *<< 개정이력(Modification Information) >>
 * 수정일                  수정자         수정 내용
 * ----         ------    -------
 * 2021.10.07    박준서         레이아웃 설계, 기능 구현
 * 2021.10.08             West
 */            
             //외부 클래스
public class ManageSystem extends JFrame{ //JFrame클래스는 최상위 컨테이너 역할의 클래스이다. 
	public static final String String = null;
	
	//내부 클래스 객체 생성 ??왜 내부 클래스 객체를 외부클래스 생성자 밖에 했나 : 
	                     //모든 내부 클래스에서 접근 가능하도록 하기 위해 =?Global 개념
	MenuMain menuMain = new MenuMain();
	West west = new West();
	Buttons buttons = new Buttons();
	ShowTable showTable = new ShowTable();
	
	//  외부 클래스 생성자
	public ManageSystem() {
		OUTTER: while(true) { //OUTER: 레이블 
			ImageIcon icon = new ImageIcon("images/고객정보관리image.jpg.JPG");
			JOptionPane.showMessageDialog(null, null, "고객정보 관리 시스템",
					                      JOptionPane.NO_OPTION, icon);
			
			String password = JOptionPane.showInputDialog("고객관리 시스템" + "\n" +"패스워드 입력");
			String pw = "1234";
			
			if(password == null) {
				break OUTTER;
			}else if(password.equals(pw)) {//password 인증성공 시 => 실행화면 띄우기
				setTitle("고객정보 관리 시스템");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
				//추가
				add(menuMain.bar,BorderLayout.NORTH);
				add(west,BorderLayout.WEST);
				add(buttons,BorderLayout.SOUTH);
				add(showTable.scrollPane, BorderLayout.CENTER);
				setSize(1200,800);
				setLocation(500, 50);
				setVisible(true);
				
				break OUTTER;
			}else {
				JOptionPane.showMessageDialog(null,
						                      "패스워드가 맞지 않습니다." + "\n" + "'확인' 버튼 누르세요.",
						                      "에러 메시지",
						                     JOptionPane.ERROR_MESSAGE);
				continue OUTTER;
			}
		}
	}
	//메뉴 만들기 => 내부 클래스  (inner class)
	/*
	 * 자바는 하나의 클래스로부터 상속을 받고, 인터페이스는 여러개를 구현시킬 수 있다.
	 */
	class MenuMain extends JPanel implements ActionListener,ItemListener{
		JMenuBar           bar;
		JMenu              file,sort,help;
		JMenuItem          fnew, fopen, fsave, fexit, proinfo;
		JCheckBoxMenuItem  sno, sname, schul, sjob;
		
		FileDialog readOpen, saveOpen;
		String fileDir, fileName, savefileName, readfileName;
		ButtonGroup gr = new ButtonGroup();
		
		//생성자
		public MenuMain() {//화면 구현(UI), 각 객체(컴퍼넌트)에 대한 이벤트 연결
			bar = new JMenuBar();
			
			file = new JMenu("파일");
			sort = new JMenu("정렬");
			help = new JMenu("도움말");
			
			fopen = new JMenuItem("열기"); //JMenuItem 컴퍼넌트는  ActionEvent가 발생
			fsave = new JMenuItem("저장");
			fexit = new JMenuItem("닫기");
			
			sno = new JCheckBoxMenuItem("번호"); //JCheckBoxMenuItem 컴퍼넌트는 ItemEvent가 발생
			sname = new JCheckBoxMenuItem("이름");
			schul = new JCheckBoxMenuItem("출신지역");
			sjob = new JCheckBoxMenuItem("직업");
			
			proinfo = new JMenuItem("프로그램 정보");
			
			//객체들 컨테이너에 붙이기
			file.add(fopen); file.add(fsave); file.addSeparator(); file.add(fexit);
			
			gr.add(sno); gr.add(sname); gr.add(schul); gr.add(sjob);
			
			sort.add(sno); sort.add(sname); sort.add(schul); sort.add(sjob);
			help.add(proinfo);
			
			bar.add(file); bar.add(sort); bar.add(help);
			
			//파일 메뉴 이벤트 연결
			fopen.addActionListener(this);
			fsave.addActionListener(this);
			fexit.addActionListener(this);
			
			//정렬 메뉴 이벤트 연결
			sno.addItemListener(this);
			sname.addItemListener(this);
			schul.addItemListener(this);
			sjob.addItemListener(this);
			
			
		}

		 @Override
	      public void itemStateChanged(ItemEvent e) {
	         if(e.getSource().equals(sno)) numSort();
	         else if(e.getSource().equals(sname)) StringSort(1);//번호 정렬
	         else if(e.getSource().equals(schul)) StringSort(7);//이름 정렬
	         else if(e.getSource().equals(sjob)) StringSort(9);//출신지역 정렬
	      }
	      
	      //'번호' 정렬 ===================
	      public void numSort() {
	         int row = showTable.table.getRowCount();// 행의 갯수 얻기
	         int col = showTable.table.getColumnCount();//열의 갯수 얻기
	         
	         String temp;
	         String [][] arr = new String[row][col];
	         
	         //먼저 JTable 객체의 데이터들을 arr[][] 2차원 배열로 옮기기
	         for(int i=0;i<row;i++) {
	            for(int j = 0; j<col; j++) {
	               arr[i][j] = (String)showTable.table.getValueAt(i, j);
	            }
	         }
	         //선택 정렬(selection sort) 알고리즘을 적용하여 2차원 배열 정렬하기
	         for(int i = 0 ; i<row-1;i++) {
	            for(int j = 0; j<row-1;j++) {
	               if(Integer.parseInt(arr[i][0]) > Integer.parseInt(arr[j][0])) {
	                  for(int k = 0; k<col; k++) {
	                     temp = arr[i][k];
	                     arr[i][k] = arr[j][k];
	                     arr[j][k] = temp;
	                  }
	               }
	            }
	         }
	         //arr[][] 2차원 배열의 데이터들을 JTable로 옮기기
	         for(int i = 0 ; i<row-1;i++) {
	            for(int j = 0; j<row-1;j++) {
	               showTable.table.setValueAt(arr[i][j], i, j);
	            }
	         }
	         
	      }
	      
	    //하나의 메소드로 '이름', '출신지역', '직업' 정렬을 처리한다.
	      public void StringSort(int sortType) {
	         int row = showTable.table.getRowCount();// 행의 갯수 얻기
	         int col = showTable.table.getColumnCount();//열의 갯수 얻기
	         
	         String temp;
	         String [][] arr = new String[row][col];
	         
	         //먼저 JTable 객체의 데이터들을 arr[][] 2차원 배열로 옮기기
	         for(int i=0;i<row;i++) {
	            for(int j = 0; j<col; j++) {
	               arr[i][j] = (String)showTable.table.getValueAt(i, j);
	            }
	         }
	         //선택 정렬(selection sort) 알고리즘을 적용하여 2차원 배열 정렬하기
	         for(int i = 0 ; i<row-1;i++) {
	            for(int j = 0; j<row-1;j++) {
	               if(arr[i][sortType].compareTo(arr[j][sortType]) > 0) {
	                  for(int k = 0; k<col; k++) {
	                     temp = arr[i][k];
	                     arr[i][k] = arr[j][k];
	                     arr[j][k] = temp;
	                  }
	               }
	            }
	         }
	         //arr[][] 2차원 배열의 데이터들을 JTable로 옮기기
	         for(int i = 0 ; i<row-1;i++) {
	            for(int j = 0; j<row-1;j++) {
	               showTable.table.setValueAt(arr[i][j], i, j);
	            }
	         }
	      }
	      
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("열기"))			open();
			else if (e.getActionCommand().equals("저장"))	save();
			else if (e.getActionCommand().equals("닫기"))	exit();
		}
		
		//'파일 열기' 이벤트 처리 메소드
	      public void open() {
	         StringTokenizer st;
	         Vector v;
	         
	         readOpen = new FileDialog(ManageSystem.this,"문서열기",FileDialog.LOAD);
	         readOpen.setVisible(true);  //'문서열기' 다이얼로그 창 띄우기
	         
	         fileDir = readOpen.getDirectory();
	         fileName = readOpen.getFile();
	         
	         readfileName = fileDir + "//" + fileName;
	         
	         try {
	            BufferedReader read = new BufferedReader(new FileReader(readfileName));
	            String line = null;
	            
	            while((line = read.readLine()) != null) {
	               st = new StringTokenizer(line, ", "); //[중요]
	               v = new Vector();
	               
	               while(st.hasMoreTokens()) {
	                  v.add(st.nextToken());
	               }
	               showTable.data.addElement(v);
	            }
	            showTable.datamodel.fireTableDataChanged(); //datamodel에 변화를 통보해줌
	            read.close(); //자원 해제
	         }catch(Exception e) {
	            System.out.println(e);
	         }
	      }
		
		//'파일 저장'이벤트 처리 메소드 => [가장 중요한 핵심 기능]
		public void save() {
			saveOpen = new FileDialog(ManageSystem.this, "문서저장",FileDialog.SAVE);
			saveOpen.setVisible(true);	//'문서저장' 다이얼로그 창 싀우기
			
			fileDir = saveOpen.getDirectory(); //사용자가 선택한 '디렉토리명' 얻어오기
			fileName = saveOpen.getFile();     //사용자가 선택한 '파일명' 얻어오기
			savefileName = fileDir + "//" + fileName; //결합
			
			String str = "";
			String temp = "";
			
			/*
			 * [중요] 파일에 저장 또는 열기 작업을 할 때는 반드시 예외처리 구문이 필요하다!!
			 */
			try {
				BufferedWriter save = new BufferedWriter(new FileWriter(savefileName));
				
				for (int i = 0 ; i < showTable.table.getRowCount() ; i ++) {
					temp = showTable.data.elementAt(i).toString();
					str += temp.substring(1, temp.length()-1) +"\n";
				}
				save.write(str);
				save.close();
			}catch(Exception ex) {
				System.out.println(ex);
			}
			
			
		}
		//'파일 닫기'이벤트처리 메소드 
		public void exit() {
			
		}
	
		
	}//end MenuMain 클래스 =========================
	
	//입력, 신상정보 즉 West ==> 내부 클래스
	class West extends JPanel{//JPanel은 작은 컨테이너 역할의 클래스
		//내부 클래스에 활용할 객체 생성
		Input input = new Input();
		Output output = new Output();
		
		//생성자
	public West() {
		setLayout(new BorderLayout());
		add(input, BorderLayout.CENTER);
		add(output,BorderLayout.SOUTH);
	}
	class Input extends JPanel{  //입력 정보 담당 클래스
		JTextField[] tf = new JTextField[5];
		String[] text = {"번호","이름","핸드폰번호","이메일","주민등록번호"};
		                      //5개를 입력받겠다
		String[] jobText = {"선택","회사원","공무원","프로게이머","교수","학생","기타"};
		JLabel la,job;
		JComboBox box;
		
		
		
		//생성자
		public Input() { //화면설계(UI)
			setBorder(new TitledBorder(new LineBorder(Color.BLUE), "입력"));
			setLayout(new GridLayout(6, 2, 5, 30));
			
			for(int i = 0; i < text.length;i++) {
				la = new JLabel(text[i]);
				tf[i] = new JTextField(10);
				la.setHorizontalAlignment(JLabel.CENTER);
				add(la); add(tf[i]);
				
			}
			box = new JComboBox(jobText);
			job = new JLabel("직업");
			job.setHorizontalAlignment(JLabel.CENTER);
			add(job); add(box);
			setPreferredSize(new Dimension(340, 300));
		}
	}
	class Output extends JPanel implements ActionListener{//신상정보 담당 클래스
		//추가
		JPanel info = new JPanel(); //'신상 정보' 보더 만들기 JPanel
		JPanel search = new JPanel(); //'정보 검색' 보더 만들기 JPanel  
		
		CardLayout card = new CardLayout();
		String[] text = {"   나이:", "   성별:","   출신지역","  일: "} ;
		JLabel[] label = new JLabel[4];
		ButtonGroup group = new ButtonGroup();
		JRadioButton[] searchRadio = new JRadioButton[4];
		JButton searchButton;
		JButton exitButton;
		JTextField nameText;
		String[] search_name = {"이름","직업","출생지역","생년월일"};
		int searchType;
		
		
		
		//생성자
		public Output() { //화면 구현(UI), 각 객체(컴퍼넌트)에 대한 이벤트 연결
			
			//'신상정보' UI 보더 만들기
			info.setBorder(new TitledBorder(new LineBorder(Color.BLUE,2),"신상정보"));
			info.setLayout(new GridLayout(4, 1)); 
			
			for(int i=0; i < text.length; i++) {
				label[i] = new JLabel(text[i], JLabel.LEFT);
				info.add(label[i]);
			}
			
			//'정보검색' UI 보더 만들기
			search.setBorder(new TitledBorder(new LineBorder(Color.BLUE,2),"정보검색"));
			
			nameText = new JTextField(10);
			searchButton = new JButton("찾기");
			exitButton = new JButton("나가기");
			
			searchButton.setBackground(Color.CYAN);
			exitButton.setBackground(Color.YELLOW);
			
			//버튼 객체에 이벤트 핸들러 리스너 등록(연결)
			searchButton.addActionListener(this);
			exitButton.addActionListener(this);
			
			setPreferredSize(new Dimension(340,300));
			
			int x = -70;
			search.setLayout(null);
			
			for(int i = 0; i <searchRadio.length; i++) {
				searchRadio[i] = new JRadioButton(search_name[i]);
				searchRadio[i].setBounds(x += 80, 60, 80, 30);
				group.add(searchRadio[i]);
				search.add(searchRadio[i]);
				//이벤트연결
				searchRadio[i].addActionListener(this);
			}
			nameText.setBounds(40, 110, 200, 30);
			searchButton.setBounds(35, 170, 80, 30);
			exitButton.setBounds(140, 170, 110, 30);
			search.add(nameText);
			search.add(searchButton);
			search.add(exitButton);
			
			card = new CardLayout();
			setLayout(card);
			
			add(info, "신상정보 카드");
			add(search, "정보 검색카드");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("이름"))		searchType = 1;
			if(e.getActionCommand().equals("직업"))		searchType = 9;
			if(e.getActionCommand().equals("출생지역"))	searchType = 7;
			if(e.getActionCommand().equals("생일"))		searchType = 8;
			if(e.getActionCommand().equals("찾기"))		search();
			
			if(e.getActionCommand().equals("나가기")) goOut();
		}
		//'찾기' 이벤트 처리 메소드 => [중요]
		public void search() {
			Vector v = new Vector();
			
			for (int i = 0 ; i < showTable.data.size(); i++) {
				if (nameText.getText().contentEquals(showTable.data.elementAt(i).get(searchType))) {
					v.addElement(showTable.data.elementAt(i));
				}
			}
			showTable.datamodel.setDataVector(v, showTable.column_name);
			showTable.TableSize();
			nameText.setText(null);
		}
		
		
		
		//'나가기' 이벤트 처리 메소드
		public void goOut() {
			west.output.card.show(west.output, "신상정보 카드");
			
		}
		}
	}
	//end West 클래스==================================
	
	//버튼들 만들기 => 내부 클래스
	class Buttons extends JPanel implements ActionListener{
		Vector<String> vector;
		JButton addBtn, delBtn, preBtn, nextBtn, updateBtn, searchBtn;
		int age;
		String juminNo, sung, chul, birthPlace;


		//생성자
		public Buttons() {
			setLayout(new GridLayout(1, 6));
			
			addBtn = new JButton("추가");
			delBtn = new JButton("삭제");
			preBtn = new JButton("이전");
			nextBtn = new JButton("다음");
			updateBtn = new JButton("수정");
			searchBtn = new JButton("검색");
			
			//버튼 색깔주기
			
			addBtn.setBackground(Color.YELLOW);
			delBtn.setBackground(Color.PINK);
			updateBtn.setBackground(Color.GREEN);
			searchBtn.setBackground(Color.ORANGE);
			
			add(addBtn); add(delBtn); add(preBtn); add(nextBtn);
			add(updateBtn); add(searchBtn);
			
			//이벤트 연결
			
			addBtn.addActionListener(this);
			delBtn.addActionListener(this);
			preBtn.addActionListener(this);
			nextBtn.addActionListener(this);
			updateBtn.addActionListener(this);
			searchBtn.addActionListener(this);
			
		}
		@Override //자식클래스에 맞게끔 재정의해서 사용
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("추가")) addData(); //>>메소드 넘기기
			else if(e.getActionCommand().equals("검색")) searchData();
			else if(e.getActionCommand().equals("수정")) updateData();
			else if(e.getActionCommand().equals("삭제")) deleteData();
			else if(e.getActionCommand().equals("이전")) preData();
			else if(e.getActionCommand().equals("다음")) nextData();
		}
		
		//'이전'버튼에서 이벤트가 발생하면 처리하는 메소드 
		public void preData() {
			if (showTable.row > 0) {
				showTable.row--;
				addBtn.setEnabled(false);	//'추가' 버튼 비활성화
				nextBtn.setEnabled(true);	//'다음' 버튼 비활성화
			}else {
				return;
			}
			showTable.Info();
		}
		
		//'다음'버튼에서 이벤트가 발생하면 처리하는 메소드
		public void nextData() {
			if(showTable.row < showTable.datamodel.getRowCount() -1) {
				showTable.row++;
				preBtn.setEnabled(true);  //'이전' 버튼 활성화    
				addBtn.setEnabled(false); //'추가'버튼 비활성화
			}else {
				nextBtn.setEnabled(false); //'다음'버튼 비활성화
				addBtn.setEnabled(true);   //'추가'버튼 비활성화
				
				west.input.tf[0].setText(null);
				west.input.tf[1].setText(null);
				west.input.tf[2].setText(null);
				west.input.tf[3].setText(null);
				west.input.tf[4].setEnabled(true);
				west.input.box.setSelectedIndex(0);
				west.input.tf[0].requestFocus();
				
				west.output.label[0].setText("   나이:");
				west.output.label[1].setText("   성별:");
				west.output.label[2].setText("   출생지역:");
				west.output.label[3].setText("   생일:");
				return;
			}
			showTable.Info();
		}
		
		
		
		//'삭제' 버튼에서 이벤트가 발생하면 처리하는 메소드
		public void deleteData() {
			int yes_no_select = JOptionPane.showConfirmDialog(null,  
															"정말 삭제하겠습니까?", 
															  "삭제 확인 창",
															  JOptionPane.YES_NO_OPTION);
			if( yes_no_select == JOptionPane.YES_OPTION) {
				addBtn.setEnabled(true);   //'추가' 버튼 활성화
				
				JTable tb = showTable.table;
				int deleteRow = tb.getSelectedRow();
				
				if(deleteRow == -1) {
					return;
				}else {  //JTable 객체엇 행을 선택한 경우
					DefaultTableModel model = (DefaultTableModel)tb.getModel();
					model.removeRow(deleteRow);
					
					west.input.tf[0].setText(null);
					west.input.tf[1].setText(null);
					west.input.tf[2].setText(null);
					west.input.tf[3].setText(null);
					west.input.tf[4].setText(null);
					west.input.box.setSelectedIndex(0);
					
					west.output.label[0].setText("     나이:" + "");
					west.output.label[1].setText("     성별:" + "");
					west.output.label[2].setText("     출생지역:" + "");
					west.output.label[3].setText("     생일:" + "");
					west.input.tf[0].requestFocus();
				}
				
			}else {
				return;
			}
			
		}
		
		
		
		
		//'수정' 버튼에서 이벤트가 발생하면 처리하는 메소드
		public void updateData() {
			int updateRow = showTable.table.getSelectedRow();
			
			// '핸드폰번호' 수정할 때
			showTable.table.setValueAt(west.input.tf[2], updateRow, 2);
			
			// '이메일' 수정할 때
			showTable.table.setValueAt(west.input.tf[3], updateRow,3);
			
			// '직업' 수정할 때
			showTable.table.setValueAt(west.input.box.getSelectedItem(), updateRow,9);
			
			west.input.tf[0].setText(null);
			west.input.tf[1].setText(null);
			west.input.tf[2].setText(null);
			west.input.tf[3].setText(null);
			west.input.tf[4].setText(null);
			west.input.box.setSelectedIndex(0);
		
			//데이터 수정 후 다음 데이터를 입력 받기 의해서 주민번호 다시 활성화 시킨다.
			west.input.tf[4].setEditable(true);
			west.input.tf[0].requestFocus(); //포커스를 번호에..
			
			west.output.label[0].setText("    나이:" + "");
			west.output.label[1].setText("    성별:" + "");
			west.output.label[2].setText("    출생지역:" + "");
			west.output.label[3].setText("    생일:" + "");
			
			return;
		}
		
		
		//'추가' 버튼 클릭 시 이벤트 처리 메소드
		public void addData() {
			nextBtn.setEnabled(true); //'다음' 버튼 활성화
			vector = new Vector<String>();
			vector.add(west.input.tf[0].getText()); //번호 입력 값 얻어서 벡터 객체에 추가
			vector.add(west.input.tf[1].getText()); //이름
			vector.add(west.input.tf[2].getText()); //핸드폰번호
			vector.add(west.input.tf[3].getText()); //이메일
			juminNo = west.input.tf[4].getText(); //주민번호
			
			int sum = 0; // 누계 변수는 0으로 초기화
			int[] weight = {2,3,4,5,6,7,0,8,9,2,3,4,5};//가중치
			int temp; 
			int result;
			
			
			String regex = "^[0-9]{6}-[1234][0-9]{6}$";//패턴 만들때 공백 절대 x
			 //[첫번째 방법]
			// boolean check = Pattern.matches(regex,juminNum);
			 
			 //[두번째 방법]
			 boolean check = juminNo.matches(regex);
			 
			 if(check == false) {
				 JOptionPane.showMessageDialog(null,
						                       "주민번호가 정규식 패턴에 맞지 않음"+"\n" + "주민번호를 다시 입력하세요!", 
						                       "에러 메시지", JOptionPane.ERROR_MESSAGE);
				west.input.tf[4].setText(null);
				west.input.tf[4].requestFocus();
				return;
			 }
			 else if(juminNo.length() == 14) {
			 
			/*입력받은 주민번호에 체크 공식 적용
			 * 
			 */
			    //1단계 적용> sum 구하기
		    for(int i=0; i<13; i++) {
		    	if(juminNo.charAt(i) == '-') continue;
		    	    sum += (juminNo.charAt(i)-48) * weight[i];//문자열로 취급해 아스키코드로 계산,실제 9를 구라려면 아스키코드값에서 0값만큼 빼줘야함
		    }	    
		    
			
		    
		    //2단계 공식>temp값이 두 자리인 사람이 있다. 10 or 11
		    
		    temp = 11-(sum%11);
		    
		    //3단계 공식 temp값이 두 자리인 주민번호를 대비해서 한 자리 수로 만들어주기 위해
		    result = temp%10;
		    
		    //주민번호 정상 유무 체크
		    if(result == juminNo.charAt(13)-48) {
		    	JOptionPane.showMessageDialog(null, "주민번호 체크 결과 정상입니다." + "\n" + "'확인' 버튼을 누르면 정보가 출력됩니다.");
		        vector.add(juminNo); //주민번호
		        
		      //"나이"추출
		    	/*
		    	 * 1.현재 년도 파악
	               2. 주민번호 앞 자리의 생년월 일에서 년도 두 자리만 얻어오기=>substring  사용 '97'문자열 정수로 반환 -48 해줘야함
	               3. 주민번호 뒷 자리 첫 번째  자리1, 2, 3, 4 중 하나
	                   if 1,2면 1900을 더해주고 99+1900=1999
	                   3,4면 2000을 더해준다.
	               4. 2021-1999 = 나이추출
		    	 */
		    	//[힌트] Calendar 클래스 적용
		    	Calendar cal = Calendar.getInstance(Locale.KOREA);
		    	int year = cal.get(Calendar.YEAR); //2021 얻음
		    	
		    	int yy = Integer.parseInt(juminNo.substring(0, 2));//년도 두 자리 얻어오기
		    	
		    	if(juminNo.charAt(7)-48 < 3 ) {
		    		yy = yy + 1900;			
		    	}else { 
		    		yy = yy+ 2000;
		    }
		    	 int age = year - yy + 1;
		    
		    // 성별 추출
		    if((juminNo.charAt(7)-48) % 2 == 0 ) {
		    	sung = "여자";
		    }else 
		    {sung = "남자";
		    }
		 // "출신지역" 추출
		    // 지역코드를 2차원 배열로 초기화
		    String[][]localeCode = {{"서울","00","08"},{"부산","09","12"},{"인천","13","15"},
		    		{"경기","16","25"},{"강원","26","34"},{"충북","35","39"},{"대전","40","40"},
		    		{"충남","41","43"},{"충남","45","47"},{"세종","44","44"},{"세종","96","96"},
		    		{"전북","48","54"},{"전남","55","64"},{"광주","65","66"},{"대구","67","70"},
		    		{"경북","71","80"},{"경남","81","84"},{"경남","86","90"},{"울산","85","85"},
		    		{"제주","91","95"}};

		    String localeString = juminNo.substring(8,10);// String 0부터 계산 
	//문자열을 정수로 변환시켜야 
		    int locale = Integer.parseInt(localeString);// 정수로변환시켜주는 parseInt  

		    String birthPlace = null;

		    for(int j = 0; j <= 19; j++) { //

		    	if((locale >= Integer.parseInt(localeCode[j][1])) && locale <= Integer.parseInt(localeCode[j][2])) {// [][]뒤에 [1]은  localecode의 2열을 의미([0]부터 1열을 의미) 

		    		birthPlace = localeCode[j][0];
		    		
		    	}

		    }    
		    
		    vector.add(String.valueOf(age));
		    vector.add(sung);
		    vector.add(birthPlace);
		    vector.add(juminNo.substring(2,4) + "월 " + juminNo.substring(4,6)+"일");
		    
		    west.output.label[0].setText("    나 이: "+ "   " + String.valueOf(age));
		    west.output.label[1].setText("    성 별: "+ "   " + sung);
		    west.output.label[2].setText("   출생지역: "+ "   " + birthPlace);
		    west.output.label[3].setText("    생일: "+ "  " + juminNo.substring(2,4) + "월 " + juminNo.substring(4,6)+"일");
		    
		    vector.add(west.input.box.getSelectedItem().toString());
		    
		    west.input.tf[0].setText(null); //번호
		    west.input.tf[1].setText(null); //이름
		    west.input.tf[2].setText(null); //핸드폰번호
		    west.input.tf[3].setText(null); //이메일
		    west.input.tf[4].setText(null); //주민번호
		    west.input.box.setSelectedIndex(0); //콤보박스 객체에 '선택'으로 원위치
		    west.input.tf[0].requestFocus(); //번호에 포커스를 맞춰라
		    
		    showTable.data.addElement(vector); //> 벡터객체를 추가시켜라
		    showTable.datamodel.fireTableDataChanged();
		  
		    
		    //"생년월일" 추출
		  
		}else {
				 JOptionPane.showMessageDialog(null,
						                       "주민번호가 정규식 패턴에 맞지 않음"+"\n" + "주민번호를 다시 입력하세요!", 
						                       "에러 메시지", JOptionPane.ERROR_MESSAGE);	 
				 west.input.tf[4].setText(null);
				 west.input.tf[4].requestFocus();
				 return;
		   }
	}
		    
    }
			 
			 
		//'검색'버튼 클릭 시이벤트 처리 메소드
		public void searchData() {
			west.output.card.show(west.output, "정보검색 카드");//방법1>>show메소드가 next메소드보다 가독성이 좋다
			//west.output.card.next(west.output);//방법2
		}
		
	} //end Buttons 클래스 ====================================
	//end Buttons 클래스=================
	
	//센터쪽 => Jtable 만들기 => 내부 클래스
	class ShowTable extends MouseAdapter{
		DefaultTableModel datamodel;
		JTable table;
		JScrollPane scrollPane;
		
		String[] colName = {"번호", "이름", "핸드폰번호", "이메일", "주민번호", "나이",
				            "성별", "출생지역", "생일", "직업"};
		Vector<Vector<String>> data; //[중요]
		Vector<String> column_name;
		int row= -1;  //전역변수 선언 
		
		
		//생성자
		public ShowTable() {
			data = new Vector<Vector<String>>();
			column_name = new Vector<String>();
			
			for(int i=0; i<colName.length; i++) {
				column_name.add(colName[i]);
			}
			//1단계
			datamodel = new DefaultTableModel(data, column_name) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
				//2단계
				table = new JTable(datamodel);
				
				//3단계
				scrollPane = new JScrollPane(table);
				
				//이벤트 연걸
				table.addMouseListener(this);
				table.setAutoCreateRowSorter(true);

				TableRowSorter<TableModel> tablesorter = new TableRowSorter<TableModel>(table.getModel());
				
				table.setRowSorter(tablesorter);
				TableSize();
		}// end showTable() 생성자==============================
		
		//필요한 메소드를 수동으로 오버라이드 시키는 방법
		@Override
		public void mouseClicked(MouseEvent e) {
			row = table.getSelectedRow();
			
			//JTable에 있는 데이터를 west 객체의 input 객체의 JTextField 객체 보여주기.
			Info();
		}
		
		public void Info() {
			int row = this.row;
			
			west.input.tf[0].setText((String)showTable.table.getValueAt(row, 0));
			west.input.tf[1].setText((String)showTable.table.getValueAt(row, 1));
			west.input.tf[2].setText((String)showTable.table.getValueAt(row, 2));
			west.input.tf[3].setText((String)showTable.table.getValueAt(row, 3));
			west.input.tf[4].setText((String)showTable.table.getValueAt(row, 4));
			
			//주민번호는 수정 못하게 비활성화 시킨다.
			west.input.tf[4].setEditable(false);
			west.input.box.setSelectedItem(showTable.table.getValueAt(row,9));
			
			west.output.label[0].setText("    나이:" + "    " + showTable.table.getValueAt(row, 5));
			west.output.label[1].setText("    성별:" + "    " + showTable.table.getValueAt(row, 6));
			west.output.label[2].setText("    출생지역:" + "    " + showTable.table.getValueAt(row, 7));
			west.output.label[3].setText("    생일:" + "    " + showTable.table.getValueAt(row, 8));
		
			showTable.table.changeSelection(row, 0, false, false);
		}
		
		
		public void TableSize() {
		// JTable의 셀 크기 조절하는 방법
			table.getColumnModel().getColumn(0).setPreferredWidth(50); //'번호'셀
			table.getColumnModel().getColumn(1).setPreferredWidth(50); //'이름'셀
			table.getColumnModel().getColumn(2).setPreferredWidth(120); //'핸트폰번호'셀
			table.getColumnModel().getColumn(3).setPreferredWidth(150); //'이메일'셀
			table.getColumnModel().getColumn(4).setPreferredWidth(130); //'주민번호'셀
			table.getColumnModel().getColumn(5).setPreferredWidth(50); //'나이'셀
			table.getColumnModel().getColumn(6).setPreferredWidth(50); //'성별'셀
			table.getColumnModel().getColumn(7).setPreferredWidth(80); //'출생지역'셀
			table.getColumnModel().getColumn(8).setPreferredWidth(70); //'생일'셀
			table.getColumnModel().getColumn(9).setPreferredWidth(50); //'직업'셀
		}

	}
	
	
	public static void main(String[] args) {
		
		ManageSystem ms = new ManageSystem();
    }
}
