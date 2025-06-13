// CoursePortal.java

class Course {
     String title;
     int duration; // in hour
     String instructor;

    public Course(String title, int duration, String instructor) {
        this.title = title;
        this.duration = duration;
        this.instructor = instructor;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getCourseInfo() {
        return "Course: " + title + ", Duration: " + duration + " hours, Instructor: " + instructor;
    }
}

class LiveCourse extends Course {
    private String scheduleTime;

    public LiveCourse(String title, int duration, String instructor, String scheduleTime) {
        super(title, duration, instructor);
        this.scheduleTime = scheduleTime;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    @Override
    public String getCourseInfo() {
        return super.getCourseInfo() + ", Schedule: " + scheduleTime;
    }
}

class RecordedCourse extends Course {
    private int videoCount;

    public RecordedCourse(String title, int duration, String instructor, int videoCount) {
        super(title, duration, instructor);
        this.videoCount = videoCount;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    @Override
    public String getCourseInfo() {
        return super.getCourseInfo() + ", Videos: " + videoCount;
    }
}

public class CoursePortal {
    public static void main(String[] args) {
        Course live = new LiveCourse("Java Programming", 10, "ram", "Mon-Fri 10 AM");
        Course recorded = new RecordedCourse("Python Basics", 20, "binod", 15);

        Course[] courses = { live, recorded };

        for (Course c : courses) {
            System.out.println(c.getCourseInfo());
        }
    }
}

