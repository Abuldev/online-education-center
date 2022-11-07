package uz.team.sabredu.service;

import uz.team.sabredu.dao.CourseDao;
import uz.team.sabredu.domains.Course;
import uz.team.sabredu.domains.auth.AuthUser;

import java.util.List;

public class CourseService extends Service<CourseDao> {
    public CourseService(CourseDao dao) {
        super(dao);
    }

    public Course findByID(Long id) {
        return dao.findOne(id);
    }

    public List<Course> findAll() {
        List<Course> all = dao.findAll();
        for (Course course : all) {
            course.setNum_lessons(course.getLessons().size());
        }
        return all;
    }

    public List<Course> getUserCourses(AuthUser user) {
        List<Course> courseSet = user.getCourseSet();
        for (Course course : courseSet) {
            course.setNum_lessons(course.getLessons().size());
        }
        return courseSet;
    }

    public List<Course> getTeacherCourses(AuthUser user) {
        List<Course> courses = user.getTeacher_courses();
        for (Course course : courses) {
            course.setNum_lessons(course.getLessons().size());
        }
        return courses;
    }
}
