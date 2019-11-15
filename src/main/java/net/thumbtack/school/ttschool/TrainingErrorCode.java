package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {

    TRAINEE_WRONG_FIRSTNAME("Некорректная фамилия."),
    TRAINEE_WRONG_LASTNAME("Некорректное имя."),
    TRAINEE_WRONG_RATING("Некорректная оценка."),
    TRAINEE_NOT_FOUND("Студент отличник, молодец, комсомолец не найден."),
    GROUP_WRONG_NAME("Название группы не может быть null или пустой строкой."),
    GROUP_WRONG_ROOM("Номер аудитории не может быть null или пустой строкой."),
    GROUP_NOT_FOUND("Группа не найдена."),
    DUPLICATE_GROUP_NAME("Дублируется имя группы."),
    SCHOOL_WRONG_NAME("Некорректное имя школы."),
    SCHOOL_WRONG_YEAR("Некорректный год школы."),
    DUPLICATE_TRAINEE("Дублируется студент."),
    EMPTY_TRAINEE_QUEUE("Пустая очередь. Кофемашина СВОБОДНА!!!");

    private String errorString;
    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    TrainingErrorCode(String errorString) {
        setErrorString(errorString);
    }


}
