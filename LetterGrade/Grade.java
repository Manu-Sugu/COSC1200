public class Grade {
    /**
     * This method converts grade to a letter grade
     * 
     * @param grade The number grade to convert
     * @return The letter grade
     */
    public static String gradeConvertor(float grade) {
        // Stores grade into a variable
        int roundedGrade = Math.round(grade);

        // If statements to check the grade
        if (roundedGrade >= 90 && roundedGrade <= 100)
            return "A+";
        else if (roundedGrade >= 85 && roundedGrade <= 89)
            return "A";
        else if (roundedGrade >= 80 && roundedGrade <= 84)
            return "A-";
        else if (roundedGrade >= 75 && roundedGrade <= 79)
            return "B+";
        else if (roundedGrade >= 70 && roundedGrade <= 74)
            return "B";
        else if (roundedGrade >= 65 && roundedGrade <= 69)
            return "B-";
        else if (roundedGrade >= 60 && roundedGrade <= 64)
            return "C";
        else if (roundedGrade >= 55 && roundedGrade <= 59)
            return "D+";
        else if (roundedGrade >= 50 && roundedGrade <= 54)
            return "D-";
        else if (roundedGrade >= 0 && roundedGrade <= 49)
            return "F";
        else
            return "Error"; // Returns error statemnt if out of range
    }

    /**
     * This takes a letter grade and gives the appropriate feedback.
     * 
     * @param letterGrade The letter grade
     * @return Letter grade feedback
     */
    public static String gradeFeedback(String letterGrade) {
        // swtich case statement to compare and output the appropriate feedback for
        switch (letterGrade) {
            case "A+":
                return "Outstanding";
            case "A":
                return "Exemplary";
            case "A-":
                return "Excellent";
            case "B+":
                return "Very Good";
            case "B":
                return "Good";
            case "B-":
                return "Satisfactory";
            case "C":
                return "Acceptable";
            case "D+":
                return "Conditional Pass";
            case "D-":
                return "Conditional Pass";
            case "F":
                return "Fail";
            default:
                return ""; // returns blank if no letter grade
        }
    }
}