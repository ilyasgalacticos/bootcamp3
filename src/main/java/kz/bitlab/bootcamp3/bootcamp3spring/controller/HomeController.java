package kz.bitlab.bootcamp3.bootcamp3spring.controller;

import kz.bitlab.bootcamp3.bootcamp3spring.model.BitlabStudent;
import kz.bitlab.bootcamp3.bootcamp3spring.service.FacultyService;
import kz.bitlab.bootcamp3.bootcamp3spring.service.StudentService;
import kz.bitlab.bootcamp3.bootcamp3spring.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("studenty", studentService.getAllStudents());
        return "home";
    }

    @PostMapping(value = "/addstudent-v2")
    public String addStudent(BitlabStudent student) {
        student = studentService.addStudent(student);
        return "redirect:/details/"+student.getId()+"/"+student.getLink()+".html";
    }

    @GetMapping(value = "/details/{studentId}/{link}.html")
    public String detailsSeo(Model model,
                             @PathVariable(name = "studentId") Long id,
                             @PathVariable(name = "link") String link) {
        BitlabStudent student = studentService.getStudent(id);
        model.addAttribute("studentObj", student);
        model.addAttribute("faculties", facultyService.getFaculties());
        model.addAttribute("subjects", subjectService.getPossibleSubjects(student));

        return "details";
    }

    @GetMapping(value = "/addstudent")
    public String addStudent(Model model) {
        model.addAttribute("faculties", facultyService.getFaculties());
        return "addstudent";
    }

    @PostMapping(value = "/savestudent")
    public String saveStudent(BitlabStudent student) {
        student = studentService.saveStudent(student);
        return "redirect:/details/" + student.getId() + "/" + student.getLink() + ".html";
    }

    @PostMapping(value = "/deletestudent")
    public String deleteStudent(BitlabStudent student) {
        studentService.deleteStudent(student);
        return "redirect:/";
    }

    @PostMapping(value = "/assign-subject")
    public String assignStudent(@RequestParam(name = "student_id") Long studentId,
                                @RequestParam(name = "subject_id") Long subjectId) {

        BitlabStudent student = studentService.assignSubject(studentId, subjectId);
        return "redirect:/details/"+studentId+"/"+student.getLink()+".html";
    }

    @PostMapping(value = "/unassign-subject")
    public String unassignStudent(@RequestParam(name = "student_id") Long studentId,
                                  @RequestParam(name = "subject_id") Long subjectId) {
        BitlabStudent student = studentService.unAssignSubject(studentId, subjectId);
        return "redirect:/details/"+studentId+"/"+student.getLink()+".html";
    }

    @GetMapping(value = "/search")
    public String search(@RequestParam(name = "key", required = false, defaultValue = "") String key,
                         @RequestParam(name = "order", required = false, defaultValue = "asc") String order,
                         Model model){
        model.addAttribute("studenty", studentService.search(key, order));
        return "search";
    }
}
