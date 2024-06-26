package project;

public class Member extends Person {

	private char MembershipType ;
	private String Goal ;

	public Member(String name, int age, char gender, int id, char membershipType, String goal) {
		super(name, age, gender, id);
		MembershipType = membershipType;
		Goal = goal;
	}
public void Print() {
		
		System.out.println("Member's Name: "+ Name);
		System.out.println("Member's Age: "+ Age);
		System.out.println("Member's Gender: "+ Gender);
		System.out.println("Member's ID: "+ ID);
		System.out.println("Membership Type: "+ MembershipType);
		System.out.println("Member's Goal: "+ Goal);
      }

	public char getMembershipType() {
		return MembershipType;
	}

	public String getGoal() {
		return Goal;
	}

}
