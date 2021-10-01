package 플레이어;

public class Player {
	public String userName;
	public PlayerLevel playerLevel;
	public String level;
	
	//생성자 (only name), 레벨 Beginner부터 시작
	Player(String userName){
		this.playerLevel = new BeginnerLevel();
		this.userName = userName;
		level = "BeginnerLevel";
	}
	
	//생성자( name, level) , 지정한 레벨부터 시작
	Player(String userName, String level){
		this.userName = userName;
		this.level = level;
		if (level == "BeginnerLevel") this.playerLevel = new BeginnerLevel();
		else if (level == "IntermediateLevel") this.playerLevel = new IntermediateLevel(); 
		else if (level == "AdvancedLevel") this.playerLevel = new AdvancedLevel();
	}
	
	//사용자 레벨업.
	public void levelUp() {
		//사용자 지금 레베릉ㄴ 무엇임비다.
		System.out.print("사용자 레벨이 " + level + " 에서 ");
		if (level == "BeginnerLevel") {
			this.playerLevel = new IntermediateLevel();
			this.level = "IntermediateLevel";
			System.out.println(level + " 로 올랐습니다.");
		}
		else if (level == "IntermediateLevel") {
			this.playerLevel = new AdvancedLevel();
			this.level = "AdvancedLevel";
		}
		else if (level == "AdvancedLevel") {
			System.out.println("최고레벨 입니다!!");
			System.out.println("===============");
		}
		//어던걸로 레벨업 했습ㅈ니다.
	}
	
	//정보 제공. PlayerLevel.go() 포함되어있음.
	public void showInfo(int count) {
		System.out.println("사용자 이름은 : " + userName + " 입니다.");
		System.out.println("사용자 레벨은 : " + level + " 입니다.");
		this.playerLevel.go(count);
	}
	
	
}
