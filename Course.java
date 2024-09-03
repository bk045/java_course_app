
/**
 * Course class object holds information about course id, course name and course duration. 
 * It has some common information to both Academic and Non-Academic course.
 *
 * @author (Bhishan Khatiwoda)
 * @version (1.0)
 */
public class Course
{
    /* Attributes of a Course.
     * Instance variable are set to private to encapsulate  the data.
     * 
     * @courseId Course ID for a course.
     * @courseName Course Name of course.
     * @courseDuration Course Duration  of a course.
     * @courseLeader Course Leader for a course.
    */
    private String courseId;
    private String courseName;
    private short courseDuration;
    private String courseLeader;
    
    //Constructor to initialize instance variable and to create Course object.
    public Course(String courseID, String courseName, short courseDuration ){
        this.courseId = courseID;
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this. courseLeader = "";   
    }
    
    //Method for retrieving  course id.
    String getCourseId(){
    return this.courseId;
    }
    
    //Method for retrieving  course name.
    String getCourseName(){
    return this.courseName;
    }
    
    //Method for retrieving  course duration.
    short getCourseDuration(){
    return this.courseDuration;
    }
    
    //Method for retrieving  course leader.
    String getCourseLeader(){
    return this.courseLeader;
    }
    
    //Method to set name of course leader.
    public void setCourseLeader(String nameOfCourseLeader){
    this.courseLeader = nameOfCourseLeader;
    }
    
    //Displays all the attributes of the class.
    public void display(){
        System.out.println("Course ID: " + this.courseId);
        System.out.println("Course Name: " + this.courseName);
        System.out.println("Course Duration: " + this.courseDuration +" month(s)");
        int length = this.courseLeader.length();
        if (this.courseLeader.length()==0){
            System.out.println("Course Leader: " + this.courseLeader);
        }
    }
}
