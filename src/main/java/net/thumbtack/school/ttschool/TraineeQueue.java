package net.thumbtack.school.ttschool;

import java.util.ArrayList;
import java.util.Objects;

public class TraineeQueue {
    private ArrayList<Trainee> traineeQueue = new ArrayList<>();
    public ArrayList<Trainee> getTraineeQueue() {
        return traineeQueue;
    }
/*    public void setTraineeQueue(ArrayList<Trainee> traineeQueue) {
        this.traineeQueue = traineeQueue;
    }*/

    public TraineeQueue() {
        super();
    }

    public void addTrainee(Trainee trainee) {
        getTraineeQueue().add(trainee);
    }

    public Trainee removeTrainee() throws TrainingException {
        if (getTraineeQueue().isEmpty() ) {
            throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);
        }
        return getTraineeQueue().remove(0);
    }

    public boolean isEmpty() {
        return getTraineeQueue().size() == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TraineeQueue that = (TraineeQueue) o;
        return traineeQueue.equals(that.traineeQueue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(traineeQueue);
    }
}

