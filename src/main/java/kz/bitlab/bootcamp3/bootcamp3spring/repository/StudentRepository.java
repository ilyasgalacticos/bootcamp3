package kz.bitlab.bootcamp3.bootcamp3spring.repository;

import kz.bitlab.bootcamp3.bootcamp3spring.model.BitlabStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<BitlabStudent, Long> {

    List<BitlabStudent> findAllByGpaGreaterThanEqual(double gpa);
    List<BitlabStudent> findAllByGpaGreaterThanEqualAndGpaLessThanEqual(double from, double to);
    List<BitlabStudent> findAllByGpaBetweenOrderByNameAsc(double from, double to);
    BitlabStudent findByIdAndGpaBetween(Long id, double from, double to);

    List<BitlabStudent> findAllByOrderByGpaDesc();

    List<BitlabStudent> findAllByNameIsLikeOrderByGpaDesc(String name);
    List<BitlabStudent> findAllByNameIsLikeOrderByGpaAsc(String name);

    @Query(value = "SELECT ilyas FROM BitlabStudent ilyas WHERE ilyas.gpa BETWEEN :fromGpa AND :toGpa")
    List<BitlabStudent> getBestStudents(@Param("fromGpa") double from, @Param("toGpa") double to);

    @Query(value = "SELECT student FROM BitlabStudent student WHERE LOWER(student.name) LIKE :nameParam ORDER BY student.gpa ASC")
    List<BitlabStudent> searchStudentAsc(String nameParam);

    @Query(value = "SELECT student FROM BitlabStudent student WHERE LOWER(student.name) LIKE :nameParam ORDER BY student.gpa DESC")
    List<BitlabStudent> searchStudentDesc(String nameParam);

}