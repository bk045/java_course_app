
/**
 * NonAcademicCourse class object holds information about instructor name, duration, starting date, completion date, exam date, prerequisites,
 * and if the course is registered or removed. 
 * These are the information pertaining to Academic course.
 *
 * @author (Bhishan Khatiwoda)
 * @version (1.1)
 */
public class NonAcademicCourse extends Course
{
    /* Attributes of Academic Course.
     * Instance variable are set to private to encapsulate the data.
     * 
     * @instructorName Name of a instructor for Non-academic course.
     * @startDate Starting Date of Non-academic course.
     * @completionDate Completion Date of Non-academic course.
     * @examDate Exam Date for Non-academic course.
     * @prerequisite Prerequisites for Non-academic course.
     * @isRegistered Checks if the Non-academic course is registered.
     * @isRemoved Checks if the Non-academic course is discontinued.
    */
    private String instructorName;
    private String startDate;
    private String completionDate;
    private String examDate;
    private String prerequisite;
    private boolean isRegistered;
    private boolean isRemoved;

    //Constructor to initialize instance variables of non-academic course and also assign duration to super class instance variable.
    public NonAcademicCourse(String courseId, String courseName, short duration, String prerequisite){
        super(courseId, courseName, duration);
        this.prerequisite = prerequisite;
        this.instructorName = "";
        this.startDate = "";
        this.completionDate = "";
        this.examDate="";
        this.isRegistered = false;
        this.isRemoved = false;
        
    }
    
    //Method for retrieving instructor name.
    String getInstructorName(){
    return this.instructorName;
    }
    
    //Method for retrieving start date.
    String getStartDate(){
    return this.startDate;
    }
    
    //Method for retrieving completion date.
    String getCompletionDate(){
    return this.completionDate;
    }
    
    //Method for retrieving prerequisite.
    String getPrerequisite(){
    return this.prerequisite;
    }
    
    //Method for retrieving exam date.
    String getExamDate(){
    return this.examDate;
    }
    
    //Method is used to check if course is registered.
    boolean getIsRegistered(){
    return this.isRegistered;
    }
    
    //Method is used to check if course is removed.
    boolean getIsRemoved(){
    return this.isRemoved;
    }
    
    //Method to set instructor name only if the course is not yet registered.
    public void setInstructorName(String instructorName){
        if (this.isRegistered == false){
            this.instructorName = instructorName;
        }
        else{
            System.out.println("Sorry the course "+ super.getCourseName() + " is already registered therefore not possible to change the instructor name");
        }
    }
    
    //Method to register non-academic course.
    public void registerNonAcademicCourse(String courseLeader, String instructorName, String startDate, String completionDate, String examDate){
      if(this.isRegistered == false){
        super.setCourseLeader(courseLeader);
        setInstructorName(instructorName);
        this.startDate=startDate;
        this.completionDate=completionDate;
        this.examDate=examDate;
        this.isRegistered = true;
        }
      else{
        System.out.println("Sorry "+super.getCourseName() + " course is already registered.");
        }
    }
    
    //Method to remove non-academic course only if it's not removed yet.
     public void removeNonAcademicCourse(){
        if(this.isRemoved == true){
            System.out.println(super.getCourseName() + " course has already been removed");
        }
        else{
        super.setCourseLeader("");
        this.instructorName = "";
        this.startDate = "";
        this.completionDate = "";
        this.examDate = "";
        this.isRegistered= false;
        this.isRemoved = true;
        }
    }
     
    //Method to display partial course details and full details only if non-academic course is registered.
     public void display(){
        System.out.println("CourseID: " + super.getCourseId() );
        System.out.println("Course Name: "+ super.getCourseName());
        System.out.println("Course Duration: "+ super.getCourseDuration()+" month(s)");
        if (this.isRegistered == true){
        System.out.println("Instructor Name: "+ this.instructorName);
        System.out.println("Starting Date: "+ this.startDate);
        System.out.println("Completion Date: "+ this.completionDate);
        System.out.println("Exam Date: "+ this.examDate);        
        }    
    }
}
