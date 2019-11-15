package net.thumbtack.school.ttschool;

import java.util.*;

public class TraineeMap {
    private HashMap<Trainee, String> map = new HashMap<>();

    public HashMap<Trainee, String> getMap() {
        return map;
    }

    public TraineeMap() {
        super();
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (getMap().containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }
        getMap().put(trainee, institute);
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (!getMap().containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        getMap().put(trainee, institute);
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {
        if (getMap().remove(trainee)==null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public int getTraineesCount() {
        return getMap().keySet().size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
        for (Map.Entry<Trainee, String> entry : getMap().entrySet()) {
            if (entry.getKey().equals(trainee)) {
                return entry.getValue();
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Set<Trainee> getAllTrainees() {
        return new HashSet<>(getMap().keySet());
    }

    public Set<String> getAllInstitutes() {
        return new HashSet<>(getMap().values());
    }

    public boolean isAnyFromInstitute(String institute) {
        return getMap().values().contains(institute);
    }


}

