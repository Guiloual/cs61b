import java.lang.reflect.Array;

public class CS61B {

    public static String university = "UC Berkeley";
    public String semester;
    public CS61BStudent[] students;
    public int capacity;
    //private CS61BStudent[] sigups;
    //public CS61BStudent[] enrollable;
    //public int wathNumber = 0;


    public CS61B(CS61BStudent[] sigups, String semester,int capacity){
        this.capacity = capacity;
        this.semester = semester;
        this.students = new CS61BStudent[capacity];
        for (int i=0; i<capacity; i++){
            students[i] = sigups[i];
        }
        //if (sigups.length <= capacity) {
        //    System.arraycopy(enrollable,0,sigups,0,sigups.length);
        //}else {
        //    System.arraycopy(enrollable, 0, sigups, 0, capacity);
        //}
    }



    public static void newUniversity(String newuniversity) {
        university = newuniversity;
    }

    public int makeStudentsWatchLecture() {
        int wathNumber=0;
        for (CS61BStudent student : students) {
            if (student.watchLecture()) {
                wathNumber += 1;
            }
        }
        return wathNumber;
    }

    public void expand (int newCapacity) {
        capacity = newCapacity;
        //if (sigups.length <= capacity) {
        //    System.arraycopy(enrollable,0,sigups,0,sigups.length);
        //}else {
        //    System.arraycopy(enrollable, 0, sigups, 0, capacity);
        //}
        //System.arraycopy(enrollable,0,sigups,0 , capacity);
    }





}
