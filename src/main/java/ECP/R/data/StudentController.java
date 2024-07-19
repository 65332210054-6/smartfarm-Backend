package ECP.R.data;

import ECP.R.controller.APIResponse;
import ECP.R.services.servicesdata.StudentRepository;
import ECP.R.tables.tablesdata.StudentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/StudentProfile")
@CrossOrigin("*")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @PostMapping("/register")
    public Object register (@RequestBody StudentProfile studentProfile){
        APIResponse res = new APIResponse();
        StudentProfile dbStudentProfile = studentRepository.findByUsername(studentProfile.getUsername());

        if (dbStudentProfile == null) {
            res.setStatus(1);
            res.setMessage("Register done");
            studentRepository.save(studentProfile);
        } else {
            res.setStatus(0);
            res.setMessage("User exist");
        }
        return res;
    }

    @PostMapping("/login")
    public Object login (@RequestBody StudentProfile studentProfile) {
        APIResponse res = new APIResponse();
        StudentProfile dbStudentProfile = studentRepository.findByPassword(studentProfile.getPassword());
        if (dbStudentProfile == null){
            res.setStatus(0);
            res.setMessage("No User");

        } else {
            res.setStatus(1);
            res.setMessage("Login success");
        }
        return res;
    }
    @PostMapping("/show-user")
    public Object showuser(){
        APIResponse res = new APIResponse();
        List<StudentProfile> dbstd = studentRepository.findAll();
        res.setDataValues(dbstd);
        return res;
    }
    @PostMapping("/serch")
    public Object serch(@RequestBody String username){
        APIResponse res = new APIResponse();
        StudentProfile dbstudentProfile = studentRepository.findByUsername(username);

        if (dbstudentProfile == null) {
            res.setStatus(0);
            res.setMessage("No");
        }else {
            res.setStatus(1);
            res.setDataValues(dbstudentProfile);
        }
        return res;
    }

}
