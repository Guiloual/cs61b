import java.lang.reflect.Array;

public class CS61B {

    public String university = "UC Berkeley";
    public String semester;
    public CS61BStudent students;
    public int capacity;
    private CS61BStudent[] sigups;
    public CS61BStudent[] enrollable;
    public int wathNumber = 0;


    public CS61B(CS61BStudent[] sigups, String semester,int capacity){
        this.capacity = capacity;
        this.semester = semester;
        this.sigups = sigups;
        if (sigups.length <= capacity) {
            System.arraycopy(enrollable,0,sigups,0,sigups.length);
        }else {
            System.arraycopy(enrollable, 0, sigups, 0, capacity);
        }
    }



    public void newUniversity(String newuniversity) {
        university = newuniversity;
    }

    public int makeStudentsWatchLecture(CS61BStudent stu) {
        if (stu.watchLecture()) {
            wathNumber += 1;
        }
        return wathNumber;
    }

    public void expand (int ext) {
        capacity += ext;
        if (sigups.length <= capacity) {
            System.arraycopy(enrollable,0,sigups,0,sigups.length);
        }else {
            System.arraycopy(enrollable, 0, sigups, 0, capacity);
        }
        //System.arraycopy(enrollable,0,sigups,0 , capacity);
    }





}
