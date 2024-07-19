package ECP.R.controller;

import ECP.R.services.TemAndHumRepository;
import ECP.R.tables.TemAndHumProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("TemAndHumProfile")
@CrossOrigin("*")
public class ResponseController {
    @Autowired
    private TemAndHumRepository temandhumRepository;

    @PostMapping("/update")
    public Object update(@RequestBody TemAndHumProfile temAndHumProfile) {
        APIResponse res = new APIResponse();
        TemAndHumProfile db = temandhumRepository.findByName(temAndHumProfile.getName());
        if (db == null){
            res.setStatus(0);
            res.setMessage("No data");
        } else {
            temandhumRepository.deleteByName(temAndHumProfile.getName());
            db.setTem(temAndHumProfile.getTem());
            db.setHum(temAndHumProfile.getHum());
            temandhumRepository.save(db);
        }

        return res;
    }
    @PostMapping("/save")
    public Object save(@RequestBody TemAndHumProfile temAndHumProfile){
        APIResponse res = new APIResponse();
        TemAndHumProfile db = temandhumRepository.findByName(temAndHumProfile.getId());
        if (db == null) {
            res.setStatus(0);
            res.setMessage("Save success");
            res.setDataValues(temAndHumProfile);
            temandhumRepository.save(temAndHumProfile);
        }else {
            res.setStatus(1);
            res.setMessage("Update success");
            res.setDataValues(temAndHumProfile);
            temandhumRepository.save(temAndHumProfile);
        }
        return res;
    }
    @PostMapping("/show")
    public Object show (@RequestBody String name){
        APIResponse res = new APIResponse();
        TemAndHumProfile dbshow = temandhumRepository.findByName(name);
        if (dbshow != null) {
            res.setStatus(1);
            res.setMessage("Fround data");
            res.setDataValues(dbshow);
        }else {
            res.setStatus(0);
            res.setMessage("No data");
        }

        return res;
    }


}
