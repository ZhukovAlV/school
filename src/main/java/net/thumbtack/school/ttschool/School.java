package net.thumbtack.school.ttschool;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class School {
    private String name;
    private int year;
    private Set<Group> groups = new HashSet<>();

    public School(String name, int age) throws TrainingException {
        super();
        setName(name);
        setYear(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws TrainingException {
        if (year<=0) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_YEAR);
        }
        this.year = year;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) throws TrainingException {
        for (Group elem : groups) {
            if (elem.getName().equals(group.getName())) {
                throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
            }
        }
        getGroups().add(group);
    }

    public void removeGroup(Group group) throws TrainingException {
        if (!getGroups().remove(group)) throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);

    }

    public void removeGroup(String name) throws TrainingException {
        if (!getGroups().removeIf(elem -> elem.getName().equals(name))) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
    }

    public boolean containsGroup(Group group) {
        for (Group elem : groups) {
            if (elem.getName().equals(group.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return year == school.year &&
                name.equals(school.name) &&
                groups.equals(school.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, groups);
    }
}
