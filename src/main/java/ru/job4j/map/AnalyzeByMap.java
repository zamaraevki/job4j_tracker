package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0;
        double count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                count++;
                rsl += subject.score();
            }
        }
        return rsl / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> average = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double rsl = 0;
            double count = 0;
            for (Subject subject : pupil.subjects()) {
                count++;
                rsl += subject.score();
            }
            Label label = new Label(pupil.name(), rsl / count);
            average.add(label);
        }
        return average;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> average = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                Integer oldValue = map.get(subject.name());
                if (oldValue == null) {
                    map.put(subject.name(), subject.score());
                } else {
                    map.put(subject.name(), subject.score() + oldValue);
                }
            }
        }
        for (String subject : map.keySet()) {
            Label label = new Label(subject, map.get(subject) / pupils.size());
            average.add(label);
        }
        return average;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> average = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double rsl = 0;
            for (Subject subject : pupil.subjects()) {
                rsl += subject.score();
            }
            Label label = new Label(pupil.name(), rsl);
            average.add(label);
        }
        average.sort(Comparator.naturalOrder());
        return average.get(average.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> average = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                Integer oldValue = map.get(subject.name());
                if (oldValue == null) {
                    map.put(subject.name(), subject.score());
                } else {
                    map.put(subject.name(), subject.score() + oldValue);
                }
            }
        }
        for (String subject : map.keySet()) {
            Label label = new Label(subject, map.get(subject));
            average.add(label);
        }
        average.sort(Comparator.naturalOrder());
        return average.get(average.size() - 1);
    }
}
