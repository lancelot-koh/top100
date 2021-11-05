package day3;

import java.sql.Struct;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> courseMap = new HashMap<>();

        for(int[] relation: prerequisites) {
            if(courseMap.containsKey(relation[1])){
                courseMap.get(relation[1]).add(relation[0]);
            } else {
                List<Integer> nextCourse = new LinkedList<>();
                nextCourse.add(relation[0]);
                courseMap.put(relation[1], nextCourse);
            }
        }

        boolean[] path = new boolean[numCourses];

        for(int currCourse = 0; currCourse < numCourses; currCourse++) {
            if (this.isCycle(currCourse, courseMap, path)) {
                return false;
            }
        }
        return true;
    }

    boolean isCycle(Integer currCourse, HashMap<Integer, List<Integer>> courseMap, boolean[] path){
        if (path[currCourse]) {
            return true;
        }

        if (!courseMap.containsKey(currCourse)) {
            return false;
        }

        path[currCourse] = true;

        boolean ret = false;

        for(Integer nextCourse: courseMap.get(currCourse)) {
            ret = this.isCycle(nextCourse, courseMap, path);
            if(ret) {
                break;
            }
        }

        path[currCourse] = false;
        return ret;
    }
}
