import java.util.Scanner;

public class Mainclass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Institution inst[]= new Institution[4];
		
		for(int i=0;i<inst.length;i++) {
			inst[i]=new Institution(sc.nextInt(),sc.next(),sc.nextInt(),sc.nextInt(),sc.next());
		}
		String loc = sc.next();
		 String instname = sc.next();
		int result=findNumClearancedByLoc(inst,loc);
         if(result>0) {
        	 System.out.println(result);
         }else {
        	 System.out.println("There are no cleared students in this particular location");
         }
         Institution ins = updateInstitutionGrade(inst,instname);
         if(ins!=null) {
        	 System.out.println(ins.getInstitutionName()+"::"+ins.getGrade());
         }else {
        	 System.out.println("No Institute is available with the specified name");
         }
         sc.close();
	}
	static int findNumClearancedByLoc(Institution inst[],String loc) {
		int sum=0;
		for(int i=0;i<inst.length;i++) {
			if(inst[i].getLocation().equalsIgnoreCase(loc)) {
				sum+=inst[i].getNoOfStudentsCleared();
			}
		}
		if(sum==0) {
			return 0;
		}else {
			return sum;
		}
	}
	static  Institution updateInstitutionGrade(Institution inst[],String instname){
		int rating=0;
		for(int i=0;i<inst.length;i++) {
			if(inst[i].getInstitutionName().equalsIgnoreCase(instname)) {
	
				rating=(inst[i].getNoOfStudentsPlaced()*100)/inst[i].getNoOfStudentsCleared();
				if (rating>=80) {
					inst[i].setGrade("A");
				}else {
					inst[i].setGrade("B");
				}
				return inst[i];
			}
		
		}
	
			return null;

	}

}
class Institution{
	private String institutionName;
	private int noOfStudentsPlaced;
	private int noOfStudentsCleared;
	private String location;
	private String grade;
	private int institutionId;
     
	public Institution(int institutionId,String institutionName,int noOfStudentsPlaced, int noOfStudentsCleared,String location) {
		this.institutionName=institutionName;
		this.noOfStudentsPlaced=noOfStudentsPlaced;
		this.noOfStudentsCleared=noOfStudentsCleared;
		this.location=location;
		this.institutionId=institutionId;
	}
	
	public int getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(int institutionId) {
		this.institutionId = institutionId;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public int getNoOfStudentsPlaced() {
		return noOfStudentsPlaced;
	}
	public void setNoOfStudentsPlaced(int noOfStudentsPlaced) {
		this.noOfStudentsPlaced = noOfStudentsPlaced;
	}
	public int getNoOfStudentsCleared() {
		return noOfStudentsCleared;
	}
	public void setNoOfStudentsCleared(int noOfStudentsCleared) {
		this.noOfStudentsCleared = noOfStudentsCleared;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}