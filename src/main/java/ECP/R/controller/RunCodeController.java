package ECP.R.controller;

import ECP.R.services.RunCodeRepository;
import ECP.R.tables.RunCodeProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("RunCodeProfile")
@CrossOrigin("*")
public class RunCodeController {
    @Autowired
    private RunCodeRepository runCodeRepository;

    @PostMapping("/save")
    public Object save(@RequestBody RunCodeProfile runCodeProfile) {
        APIResponse res = new APIResponse();
        res.setStatus(1);
        res.setMessage("Save success");
        res.setDataValues(runCodeProfile);
        runCodeRepository.deleteAll();
        runCodeRepository.save(runCodeProfile);
        return res;
    }
    @PostMapping("/response")
    public Object response(@RequestBody String project) {
        APIResponse res = new APIResponse();
        RunCodeProfile db = runCodeRepository.findByProject(project);
        if (db != null) {
            res.setStatus(1);
            res.setMessage("Found data");
            res.setDataValues(db);
        }else {
            res.setStatus(0);
            res.setMessage("Not found data");
        }
        return res;
    }
}
