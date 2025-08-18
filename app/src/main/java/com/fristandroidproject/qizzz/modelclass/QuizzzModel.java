package com.fristandroidproject.qizzz.modelclass;

public class QuizzzModel {
    String question;
    String optn1;
    String optn2;
    String optn3;
    String optn4;
    String correct;

    public QuizzzModel() {
    }

    public QuizzzModel(String correct, String optn1, String optn2, String optn3, String optn4, String question) {
        this.correct = correct;
        this.optn1 = optn1;
        this.optn2 = optn2;
        this.optn3 = optn3;
        this.optn4 = optn4;
        this.question = question;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getOptn1() {
        return optn1;
    }

    public void setOptn1(String optn1) {
        this.optn1 = optn1;
    }

    public String getOptn2() {
        return optn2;
    }

    public void setOptn2(String optn2) {
        this.optn2 = optn2;
    }

    public String getOptn3() {
        return optn3;
    }

    public void setOptn3(String optn3) {
        this.optn3 = optn3;
    }

    public String getOptn4() {
        return optn4;
    }

    public void setOptn4(String optn4) {
        this.optn4 = optn4;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
