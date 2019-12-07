package com.seleniummaster.inheritancetutorial;

public class GraduateStudent extends Student {
    private String researchField;
    private String advisorName;

    public GraduateStudent(String researchField, String advisorName) {
        this.researchField = researchField;
        this.advisorName = advisorName;
    }

    public GraduateStudent(String firstName, String lastName, String middleInitial, String className, String major, String gender, String researchField, String advisorName) {
        super(firstName, lastName, middleInitial, className, major, gender);
        this.researchField = researchField;
        this.advisorName = advisorName;
    }

    public GraduateStudent() {
        super();
    }

    public String getResearchField() {
        return researchField;
    }

    public void setResearchField(String researchField) {
        this.researchField = researchField;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    @Override
    public String toString() {
        return String.format("FirstMame=%s LasName=%s Gender=%s research=%s Adisor-%s",
                super.getFirstName(), super.getLastName(), super.getGender(), researchField, advisorName);
    }
}
