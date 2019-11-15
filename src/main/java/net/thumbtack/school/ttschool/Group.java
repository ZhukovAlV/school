package net.thumbtack.school.ttschool;

import java.util.*;

public class Group {
    private String name;
    private String room;
    private List<Trainee> trainees = new ArrayList<>();

    public Group(String name, String room) throws TrainingException {
        super();
        setName(name);
        setRoom(room);
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRoom(String room) throws TrainingException {
        if (room == null || room.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }
        this.room = room;
    }
    public String getRoom() {
        return room;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (!getTrainees().remove(trainee)) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);


    }
    
    public void removeTrainee(int index) throws TrainingException {
        if (index < 0 || index >= getTrainees().size()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        getTrainees().remove(index);
    }

    public Trainee getTraineeByFirstName(String firstName) throws TrainingException {
        for (Trainee traineeObj : getTrainees()) {
            if (traineeObj.getFirstName().equals(firstName)) {
                return traineeObj;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException {
        for (Trainee traineeObj : getTrainees()) {
            if (traineeObj.getFullName().equals(fullName)) {
                return traineeObj;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void sortTraineeListByFirstNameAscendant() {
/*        Collections.sort(getTrainees(), new Comparator<Trainee>() {
            @Override
            public int compare(Trainee o1, Trainee o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });
      */
      //  Collections.sort(getTrainees(), (o1, o2)-> o1.getFirstName().compareTo(o2.getFirstName()));
       // Collections.sort(getTrainees(), Comparator.comparing(Trainee::getFirstName));
        getTrainees().sort(Comparator.comparing(Trainee::getFirstName));
    }

    public void sortTraineeListByRatingDescendant() {
       // Collections.sort(getTrainees(),(o1, o2)-> o1.getRating() < o2.getRating() ? 1 : (o1.getRating() > o2.getRating() ? -1 : 0));
       // Collections.sort(getTrainees(),(o1, o2)-> Integer.valueOf(o1.getRating()).compareTo(o2.getRating()));
       // Collections.sort(getTrainees(),(o1, o2)-> Integer.compare(o2.getRating(),o1.getRating()));
        getTrainees().sort((o1, o2)-> Integer.compare(o2.getRating(),o1.getRating()));
    }

    public void reverseTraineeList() {
        Collections.reverse(getTrainees());
    }

    public void rotateTraineeList(int positions) {
        Collections.rotate(getTrainees(),positions);
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException {
       if (getTrainees().size() == 0) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        int maxRating = 0;
        List<Trainee>  result = new ArrayList<>();
        for(Trainee trainee : getTrainees()) {
            if(trainee.getRating() > maxRating) {
                result.clear();
                maxRating = trainee.getRating();
            }
            if (trainee.getRating() == maxRating) {
                result.add(trainee);
            }
        }
        return result;
    }

    public boolean hasDuplicates() {
        Set<Trainee> dup = new HashSet<>(getTrainees());
        return getTrainees().size()!=dup.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return name.equals(group.name) &&
                room.equals(group.room) &&
                trainees.equals(group.trainees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, room, trainees);
    }
}
