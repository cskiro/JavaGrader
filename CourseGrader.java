import java.util.Scanner; //Implementing the Scanner class from the java.util library
public class CourseGrader {
	
	//Declaration of constant value 
	
	//Maximum number of labs available to attend
	//public static final int MAX_LABS = 10;
	//Maximum test score allowed for exams 1 and 2
	public static final double MAX_TEST_SCORE = 100.0;
	//Maximum number of homework assignments to complete
	//public static final int MAX_HW_ASSIGNS = 10;
	//Maximum number of points available to earn per lab
	public static final int MAX_PTS_PER_LAB = 4;
	//Maximum number of points available to ear per homework assignment
	public static final int MAX_PTS_PER_HW_ASSIGN = 10;

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in); //initializing keyboard input
		
		System.out.println("Homework weight:");
		int homeworkWeight = kb.nextInt();
		
		
		while(homeworkWeight > 100) {
			
			System.out.println("Incorrect value entered, please try again:");
			homeworkWeight = kb.nextInt();
			
		}
		
		System.out.println("Exam 1 weight:");
		int exam1Weight = kb.nextInt();
		
		while(exam1Weight > 100) {
			
			exam1Weight = kb.nextInt();
			
		}
		
		while((homeworkWeight + exam1Weight) > 100) {
			
			System.out.println("Weights cannot exceed 100:");
			homeworkWeight = kb.nextInt();
			exam1Weight = kb.nextInt();
			
		}
		
		int exam2Weight = 100 - homeworkWeight - exam1Weight;
		double courseGrade, weightedExam1Score, weightedExam2Score, weightedHomeworkScore;
		
		System.out.println("Using weights of:");
		System.out.println("Homework Weight = " + homeworkWeight);
		System.out.println("Exam 1 Weight = " + exam1Weight);
		System.out.println("Exam 2 Weight = " + exam2Weight);
		
		System.out.println();
		
		System.out.println("Homework:");
		System.out.println("Number of assignments?");
		int numOfAssignments = kb.nextInt();
		
		double totalHomeworkPoints;
		
		//If user enters a negative number or a 0 for homework assignments, the user should receive the total homework percentage 
		if(numOfAssignments > 0) {
					
			System.out.println("Average homework grade:");
			double avgHomeworkGrade = kb.nextDouble();
			
			//If user enters a negative number or a 0 for the average homework grade, set average homework grade to 0
			if(avgHomeworkGrade <= 0) {
				avgHomeworkGrade = 0;
			}
			
			System.out.println("Number of late days used:");
			int lateDaysUsed = kb.nextInt();
			
			System.out.println("Labs attended:");
			int labsAttended = kb.nextInt();
			
			totalHomeworkPoints = (avgHomeworkGrade * numOfAssignments + labsAttended * numOfAssignments);
			
			//If user uses no late days and their average homework grade is not 10, add 5 points to their score
			if((lateDaysUsed == 0) && (avgHomeworkGrade != 10)) {
				
				totalHomeworkPoints += 5;
				
				
			} 
			
			double maxHomeworkPoints = MAX_PTS_PER_HW_ASSIGN * numOfAssignments + MAX_PTS_PER_LAB * numOfAssignments;
			
			System.out.println("Total Homework points = " + totalHomeworkPoints +  " / " + maxHomeworkPoints);
			System.out.println((totalHomeworkPoints / maxHomeworkPoints) * 100);
			
			//Calculate weighted homework score
			weightedHomeworkScore = homeworkWeight * (avgHomeworkGrade * numOfAssignments + labsAttended * MAX_PTS_PER_LAB) / 
					(MAX_PTS_PER_HW_ASSIGN * numOfAssignments + MAX_PTS_PER_LAB * numOfAssignments);
			
			if(lateDaysUsed > (numOfAssignments / 2)) {
				
				//if user's late days exceed half the number of assignments, reduce homework score by 10%
				weightedHomeworkScore = weightedHomeworkScore - (weightedHomeworkScore * .1);
				
			} 
			
		} else {
			
		  weightedHomeworkScore = (double) homeworkWeight;
			
		}
		
		
		
		System.out.println("Weighted homework score = " + weightedHomeworkScore); 
		
		System.out.println();
		
		System.out.println("Exam 1:");
		
		System.out.println("Score?");
		int exam1Score = kb.nextInt();
		
		System.out.println("Curve?");
		int exam1Curve = kb.nextInt();
		
		//If exam 1 score plus the curve exceed 100, set score to 100 - MAX SCORE
		if((exam1Score + exam1Curve) > MAX_TEST_SCORE) {
			
			exam1Score = 100;
			
		}
		
		//If user enters a negative number or a 0 for exam 1 score, set score to 0
		if(exam1Score <= 0) {
			
			exam1Score = 0;
			
		}
		
		//Calculate exam 1 test score
		double totalExam1Points = ((exam1Score + exam1Curve) / MAX_TEST_SCORE) * 100;
		
		System.out.println("Total points = " + totalExam1Points);
		
		//Calculate weighted score for exam 1
		weightedExam1Score = exam1Weight * exam1Score / MAX_TEST_SCORE;
		
		System.out.println("Weighted Exam 1 Score = " + weightedExam1Score);
		
		System.out.println();
		
		System.out.println("Exam 2:");
		
		System.out.println("Score?");
		int exam2Score = kb.nextInt();
		
		System.out.println("Curve?");
		int exam2Curve = kb.nextInt();
		
		//If exam 2 score plus the curve exceed 100, set score to 100 - MAX SCORE
		if((exam2Score + exam2Curve) > MAX_TEST_SCORE) {
			
			exam2Score = 100;
			
		}
		//If user enters negative number or zero, set exam 2 score to 0
		if(exam2Score <= 0) {
			
			exam2Score = 0;
			
		}
		
		//Calculate exam 2 test score
		double totalExam2Points = ((exam2Score + exam2Curve) / MAX_TEST_SCORE) * 100;
		
		System.out.println("Total points = " + totalExam2Points);
		
		//Calculate weighted score for exam 2
		weightedExam2Score = exam2Weight * exam2Score / MAX_TEST_SCORE;
		
		System.out.println("Weighted Exam 2 Score = " + weightedExam2Score);
		
		System.out.println();
		
		courseGrade = weightedHomeworkScore + weightedExam1Score + weightedExam2Score;
		
		System.out.println("Your grade for the course is: " + courseGrade);
		
		//Calculates course grade into a letter grade
		char grade;
		
		if(courseGrade >= 94.0) {
			
			grade = 'A';
			
		} else if(courseGrade >= 84.0) {
			
			grade = 'B';
			
		} else if(courseGrade >= 74.0) {
			
			grade = 'C';
			
		} else if(courseGrade >= 60.0) {
			
			grade = 'D';
			
		} else {
			
			grade = 'F';
		}
		
	    System.out.println("You received a: " + grade);
		
		kb.close(); //prevents data leakage

	}

}
