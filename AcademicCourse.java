
/**
 * AcademicCourse class object holds information about lecturer name, level, credit, starting date, completion date, no of assessments,
 * and if the course is registered or removed. 
 * These are the information pertaining to Academic course.
 *
 * @author (Bhishan Khatiwoda)
 * @version (1.1)
 */
public class AcademicCourse extends Course
{
    /* Attributes of a Academic Course.
     * Instance variable are set to private to encapsulate the data.
     * 
     * @lecturerName Lecturer Name for Academic Course.
     * @level Level for Academic Course.
     * @credit Credits for Academic Course.
     * @startingDate Starting Date for Academic Course.
     * @completionDate Completion Date for Academic Course.
     * @noOfAssessmets No of assessments for Academic Course.
     * @isRegistered Checks if the Academic Course is registered.
    */
    private String lecturerName;
    private String level;
    private short credit;
    private String startingDate;
    private String completionDate;
    private short noOfAssessments;
    private boolean isRegistered;
    
    //Constructor to initialize instance variables and create Academic class object.
    public AcademicCourse(String courseId, String courseName, short courseDuration, String level, short credit,short noOfAssessments){
        super(courseId, courseName, courseDuration);
        this.level = level;
        this.credit = credit;
        this.noOfAssessments = noOfAssessments;
        this.lecturerName = "";
        this.startingDate = "";
        this.completionDate = "";
        this.isRegistered = false;
    }
    
    //Method for retrieving  lecturer name.
    String getlecturerName(){
    return this.lecturerName;
    }
    
    //Method for retrieving level.
    String getLevel(){
    return this.level;
    }
    
    //Method for retrieving credit.
    short getCredit(){
    return this.credit;
    }
    
    //Method for retrieving no of assessments.
    short getNoOfAssessments(){
    return this.noOfAssessments;
    }
    
    //Method for retrieving starting date.
    String getStartingDate(){
    return this.startingDate;
    }
    
    //Method for retrieving completion date.
    String getCompletionDate(){
    return this.completionDate;
    }
    
    //Method is used to check if course is registered.
    boolean getIsRegistered(){
    return this.isRegistered;
    }
    
    //Method to set lecturer name.
    public void setLecturerName(String newLecturerName){
    this.lecturerName = newLecturerName;
    }
    
    //Method to set no of assessments.
    public void setNoOfAssessments(short newNoOfAssessments){
    this.noOfAssessments = newNoOfAssessments;
    }
    
    //Method to register academic course only if the course is not yet registered.
    public void registerAcademicCourse(String courseLeader, String lecturerName, String startingDate, String completionDate){
            
        if (this.isRegistered==false){
            super.setCourseLeader(courseLeader);
            this.lecturerName = lecturerName;
            this.startingDate= startingDate;
            this.completionDate = completionDate;
            this.isRegistered = true;
        }
        else {
            System.out.println("Sorry the course has already been registered. Following are the details:");
            System.out.println("Lecturer Name: "+this.lecturerName+","+ " Starting Date: "+this.startingDate+","+" Completion Date: "+this.completionDate);
        }
    }
    
    //Method to display entire course information if its registered or else only a partial informaton.
    public void display(){
        super.display();
        if (this.isRegistered == true){
            System.out.println("Lecturer Name: " + this.lecturerName );
            System.out.println("Level: "+ this.level);
            System.out.println("Credit: "+ this.credit);
            System.out.println("Starting Date: "+ this.startingDate);
            System.out.println("Completion Date: "+ this.completionDate);
        }
    }
}
