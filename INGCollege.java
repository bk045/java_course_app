import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridBagLayout;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.util.ListIterator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Dimension;


/**
 * INGCollege Class constructor, creates three frames with multiple panels. It accomodates various components.
 * Along with constructor it has other
 * methods to perform task on particular event.
 * @author (Bhishan Khatiwoda)
 * @version (INGCollege Course Registratoin Form - 1.01)
 */
 @SuppressWarnings({"static", "serial"})
class INGCollege extends JFrame implements ActionListener
{

    private JFrame frameMain, frameRegAC, frameRegNAC;

    private JLabel titleAcademic, titleNonAcademic, titleRegAcademic, titleRegNonAcademic,

          labelCourseID, labelCourseName, labelCourseDuration, labelInWeeks,
          labelLevel, labelCredit, labelNoOfAssessments, labelRegCourseID,
          labelStartDate, labelCompletionDate, labelShowCourse, labelCourseLeader,
          labelLecturerName, labelRegCourseName,

          labelCourseID_NAC,labelInWeeks_NAC, labelCourseName_NAC,
          labelCourseDuration_NAC, labelPrerequisite_NAC, labelRegCourseID_NAC,
          labelStartDate_NAC, labelInstructor_NAC, labelShowCourse_NAC,
          labelCompletionDate_NAC, labelExamDate_NAC, labelCourseLeader_NAC, labelRegCourseName_NAC;

    private JTextField textCourseID, textCourseName, textCourseDuration, textLevel,
            textCredit, textNoOfAssessments, textInstructor, textCourseLeader, textLecturerName,
            textRegCourseName, textStartDate, textFinishDate,

            textCourseID_NAC, textCourseName_NAC, textCourseDuration_NAC, textCourseLeader_NAC, textRegCourseName_NAC,
            textStartDate_NAC, textFinishDate_NAC, textExamDate_NAC;

    private JComboBox<String> comboCourseID, comboCourseID_NAC;

    private JButton btnAdd, btnClear, btnRegister, btnDisplay, btnNext, btnPrevious,
          btnLast, btnFirst, btnUpdate, btnCancel,
          btnAdd_NAC, btnClear_NAC, btnRegister_NAC, btnDisplay_NAC,
          btnNext_NAC, btnPrevious_NAC, btnLast_NAC, btnFirst_NAC,
          btnUpdate_NAC, btnCancel_NAC, btnRemove_NAC;

    private JTextArea textAreaPrerequisite_NAC, textAreaDisplay, textAreaDisplay_NAC;

    private JRadioButton radioLevelC, radioLevelH, radioLevelM;
    private ButtonGroup levelGroup;

    private GridBagConstraints gbc;

    private JTabbedPane cards;

    private JPanel cardAcademic, cardNonAcademic, regPanel, regPanel_NAC,
            titlePanel, buttonsPanel, displayBtnPanel,
            componentsPanel, durationPanel, radioPanel,
            componentsPanel_NAC, durationPanel_NAC,
            titlePanel_NAC, buttonsPanel_NAC, displayBtnPanel_NAC;

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem openMItem, exitMItem;


    private String[] yearList = {"2015", "2016", "2017", "2018", "2019", "2020", "2021",
                          "2022", "2023", "2024", "2025", "2026"};
    private String[] monthList = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July",
                          "Aug", "Sep", "Oct", "Nov", "Dec"};

    private ArrayList<Course> ACADEMIC_COURSES = new ArrayList<Course>();
    public ArrayList<Course> NON_ACADEMIC_COURSES = new ArrayList<Course>();

    //Final Values for Colors
    private final Color WARNING_COLOR = new Color (245, 34, 34);
    private final Color NORMAL_COLOR = new Color (52, 120, 34);
    private final Color REG_COLOR = new Color (4, 62, 179);

    //Defining Dimensions
    private final Dimension BTN_BIG = new Dimension(100, 35);
    private final Dimension BTN_SMALL = new Dimension(60, 35);
    private final Dimension FIELD_SMALL = new Dimension(100,35);
    private final Dimension FIELD_BIG = new Dimension(300, 35);

    //Defining Font Objects
    private final Font TITLE_FONT = new Font("Serif", Font.BOLD, 25);
    private final Font LABEL_FONT = new Font("Serif", Font.BOLD, 18);

    public INGCollege()
    {
      frameMain = new JFrame("ING-College Course Registration Form");
      frameRegAC = new JFrame("Register Academic Course");
      frameRegNAC = new JFrame("Register Non-Academic Course");

      frameMain.setSize(985, 500);
      frameRegAC.setSize(480, 450);
      frameRegNAC.setSize(490, 500);

      frameMain.setLocationRelativeTo(null);
      frameRegAC.setLocationRelativeTo(null);
      frameRegNAC.setLocationRelativeTo(null);

      frameMain.setDefaultCloseOperation(frameMain.EXIT_ON_CLOSE);
      frameRegAC.setDefaultCloseOperation(frameMain.HIDE_ON_CLOSE);
      frameRegNAC.setDefaultCloseOperation(frameMain.HIDE_ON_CLOSE);

      frameMain.setResizable(false);
      frameRegAC.setResizable(false);
      frameRegNAC.setResizable(false);

      //Setting MenuBar
      menuBar = new JMenuBar();
      frameMain.setJMenuBar(menuBar);

      fileMenu = new JMenu("File");
      openMItem = new JMenuItem("Open");
      exitMItem = new JMenuItem("Exit");
      exitMItem.addActionListener(this);

      menuBar.add(fileMenu);
      fileMenu.add(openMItem);
      fileMenu.add(exitMItem);

      //Defining GridBagConstraints of GrigBag Layout
      gbc = new GridBagConstraints();
      gbc.anchor = GridBagConstraints.LINE_START;
      gbc.fill = GridBagConstraints.VERTICAL;
      gbc.insets = new Insets(0, 0, 15, 10);

      //Academic Components Panel
      componentsPanel = new JPanel();
      componentsPanel.setLayout(new GridBagLayout());

      //CourseID ACADEMIC
      textCourseID = new JTextField();
      textCourseID.setPreferredSize(FIELD_SMALL);
      labelCourseID = new JLabel("Course ID:");

      //Course Name ACADEMIC
      textCourseName = new JTextField();
      textCourseName.setPreferredSize(FIELD_BIG);
      labelCourseName = new JLabel("Course Name:");

      //Course Duration (In Weeks) ACADEMIC
      labelCourseDuration = new JLabel("Course Duration:");
      durationPanel = new JPanel();
      textCourseDuration = new JTextField();
      textCourseDuration.setPreferredSize(FIELD_SMALL);
      labelInWeeks = new JLabel(" weeks");
      durationPanel.add(textCourseDuration);
      durationPanel.add(labelInWeeks);
      durationPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

      //Course Level(Radio Buttons) ACADEMIC
      levelGroup = new ButtonGroup();
      labelLevel = new JLabel("Level:");
      radioLevelC = new JRadioButton("Level-C");
      radioLevelC.setSelected(true);
      radioLevelH = new JRadioButton("Level-H");
      radioLevelM = new JRadioButton("Level-M");
      levelGroup.add(radioLevelC); levelGroup.add(radioLevelH); levelGroup.add(radioLevelM);
      radioPanel = new JPanel();
      radioPanel.add(radioLevelC);
      radioPanel.add(radioLevelH);
      radioPanel.add(radioLevelM);
      radioPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

      //Course Credit ACADEMIC
      labelCredit = new JLabel("Credit:");
      textCredit = new JTextField();
      textCredit.setPreferredSize(FIELD_SMALL);

      //Course No of Assessments ACADEMIC
      labelNoOfAssessments = new JLabel("No of Assessments:");
      textNoOfAssessments = new JTextField();
      textNoOfAssessments.setPreferredSize(FIELD_SMALL);

      gbc.anchor = GridBagConstraints.LINE_START;
      gbc.gridx = 0;
      gbc.gridy = 0;
      componentsPanel.add(labelCourseID, gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      componentsPanel.add(labelCourseName, gbc);
      gbc.gridx = 0;
      gbc.gridy = 2;
      componentsPanel.add(labelCourseDuration, gbc);
      gbc.gridx = 0;
      gbc.gridy = 3;
      componentsPanel.add(labelLevel,gbc);
      gbc.gridx = 0;
      gbc.gridy = 4;
      componentsPanel.add(labelCredit, gbc);
      gbc.gridx = 0;
      gbc.gridy = 5;
      componentsPanel.add(labelNoOfAssessments, gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      componentsPanel.add(textCourseID, gbc);
      gbc.gridx = 1;
      gbc.gridy = 1;
      componentsPanel.add(textCourseName, gbc);
      gbc.gridx = 1;
      gbc.gridy = 2;
      componentsPanel.add(durationPanel, gbc);
      gbc.gridx = 1;
      gbc.gridy = 3;
      componentsPanel.add(radioPanel, gbc);
      gbc.gridx = 1;
      gbc.gridy = 4;
      componentsPanel.add(textCredit, gbc);
      gbc.gridx = 1;
      gbc.gridy = 5;
      componentsPanel.add(textNoOfAssessments, gbc);

      //Non-Academic Components Panel
      componentsPanel_NAC = new JPanel();
      componentsPanel_NAC.setLayout(new GridBagLayout());

      //CourseID NAC
      labelCourseID_NAC= new JLabel("Course ID:");
      textCourseID_NAC = new JTextField();
      textCourseID_NAC.setPreferredSize(FIELD_SMALL);

      //Course Name NAC
      labelCourseName_NAC = new JLabel("Course Name:");
      textCourseName_NAC = new JTextField();
      textCourseName_NAC.setPreferredSize(FIELD_BIG);

      //Course Duration NAC
      labelCourseDuration_NAC = new JLabel("Course Duration:");
      labelInWeeks_NAC = new JLabel(" weeks");
      textCourseDuration_NAC = new JTextField();
      textCourseDuration_NAC.setPreferredSize(FIELD_SMALL);
      durationPanel_NAC = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
      durationPanel_NAC.add(textCourseDuration_NAC);
      durationPanel_NAC.add(labelInWeeks_NAC);

      //Course Pre-requisite NAC
      labelPrerequisite_NAC = new JLabel("Pre-requesite:");
      textAreaPrerequisite_NAC = new JTextArea();
      textAreaPrerequisite_NAC.setPreferredSize(new Dimension(300,125));

      //Positioning Components NAC
      gbc.gridx = 0;
      gbc.gridy = 0;
      componentsPanel_NAC.add(labelCourseID_NAC, gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      componentsPanel_NAC.add(labelCourseName_NAC, gbc);
      gbc.gridx = 0;
      gbc.gridy = 2;
      componentsPanel_NAC.add(labelCourseDuration_NAC, gbc);
      gbc.gridx = 0;
      gbc.gridy = 3;
      componentsPanel_NAC.add(labelPrerequisite_NAC, gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      componentsPanel_NAC.add(textCourseID_NAC, gbc);
      gbc.gridx = 1;
      gbc.gridy = 1;
      componentsPanel_NAC.add(textCourseName_NAC, gbc);
      gbc.gridx = 1;
      gbc.gridy = 2;
      componentsPanel_NAC.add(durationPanel_NAC, gbc);
      gbc.gridx = 1;
      gbc.gridy = 3;
      componentsPanel_NAC.add(textAreaPrerequisite_NAC, gbc);

      //Display Text Area
      textAreaDisplay = new JTextArea(70,35);
      textAreaDisplay.setFont(new Font("Serif", Font.PLAIN, 15));
      textAreaDisplay.setMargin(new Insets(5, 10, 2, 5));
      textAreaDisplay.setLineWrap(true);
      textAreaDisplay.setWrapStyleWord(true);
      textAreaDisplay.setEditable(false);

      textAreaDisplay_NAC = new JTextArea(80,35);
      textAreaDisplay_NAC.setFont(new Font("Serif", Font.PLAIN, 15));
      textAreaDisplay_NAC.setMargin(new Insets(5, 10, 2, 5));
      textAreaDisplay_NAC.setLineWrap(true);
      textAreaDisplay_NAC.setWrapStyleWord(true);
      textAreaDisplay_NAC.setEditable(false);

      // Academic Registeration Panel
      regPanel = new JPanel();
      regPanel.setLayout(null);

      titleRegAcademic = new JLabel("Academic Course Registration");
      titleRegAcademic.setFont(TITLE_FONT);
      regPanel.add(titleRegAcademic);
      titleRegAcademic.setBounds(80, 5, 350, 35);

      labelRegCourseID = new JLabel("Course ID:");
      regPanel.add(labelRegCourseID);
      labelRegCourseID.setBounds(25, 50, 100, 30);

      labelShowCourse = new JLabel("");
      labelShowCourse.setFont(LABEL_FONT);
      labelShowCourse.setForeground(NORMAL_COLOR.darker());
      regPanel.add(labelShowCourse);
      labelShowCourse.setBounds(25, 100, 450, 30);

      labelCourseLeader = new JLabel("Course Leader:");
      regPanel.add(labelCourseLeader);
      labelCourseLeader.setBounds(25, 150, 100, 30);

      labelLecturerName = new JLabel("Lecturer Name:");
      regPanel.add(labelLecturerName);
      labelLecturerName.setBounds(25, 200, 150, 30);

      labelStartDate = new JLabel("Starting Date:");
      regPanel.add(labelStartDate);
      labelStartDate.setBounds(25, 250, 100, 30);

      labelCompletionDate = new JLabel("Completion Date:");
      regPanel.add(labelCompletionDate);
      labelCompletionDate.setBounds(25, 300, 150, 30);

      String[] firstItem = {"Select Course ID"};
      comboCourseID = new JComboBox<String>(firstItem);
      regPanel.add(comboCourseID);
      comboCourseID.setBounds(200, 50, 180, 30);
      comboCourseID.addActionListener(new ActionListener ()
      {
          //Method to get selected item from combo-box and display relevant information.
          public void actionPerformed(ActionEvent ae){
                Object selected = comboCourseID.getSelectedItem();
                String item = selected.toString();
                if(!(item.equals("Select Course ID"))){
                    String id = selected.toString();
                    int index = getPointerOfObject(id, ACADEMIC_COURSES);
                    AcademicCourse aCourse = (AcademicCourse)ACADEMIC_COURSES.get(index);
                    String courseName = aCourse.getCourseName();
                   if(aCourse.getIsRegistered()){
                        labelShowCourse.setText("Sorry!!! "+ courseName+" has already been registered!!!");
                        labelShowCourse.setForeground(REG_COLOR);
                    }
                    else{
                        labelShowCourse.setText("You have selected "+ courseName+".");
                        labelShowCourse.setForeground(NORMAL_COLOR);
                    }
                }
                else{
                    labelShowCourse.setText("Please select a course ID.");
                    labelShowCourse.setForeground(NORMAL_COLOR);
                }
            }
        });

      textCourseLeader = new JTextField(25);
      regPanel.add(textCourseLeader);
      textCourseLeader.setBounds(200, 150, 250, 37);

      textLecturerName = new JTextField(25);
      regPanel.add(textLecturerName);
      textLecturerName.setBounds(200, 200, 250, 37);

      textStartDate = new JTextField(20);
      regPanel.add(textStartDate);
      textStartDate.setBounds(200, 250, 200, 37);

      textFinishDate = new JTextField(20);
      regPanel.add(textFinishDate);
      textFinishDate.setBounds(200, 300, 200, 37);

      btnUpdate = new JButton("Update Course");
      regPanel.add(btnUpdate);
      btnUpdate.setBounds(50, 370, 140, 37);
      btnUpdate.addActionListener(new ActionListener ()
      {
            public void actionPerformed(ActionEvent ae)
            {
                updateAcademicCourse();
            }
        });

      btnCancel = new JButton("Cancel");
      regPanel.add(btnCancel);
      btnCancel.setBounds(300, 370, 140, 37);
      btnCancel.addActionListener(new ActionListener ()
      {
            public void actionPerformed(ActionEvent ae)
            {
                clearAllFieldsOfRegAcademic();
                frameRegAC.dispose();
            }
        });

      // Non-Academic Registeration Panel
      regPanel_NAC = new JPanel();
      regPanel_NAC.setLayout(null);

      titleRegNonAcademic = new JLabel("Non-Academic Course Registration");
      titleRegNonAcademic.setFont(TITLE_FONT);
      regPanel_NAC.add(titleRegNonAcademic);
      titleRegNonAcademic.setBounds(60, 5, 400, 35);

      labelRegCourseID_NAC = new JLabel("Course ID:");
      regPanel_NAC.add(labelRegCourseID_NAC);
      labelRegCourseID_NAC.setBounds(25, 50, 100, 30);

      labelShowCourse_NAC = new JLabel("");
      labelShowCourse_NAC.setFont(LABEL_FONT);
      labelShowCourse_NAC.setForeground(NORMAL_COLOR);
      regPanel_NAC.add(labelShowCourse_NAC);
      labelShowCourse_NAC.setBounds(25, 100, 450, 30);

      labelCourseLeader_NAC = new JLabel("Course Leader:");
      regPanel_NAC.add(labelCourseLeader_NAC);
      labelCourseLeader_NAC.setBounds(25, 150, 100, 30);

      labelInstructor_NAC = new JLabel("Instructor:");
      regPanel_NAC.add(labelInstructor_NAC);
      labelInstructor_NAC.setBounds(25, 200, 100, 30);

      labelStartDate_NAC = new JLabel("Starting Date");
      regPanel_NAC.add(labelStartDate_NAC);
      labelStartDate_NAC.setBounds(25, 250, 100, 30);

      labelCompletionDate_NAC = new JLabel("Completion Date:");
      regPanel_NAC.add(labelCompletionDate_NAC);
      labelCompletionDate_NAC.setBounds(25, 300, 150, 30);

      labelExamDate_NAC = new JLabel("Exam Date:");
      regPanel_NAC.add(labelExamDate_NAC);
      labelExamDate_NAC.setBounds(25, 350, 150, 30);

      String[] firstItem_NAC = {"Select Course ID"};
      comboCourseID_NAC = new JComboBox<String>(firstItem);
      regPanel_NAC.add(comboCourseID_NAC);
      comboCourseID_NAC.setBounds(200, 50, 180, 30);
      comboCourseID_NAC.addActionListener(new ActionListener ()
      {
          //Method to get selected item from combo-box and display relevant information.
          public void actionPerformed(ActionEvent ae){
                Object selected = comboCourseID_NAC.getSelectedItem();
                String item = selected.toString();
                if(!(item.equals("Select Course ID"))){
                    String id = selected.toString();
                    int index = getPointerOfObject(id, NON_ACADEMIC_COURSES);
                    NonAcademicCourse naCourse = (NonAcademicCourse)NON_ACADEMIC_COURSES.get(index);
                    String courseName = naCourse.getCourseName();
                   if(naCourse.getIsRegistered()){
                        labelShowCourse_NAC.setText("Sorry!!! "+ courseName+" has already been registered!!!");
                        labelShowCourse_NAC.setForeground(REG_COLOR);
                    }
                   else if(naCourse.getIsRemoved()){
                        labelShowCourse_NAC.setText("Sorry!!! "+ courseName+" has already been removed!!!");
                        labelShowCourse_NAC.setForeground(WARNING_COLOR);
                    }
                   else{
                        labelShowCourse_NAC.setText("You have selected "+ courseName+".");
                        labelShowCourse_NAC.setForeground(NORMAL_COLOR);
                    }
                }
                else{
                    labelShowCourse_NAC.setText("Please select a course ID.");
                    labelShowCourse_NAC.setForeground(NORMAL_COLOR);
                }
            }
        });

      textCourseLeader_NAC = new JTextField(25);
      regPanel_NAC.add(textCourseLeader_NAC);
      textCourseLeader_NAC.setBounds(200, 150, 250, 37);

      textInstructor = new JTextField(25);
      regPanel_NAC.add(textInstructor);
      textInstructor.setBounds(200, 200, 250, 37);

      textStartDate_NAC = new JTextField(20);
      regPanel_NAC.add(textStartDate_NAC);
      textStartDate_NAC.setBounds(200, 250, 200, 37);

      textFinishDate_NAC = new JTextField(20);
      regPanel_NAC.add(textFinishDate_NAC);
      textFinishDate_NAC.setBounds(200, 300, 200, 37);

      textExamDate_NAC = new JTextField(20);
      regPanel_NAC.add(textExamDate_NAC);
      textExamDate_NAC.setBounds(200, 350, 200, 37);

      btnUpdate_NAC = new JButton("Update Course");
      regPanel_NAC.add(btnUpdate_NAC);
      btnUpdate_NAC.setBounds(50, 420, 140, 37);
      btnUpdate_NAC.addActionListener(new ActionListener ()
      {
            public void actionPerformed(ActionEvent ae)
            {
                updateNonAcademicCourse();
            }
        });

      btnCancel_NAC = new JButton("Cancel");
      regPanel_NAC.add(btnCancel_NAC);
      btnCancel_NAC.setBounds(300, 420, 140, 37);
      btnCancel_NAC.addActionListener(new ActionListener ()
      {
            public void actionPerformed(ActionEvent ae)
            {
                clearAllFieldsOfRegNonAcademic();
                frameRegNAC.dispose();
            }
        });

      //Buttons Panel Academic
      buttonsPanel = new JPanel();
      buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 32, 5));

      btnAdd = new JButton("Add");
      btnAdd.setPreferredSize(BTN_BIG);
      btnAdd.addActionListener(new ActionListener()
      {
            public void actionPerformed(ActionEvent ae)
            {
             addAcademicCourse();
            }
      });

      btnClear = new JButton("Clear");
      btnClear.setPreferredSize(BTN_BIG);
      btnClear.addActionListener(new ActionListener()
      {
            public void actionPerformed(ActionEvent ae)
            {
                clearAllFieldsOfAcademicCourse();
            }
        });

      btnRegister = new JButton("Register");
      btnRegister.setPreferredSize(BTN_BIG);
      btnRegister.addActionListener(new ActionListener()
      {     //Populates the combo-box with all courseID and opens appropriate registration form.
            public void actionPerformed(ActionEvent ae)
            {
                if(!(comboCourseID.equals(null)) && !isListEmpty(ACADEMIC_COURSES)){
                    for (int j = 0; j < ACADEMIC_COURSES.size(); j++){
                        AcademicCourse course = (AcademicCourse)ACADEMIC_COURSES.get(j);
                        String courseID = course.getCourseId();
                        int itemExists = 0;
                        for(int i = 0; i < comboCourseID.getItemCount(); i ++){
                            String comboItem = String.valueOf(comboCourseID.getItemAt(i));
                            if(courseID.equals(comboItem)){
                                itemExists += 1;
                            }
                        }
                        if (itemExists == 0){
                            comboCourseID.addItem(courseID);
                        }
                    }
                }
                frameRegAC.setVisible(true);
            }
        });

      btnDisplay = new JButton("Display");
      btnDisplay.setPreferredSize(BTN_BIG);
      btnDisplay.setEnabled(false);
      btnDisplay.addActionListener(new ActionListener()
      {
            public void actionPerformed(ActionEvent ae)
            {
                displayCourseContent(ACADEMIC_COURSES.get(0));
            }
        });
      displayBtnPanel = new JPanel();
      displayBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 5));

      btnFirst = new JButton("|<");
      btnFirst.setPreferredSize(BTN_SMALL);
      btnFirst.setEnabled(false);
      btnFirst.addActionListener(new ActionListener()
      {
            public void actionPerformed(ActionEvent ae)
            {
                displayCourseContent(ACADEMIC_COURSES.get(0));
            }
        });

      btnPrevious = new JButton("<<");
      btnPrevious.setPreferredSize(BTN_SMALL);
      btnPrevious.setEnabled(false);
      btnPrevious.addActionListener(new ActionListener()
      {
            public void actionPerformed(ActionEvent ae)
            {
                if (!(textAreaDisplay.getText().isEmpty())){
                    getPreviousItem(ACADEMIC_COURSES);
                }
                else{
                    displayCourseContent(ACADEMIC_COURSES.get(0));
                }
            }
        });

      btnNext = new JButton(">>");
      btnNext.setPreferredSize(BTN_SMALL);
      btnNext.setEnabled(false);
      btnNext.addActionListener(new ActionListener()
      {
            public void actionPerformed(ActionEvent ae)
            {
                if (!(textAreaDisplay.getText().isEmpty())){
                    getNextItem(ACADEMIC_COURSES);
                }
                else{
                    displayCourseContent(ACADEMIC_COURSES.get(0));
                }
            }
        });

      btnLast = new JButton(">|");
      btnLast.setPreferredSize(BTN_SMALL);
      btnLast.setEnabled(false);
      btnLast.addActionListener(new ActionListener()
      {
            public void actionPerformed(ActionEvent ae)
            {
                displayCourseContent(ACADEMIC_COURSES.get(ACADEMIC_COURSES.size()-1));
            }
        });
      displayBtnPanel.add(btnFirst); displayBtnPanel.add(btnPrevious);
      displayBtnPanel.add(btnNext); displayBtnPanel.add(btnLast);

      buttonsPanel.add(btnAdd); buttonsPanel.add(btnRegister);
      buttonsPanel.add(btnClear); buttonsPanel.add(btnDisplay);
      buttonsPanel.add(displayBtnPanel);

      //Buttons Panel Non-Academic
      buttonsPanel_NAC = new JPanel();
      buttonsPanel_NAC.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 5));

      btnAdd_NAC = new JButton("Add");
      btnAdd_NAC.setPreferredSize(BTN_BIG);
      btnAdd_NAC.addActionListener(new ActionListener()
      {
            public void actionPerformed(ActionEvent ae)
            {
                addNonAcademicCourse();
            }
        });

      btnRegister_NAC = new JButton("Register");
      btnRegister_NAC.setPreferredSize(BTN_BIG);
      btnRegister_NAC.addActionListener(new ActionListener()
      {
            public void actionPerformed(ActionEvent ae)
            {   //Populates the combo-box with all courseID and opens appropriate registration form.
                if(!(comboCourseID_NAC.equals(null)) && !isListEmpty(NON_ACADEMIC_COURSES)){
                    for (int j = 0; j < NON_ACADEMIC_COURSES.size(); j++){
                        NonAcademicCourse course = (NonAcademicCourse)NON_ACADEMIC_COURSES.get(j);
                        String courseID = course.getCourseId();
                        int itemExists = 0;
                        for(int i = 0; i < comboCourseID_NAC.getItemCount(); i ++){
                            String comboItem = String.valueOf(comboCourseID_NAC.getItemAt(i));
                            if(courseID.equals(comboItem)){
                                itemExists += 1;
                            }
                        }
                        if (itemExists == 0){
                            comboCourseID_NAC.addItem(courseID);
                        }

                    }
                }
                frameRegNAC.setVisible(true);
            }
        });

      btnClear_NAC = new JButton("Clear");
      btnClear_NAC.setPreferredSize(BTN_BIG);
      btnClear_NAC.addActionListener(new ActionListener()
      {
            public void actionPerformed(ActionEvent ae)
            {
                clearAllFieldsOfNonAcademicCourse();
                btnRemove_NAC.setEnabled(false);
            }
        });

      btnRemove_NAC = new JButton("Remove");
      btnRemove_NAC.setPreferredSize(BTN_BIG);
      btnRemove_NAC.setEnabled(false);
      btnRemove_NAC.addActionListener(new ActionListener()
      {
            public void actionPerformed(ActionEvent ae)
            {
                removeNonAcademicCourse();
                if (textAreaDisplay_NAC.getText().isEmpty()){
                    btnRemove_NAC.setEnabled(false);
                }
            }
        });

      btnDisplay_NAC = new JButton("Display");
      btnDisplay_NAC.setPreferredSize(BTN_BIG);
      btnDisplay_NAC.setEnabled(false);

      btnDisplay_NAC.addActionListener(new ActionListener()
      {
            public void actionPerformed(ActionEvent ae)
            {
                displayCourseContent(NON_ACADEMIC_COURSES.get(0));
                btnRemove_NAC.setEnabled(true);
            }
        });

      displayBtnPanel_NAC = new JPanel();
      displayBtnPanel_NAC.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      btnFirst_NAC = new JButton("|<");
      btnFirst_NAC.setPreferredSize(BTN_SMALL);
      btnFirst_NAC.setEnabled(false);
      btnFirst_NAC.addActionListener(new ActionListener()
      {
            public void actionPerformed(ActionEvent ae)
            {
                displayCourseContent(NON_ACADEMIC_COURSES.get(0));
                btnRemove_NAC.setEnabled(true);
            }
        });

      btnPrevious_NAC = new JButton("<<");
      btnPrevious_NAC.setPreferredSize(BTN_SMALL);
      btnPrevious_NAC.setEnabled(false);
      btnPrevious_NAC.addActionListener(new ActionListener()
      {
            public void actionPerformed(ActionEvent ae)
            {
                    if (!(textAreaDisplay_NAC.getText().isEmpty())){
                        getPreviousItem(NON_ACADEMIC_COURSES);
                        btnRemove_NAC.setEnabled(true);
                    }
                    else{
                        displayCourseContent(NON_ACADEMIC_COURSES.get(0));
                        btnRemove_NAC.setEnabled(true);
                    }
            }
        });

      btnNext_NAC = new JButton(">>");
      btnNext_NAC.setPreferredSize(BTN_SMALL);
      btnNext_NAC.setEnabled(false);
      btnNext_NAC.addActionListener(new ActionListener()
      {
            public void actionPerformed(ActionEvent ae)
            {
                    if (!(textAreaDisplay_NAC.getText().isEmpty())){
                        getNextItem(NON_ACADEMIC_COURSES);
                        btnRemove_NAC.setEnabled(true);
                    }
                    else{
                        displayCourseContent(NON_ACADEMIC_COURSES.get(0));
                        btnRemove_NAC.setEnabled(true);
                    }
            }
        });

      btnLast_NAC = new JButton(">|");
      btnLast_NAC.setPreferredSize(BTN_SMALL);
      btnLast_NAC.setEnabled(false);
      btnLast_NAC.addActionListener(new ActionListener()
      {
            public void actionPerformed(ActionEvent ae)
            {
               displayCourseContent(NON_ACADEMIC_COURSES.get(NON_ACADEMIC_COURSES.size()-1));
               btnRemove_NAC.setEnabled(true);
            }
        });
      displayBtnPanel_NAC.add(btnFirst_NAC); displayBtnPanel_NAC.add(btnPrevious_NAC);
      displayBtnPanel_NAC.add(btnNext_NAC); displayBtnPanel_NAC.add(btnLast_NAC);


      buttonsPanel_NAC.add(btnAdd_NAC); buttonsPanel_NAC.add(btnRegister_NAC);
      buttonsPanel_NAC.add(btnClear_NAC); buttonsPanel_NAC.add(btnRemove_NAC);
      buttonsPanel_NAC.add(btnDisplay_NAC); buttonsPanel_NAC.add(displayBtnPanel_NAC);

      cards = new JTabbedPane();

      //Panels
      titlePanel = new JPanel();
      titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
      titlePanel_NAC = new JPanel();
      titlePanel_NAC.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));

      //Titles
      titleAcademic = new JLabel("Academic Course");
      titleAcademic.setFont(TITLE_FONT);
      titlePanel.add(titleAcademic);

      titleNonAcademic = new JLabel("Non-Academic Course");
      titleNonAcademic.setFont(TITLE_FONT);
      titlePanel_NAC.add(titleNonAcademic);



      //Academic Card
      cardAcademic = new JPanel();
      cardAcademic.setLayout(new BorderLayout());
      cardAcademic.add(titlePanel, BorderLayout.PAGE_START);
      cardAcademic.add(componentsPanel, BorderLayout.LINE_START);
      cardAcademic.add(buttonsPanel, BorderLayout.PAGE_END);
      cardAcademic.add(textAreaDisplay, BorderLayout.LINE_END);

      //Non-Academic Card
      cardNonAcademic =new JPanel();
      cardNonAcademic.setLayout(new BorderLayout());
      cardNonAcademic.add(titlePanel_NAC, BorderLayout.PAGE_START);
      cardNonAcademic.add(componentsPanel_NAC, BorderLayout.LINE_START);
      cardNonAcademic.add(buttonsPanel_NAC, BorderLayout.PAGE_END);
      cardNonAcademic.add(textAreaDisplay_NAC, BorderLayout.LINE_END);

      //Adding cards in container card.
      cards.add("Academic Course", cardAcademic);
      cards.add("Non-Academic Course", cardNonAcademic);


      frameMain.add(cards);
      frameRegAC.add(regPanel);
      frameRegNAC.add(regPanel_NAC);

      frameMain.setVisible(true);
      frameRegAC.setVisible(false);
      frameRegNAC.setVisible(false);
    }

    //Method to retrive data from following fields in Academic Course Form.

    //Course ID
    private String getACID(){
        return textCourseID.getText();
    }

    //Course Duration
    private String getACDuration(){
        return textCourseDuration.getText();
    }

    //Course Name
    private String getACName(){
        return textCourseName.getText();
    }

    //Level
    private String getACLevel(){
        if (radioLevelH.isSelected()){
            return "H";
        }
        if (radioLevelM.isSelected()){
            return "M";
        }
        return "C";
    }

    //Course Credit
    private String getACCredit(){
        return textCredit.getText();
    }

    //Course No of Assessments
    private String getACNoOfAssessments(){
        return textNoOfAssessments.getText();
    }

    //Method to retrive data from following fields in Non-Academic Course Form.

    //Course ID
    private String getNACID(){
        return textCourseID_NAC.getText();
    }

    //Course Duration
    private String getNACDuration(){
        return textCourseDuration_NAC.getText();
    }

    //Course Name
    private String getNACName(){
        return textCourseName_NAC.getText();
    }

    //Course Prerequisites
    private String getNACPrerequisites(){
        return textAreaPrerequisite_NAC.getText();
    }

    //Method to display next item in progressive manner in from the list.
    private void getNextItem(ArrayList<Course> courseList)
    {
        if (courseList.get(0) instanceof AcademicCourse){
            String displayedContent = textAreaDisplay.getText();
            String courseIdOnDisplay = getCourseIDFromDisplay(displayedContent);
            int index = getPointerOfObject(courseIdOnDisplay, courseList);
            if (index < courseList.size()){
                index += 1;
                textAreaDisplay.setText("");
                displayCourseContent(courseList.get(index));
            }
            else{
                JOptionPane.showMessageDialog(null, "You have reached the last record!!!", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (courseList.get(0) instanceof NonAcademicCourse){
            String displayedContent = textAreaDisplay_NAC.getText();
            String courseIdOnDisplay = getCourseIDFromDisplay(displayedContent);
            int index = getPointerOfObject(courseIdOnDisplay, courseList);
            if (index < courseList.size()-1){
                index += 1;
                textAreaDisplay_NAC.setText("");
                displayCourseContent(courseList.get(index));
            }
            else{
                JOptionPane.showMessageDialog(null, "You have reached the last record!!!", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    //Method to display previous item in progressive manner in from the list.
    private void getPreviousItem(ArrayList<Course> courseList)
    {
        if (courseList.get(0) instanceof AcademicCourse){
            String displayedContent = textAreaDisplay.getText();
            String courseIdOnDisplay = getCourseIDFromDisplay(displayedContent);
            int index = getPointerOfObject(courseIdOnDisplay, courseList);
            if (index > 0){
                index -= 1;
                textAreaDisplay.setText("");
                displayCourseContent(courseList.get(index));
            }
            else{
                JOptionPane.showMessageDialog(null, "You have reached the first record!!!", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (courseList.get(0) instanceof NonAcademicCourse){
            String displayedContent = textAreaDisplay_NAC.getText();
            String courseIdOnDisplay = getCourseIDFromDisplay(displayedContent);
            int index = getPointerOfObject(courseIdOnDisplay, courseList);
            if (index > 0){
                index -= 1;
                textAreaDisplay_NAC.setText("");
                displayCourseContent(courseList.get(index));
            }
            else{
               JOptionPane.showMessageDialog(null, "You have reached the first record!!!", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    //Method to remove non-academic course with appropriate message on display.
    private void removeNonAcademicCourse()
    {
        try{
            String displayedContent = textAreaDisplay_NAC.getText();
            String courseIdOnDisplay = getCourseIDFromDisplay(displayedContent);
            int index = getPointerOfObject(courseIdOnDisplay, NON_ACADEMIC_COURSES);
            NonAcademicCourse nac = (NonAcademicCourse)NON_ACADEMIC_COURSES.get(index);
            if(!nac.getIsRemoved()){
                int result = JOptionPane.showConfirmDialog(frameMain,"Are you sure you want to remove " + nac.getCourseName() +" ?","SELECT OPTIONS", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){
                   nac.removeNonAcademicCourse();
                   textAreaDisplay_NAC.setText("");
                   displayNotRemovedItemAfter(index);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Sorry!!! " + nac.getCourseName() + " has already been removed!!!", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
            }

        }
        catch (ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "There are no records to removed!!!", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
            btnRemove_NAC.setEnabled(false);
            clearAllFieldsOfNonAcademicCourse();
        }
    }

    //Method to display next course which is not removed after the course is sucessfully removed.
    private void displayNotRemovedItemAfter(int index)
    {
        ListIterator<Course> it = NON_ACADEMIC_COURSES.listIterator(index);
        while(it.hasNext()){
            NonAcademicCourse nac = (NonAcademicCourse)it.next();
            if (!(nac.getIsRemoved())){
                displayCourseContent(nac);
                break;
            }
        }
    }

    //Method to return array of numbers upto 32.
    private String[] dayList()
    {
        String[] noOfDays = new String[32];
        for(int i = 1; i<=32; i++){
            String day = Integer.toString(i);
            noOfDays[i-1] = day;
        }
        return noOfDays;
    }

    //Method to clear all fields of Registration Form for Academic Course.
    private void clearAllFieldsOfRegAcademic()
    {
        comboCourseID.setSelectedItem("Select Course ID");
        textCourseLeader.setText(null);
        textLecturerName.setText(null);
        textStartDate.setText(null);
        textFinishDate.setText(null);
    }

    //Method to clear all fields of Registration Form for Non-Academic Course.
    private void clearAllFieldsOfRegNonAcademic()
    {
        comboCourseID_NAC.setSelectedItem("Select Course ID");
        textCourseLeader_NAC.setText(null);
        textInstructor.setText(null);
        textStartDate_NAC.setText(null);
        textFinishDate_NAC.setText(null);
        textExamDate_NAC.setText(null);
    }

    //Method to clear all fields of Academic Course Form.
    private void clearAllFieldsOfAcademicCourse()
    {
        textCourseID.setText(null);
        textCourseName.setText(null);
        textCourseDuration.setText(null);
        textCredit.setText(null);
        textNoOfAssessments.setText(null);
        radioLevelC.setSelected(true);
        textAreaDisplay.setText(null);
    }

    //Method to clear all fields of Non-Academic Course Form.
    private void clearAllFieldsOfNonAcademicCourse()
    {
        textCourseID_NAC.setText(null);
        textCourseName_NAC.setText(null);
        textCourseDuration_NAC.setText(null);
        textAreaPrerequisite_NAC.setText(null);
        textAreaDisplay_NAC.setText(null);
    }

    //Return type method that accepts text fields as parameter and checks if they are empty.
    private boolean hasAnyEmptyFields(JTextField[] textFields)
    {
        for (int i = 0; i < textFields.length; i++){
            if (textFields[i].getText().isEmpty()){
                return true;
            }
        }
        return false;
    }

    //Return type method that accepts text fields as parameter and checks if input is of type SHORT(number).
    private boolean inputIsShort(JTextField[] textFields)
    {
        for (int i = 0; i < textFields.length; i++){
            try{
                Short.valueOf(textFields[i].getText());
            }
            catch(NumberFormatException e){
                return false;
            }
            catch(Exception e){
                return false;
            }
        }
        return true;
    }

    /*Return type method to check if the string has on alphabets and no numbers.
     Used for checking valid name.*/
    private boolean isValidName( String name )
    {
      return name.matches( "[a-zA-Z]*");
    }

    //Return type method to check if the course list supplied is empty.
    private boolean isListEmpty(ArrayList<Course> courseList)
    {
        if (courseList.size() == 0){
            return true;
        }
        return false;
    }

    //Method to display course content on their respective text area with proper color code.
    private void displayCourseContent(Course c)
    {
        if (c instanceof NonAcademicCourse){
            NonAcademicCourse nac = (NonAcademicCourse)c;
            textAreaDisplay_NAC.setText("Course ID: " + nac.getCourseId() + "\n\n" +
                                "Course Name: " + nac.getCourseName()+ "\n\n"+
                                "Course Duration: " + nac.getCourseDuration() + " weeks" + "\n\n" +
                                "Pre-requisites: " + nac.getPrerequisite() + "\n\n");
            if (nac.getIsRegistered()){
                textAreaDisplay_NAC.setText("Course ID: " + nac.getCourseId() + "\n\n" +
                                "Course Name: " + nac.getCourseName()+ "\n\n"+
                                "Course Duration: " + nac.getCourseDuration() + " weeks" + "\n\n" +
                                "Pre-requisites: " + nac.getPrerequisite() + "\n\n" +
                                "Course Leader: " + nac.getCourseLeader()+ "\n\n" +
                                "Instructor: " + nac.getInstructorName() + "\n\n" +
                                "Starting Date: " + nac.getStartDate()+ "\n\n"+
                                "Completion Date: "+ nac.getCompletionDate()+ "\n\n" +
                                "Exam Date: " + nac.getExamDate());
            }
            if (nac.getIsRegistered()){
                textAreaDisplay_NAC.setForeground(REG_COLOR);
            }
            else if (nac.getIsRemoved()){
                textAreaDisplay_NAC.setForeground(WARNING_COLOR);
            }
            else{
                textAreaDisplay_NAC.setForeground(NORMAL_COLOR);
            }
        }
        if (c instanceof AcademicCourse){
            AcademicCourse ac = (AcademicCourse)c;
            textAreaDisplay.setText("Course ID: " + ac.getCourseId() + "\n\n" +
                                "Course Name: " + ac.getCourseName()+ "\n\n" +
                                "Course Duration: " + ac.getCourseDuration() + " weeks" + "\n\n" +
                                "Level: " + ac.getLevel() + "\n\n" +
                                "Credit: " + ac.getCredit() + " credits" + "\n\n" +
                                "No Of Assessments: " + ac.getNoOfAssessments()+ "\n\n");
            if (ac.getIsRegistered()){
                textAreaDisplay.setText("Course ID: " + ac.getCourseId() + "\n\n" +
                                "Course Name: " + ac.getCourseName()+ "\n\n" +
                                "Course Duration: " + ac.getCourseDuration() + " weeks" + "\n\n" +
                                "Course Leader: " + ac.getCourseLeader()+ "\n\n" +
                                "Lecturer Name: " + ac.getlecturerName()+ "\n\n" +
                                "Level: " + ac.getLevel() + "\n\n" +
                                "Credit: " + ac.getCredit() + " credits" + "\n\n" +
                                "No Of Assessments: " + ac.getNoOfAssessments()+ "\n\n" +
                                "Starting Date: "+ ac.getStartingDate()+ "\n\n" +
                                "Completion Date: " + ac.getCompletionDate());
                textAreaDisplay.setForeground(REG_COLOR);
            }
            else{
                textAreaDisplay.setForeground(NORMAL_COLOR);
            }
        }
    }

    //Method to return courseID form displayed content.
    private String getCourseIDFromDisplay(String displayedContent)
    {
        String[] courseIDLine = displayedContent.split("\n", 2);
        String[] firstLineWords = courseIDLine[0].split(" ");
        return firstLineWords[2];
    }

    //Method to return index(position) of object by supplying courseID and the list to be searched.
    private int getPointerOfObject(String courseID, ArrayList<Course> courseList)
    {
        int position = 0;
        for (int i = 0; i < courseList.size(); i++){
            if (courseID.equals(courseList.get(i).getCourseId())){
                position = i;
                return position;
            }
        }
        return position;
    }

    //Method to return if courseID exists by supplying courseID and list to be searched in.
    private boolean courseIDExists(String courseID, ArrayList<Course> courseList)
    {
        for (int i = 0; i < courseList.size(); i++){
            if (courseList.get(i).getCourseId().equals(courseID.toUpperCase())){
                return true;
            }
        }
        return false;
    }

    //Method to perform the task of adding Academic Course.
    private void addAcademicCourse()
        {
        JTextField [] listOfAcademicTextFields = {textCourseID, textCourseName, textCourseDuration,
                                    textCredit, textNoOfAssessments};
        JTextField [] listOfShortTextFields = {textCourseDuration, textCredit, textNoOfAssessments};
        if(!(hasAnyEmptyFields(listOfAcademicTextFields))){
            if (!courseIDExists(getACID(), ACADEMIC_COURSES)){
                if (inputIsShort(listOfShortTextFields)){
                    String level = getACLevel();
                    AcademicCourse ac = new AcademicCourse(getACID().toUpperCase(), getACName().toUpperCase(),
                                        Short.valueOf(getACDuration()),
                                        level, Short.valueOf(getACCredit()),
                                        Short.valueOf(getACNoOfAssessments()));
                    ACADEMIC_COURSES.add(ac);
                    JOptionPane.showMessageDialog(null, ac.getCourseName() + " sucessfully added as Academic Course!!!");
                    clearAllFieldsOfAcademicCourse();
                    if (!isListEmpty(ACADEMIC_COURSES)){
                        btnNext.setEnabled(true);
                        btnPrevious.setEnabled(true);
                        btnLast.setEnabled(true);
                        btnFirst.setEnabled(true);
                        btnDisplay.setEnabled(true);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please check correct numeric values for:"+"\n" +
                                                        "\t\t\t\t\t\t\t\t"+"Course Duration OR"+"\n"+
                                                        "\t\t\t\t\t\t\t\t"+"Course Credit OR"+"\n"+
                                                        "\t\t\t\t\t\t\t\t"+"No Of Assessments", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Sorry!!! Course ID already exists!!! Please enter another course ID.", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please enter all the details!!!", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
        }
        }

    //Method to perform the task of adding Non-Academic Course.
    private void addNonAcademicCourse()
    {
        JTextField [] listOfNonAcademicTextFields = {textCourseID_NAC, textCourseName_NAC,
                                                  textCourseDuration_NAC};
        JTextField [] listOfShortTextFieldsNAC = {textCourseDuration_NAC};
        if(!(hasAnyEmptyFields(listOfNonAcademicTextFields)) && !getNACPrerequisites().isEmpty()){
            if (!courseIDExists(getNACID(), NON_ACADEMIC_COURSES)){
                if (inputIsShort(listOfShortTextFieldsNAC)){
                    NonAcademicCourse nac = new NonAcademicCourse(getNACID().toUpperCase(), getNACName().toUpperCase(),
                                        Short.valueOf(getNACDuration()),
                                        getNACPrerequisites());
                    NON_ACADEMIC_COURSES.add(nac);
                    JOptionPane.showMessageDialog(null, nac.getCourseName() + " sucessfully added as Non-Academic Course!!!");
                    clearAllFieldsOfNonAcademicCourse();
                    if (!isListEmpty(NON_ACADEMIC_COURSES)){
                        btnNext_NAC.setEnabled(true);
                        btnPrevious_NAC.setEnabled(true);
                        btnLast_NAC.setEnabled(true);
                        btnFirst_NAC.setEnabled(true);
                        btnDisplay_NAC.setEnabled(true);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please check correct numeric values for:"+"\n" +
                                                        "\t\t\t\t\t\t\t\t"+"Course Duration", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Sorry!!! Course ID already exists!!! Please enter another course ID.", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please enter all the details!!!", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Method to perform the task of regestering Academic Course.
    private void updateAcademicCourse()
    {
        JTextField[] textFields = {textCourseLeader, textLecturerName, textStartDate, textFinishDate};
        String id = comboCourseID.getSelectedItem().toString();
        if (!(id == "Select Course ID")){
            int index = getPointerOfObject(id, ACADEMIC_COURSES);
            AcademicCourse ac = (AcademicCourse)ACADEMIC_COURSES.get(index);
            if(!ac.getIsRegistered()){
                if(!hasAnyEmptyFields(textFields)){
                    if(isValidName(textCourseLeader.getText()) && isValidName(textLecturerName.getText())){
                        String startDate = textStartDate.getText();
                        String finishDate = textFinishDate.getText();

                        String courseLeader = textCourseLeader.getText();
                        String courseLecturer = textLecturerName.getText();

                        ac.registerAcademicCourse(courseLeader.toUpperCase(), courseLecturer.toUpperCase(), startDate, finishDate);
                        JOptionPane.showMessageDialog(null, ac.getCourseName() + " has been registered sucessfully!!!");
                        clearAllFieldsOfRegAcademic();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Please check valid name for:"+"\n" +
                                                                "\t\t\t\t\t\t\t\t"+"Course Leader OR"+"\n"+
                                                                "\t\t\t\t\t\t\t\t"+"Lecturer Name", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                        JOptionPane.showMessageDialog(null, "Please fill all the details!!!", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
                    }
            }
            else{
                JOptionPane.showMessageDialog(null, "Sorry!!! " + ac.getCourseName() + " has already been registered!!!", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a Course ID!!!", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Method to perform the task of regestering Non-Academic Course.
    private void updateNonAcademicCourse()
    {
        JTextField[] textFields = {textCourseLeader_NAC, textInstructor, textStartDate_NAC, textFinishDate_NAC, textExamDate_NAC};
        String id = comboCourseID_NAC.getSelectedItem().toString();
        if (!(id == "Select Course ID")){
            int index = getPointerOfObject(id, NON_ACADEMIC_COURSES);
            NonAcademicCourse nac = (NonAcademicCourse)NON_ACADEMIC_COURSES.get(index);
            if(!nac.getIsRemoved()){
                if(!nac.getIsRegistered()){
                    if(!hasAnyEmptyFields(textFields)){
                        if(isValidName(textCourseLeader_NAC.getText()) && isValidName(textInstructor.getText())){
                            String startDate = textStartDate_NAC.getText();
                            String finishDate = textFinishDate_NAC.getText();
                            String examDate = textExamDate_NAC.getText();

                            String courseLeader = textCourseLeader_NAC.getText();
                            String courseInstructor = textInstructor.getText();

                            nac.registerNonAcademicCourse(courseLeader.toUpperCase(), courseInstructor.toUpperCase(), startDate, finishDate, examDate);
                            JOptionPane.showMessageDialog(null, nac.getCourseName() + " has been registered sucessfully!!!");
                            clearAllFieldsOfRegNonAcademic();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Please check valid name for:"+"\n" +
                                                                    "\t\t\t\t\t\t\t\t"+"Course Leader OR"+"\n"+
                                                                    "\t\t\t\t\t\t\t\t"+"Instructor Name", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else{
                            JOptionPane.showMessageDialog(null, "Please fill all the details!!!", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                JOptionPane.showMessageDialog(null, "Sorry!!! " + nac.getCourseName() + " has already been registered!!!", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Sorry!!! " + nac.getCourseName() + " has already been removed!!!", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a Course ID!!!", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Method to over ride actionPerformed method and to make Exit menu item functional.
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == exitMItem){
            int result = JOptionPane.showConfirmDialog(frameMain,"Are you sure you want to exit? " ,"ING-College Course Registration Form", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                frameMain.dispose();
            }
        }
    }

    public static void main (String[] args){
        INGCollege clg = new INGCollege();
    }
}
