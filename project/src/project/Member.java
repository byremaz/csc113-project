package project;

public class Member extends Person {

	private int MemberID ;
	private char MembershipType ;
	private String Goal ;

	public Member(String name, int age, char gender, int memberID, char membershipType, String goal) {
		super(name, age, gender);
		MemberID = memberID;
		MembershipType = membershipType;
		Goal = goal;
	}

	public void Print() {
		
		System.out.println("Member Name: "+ Name);
		System.out.println("Member Age: "+ Age);
		System.out.println("Member Gender: "+ Gender);
		System.out.println("Member ID: "+ MemberID);
		System.out.println("Membership Type: "+ MembershipType);
		System.out.println("Member Goal: "+ Goal);

	}

	public int getMemberID() {
		return MemberID;
	}

	public char getMembershipType() {
		return MembershipType;
	}

	public String getGoal() {
		return Goal;
	}

}
