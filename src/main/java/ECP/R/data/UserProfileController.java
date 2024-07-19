package ECP.R.data;

import ECP.R.controller.APIResponse;
import ECP.R.services.servicesdata.UserProfileRepository;
import ECP.R.tables.tablesdata.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UserProfile")
@CrossOrigin("*")
public class UserProfileController {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @PostMapping("/register")
    public Object register(@RequestBody UserProfile userProfile) {
        APIResponse res = new APIResponse();
        UserProfile dbUser = userProfileRepository.findByUsername(userProfile.getUsername());
        if (dbUser == null) {
            res.setStatus(0);
            res.setMessage("Success");
            userProfileRepository.save(userProfile);
            res.setDataValues(userProfile);
        } else {
            res.setStatus(1);
            res.setMessage("User exist");
        }
        return res;
    }
    @PostMapping("/login")
    public Object login(@RequestBody UserProfile userProfile){
        APIResponse res = new APIResponse();
        UserProfile dbuser = userProfileRepository.findByUsernameAndPassword(userProfile.getUsername(), userProfile.getPassword());
        if (dbuser == null) {
            res.setStatus(1);
            res.setMessage("No user");
        }else {
            res.setStatus(0);
            res.setMessage("Success");

        }
        return res;
    }
}
