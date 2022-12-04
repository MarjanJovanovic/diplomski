package it.marjanjovanovicbe.dto;

import java.util.List;

public class StudentDtoWithExamRegistration extends PersonDtoIdOnly{

    private String indexNumber;
    private List<ExamDtoIdOnly> exams;

    public StudentDtoWithExamRegistration() {
    }

    public StudentDtoWithExamRegistration(Long id, String indexNumber, List<ExamDtoIdOnly> exams) {
        super(id);
        this.indexNumber = indexNumber;
        this.exams = exams;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public List<ExamDtoIdOnly> getExams() {
        return exams;
    }

    public void setExams(List<ExamDtoIdOnly> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "StudentDtoWithExamRegistration{" +
                "indexNumber='" + indexNumber + '\'' +
                ", exams=" + exams +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDtoWithExamRegistration)) return false;
        if (!super.equals(o)) return false;

        StudentDtoWithExamRegistration that = (StudentDtoWithExamRegistration) o;

        if (indexNumber != null ? !indexNumber.equals(that.indexNumber) : that.indexNumber != null) return false;
        return exams != null ? exams.equals(that.exams) : that.exams == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (indexNumber != null ? indexNumber.hashCode() : 0);
        result = 31 * result + (exams != null ? exams.hashCode() : 0);
        return result;
    }
}
