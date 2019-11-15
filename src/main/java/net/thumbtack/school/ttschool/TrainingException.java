package net.thumbtack.school.ttschool;

public class TrainingException extends Throwable{

    private TrainingErrorCode trainingErrorCode;

    public TrainingErrorCode getErrorCode() {
        return trainingErrorCode;
    }

    public void setErrorCode(TrainingErrorCode trainingErrorCode) {
        this.trainingErrorCode = trainingErrorCode;
    }

    public TrainingException(TrainingErrorCode trainingErrorCode) {
        setErrorCode(trainingErrorCode);
    }

}
