package ECP.R.controller;

import ECP.R.services.VegetableRepository;
import ECP.R.tables.VegetableProfile;
import ECP.R.tables.Vegetable_profile_request;
import ECP.R.tables.tablesdata.StudentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/VegetableProfile")
@CrossOrigin("*")
public class VegetableController {
    @Autowired
    private VegetableRepository vegetableRepository;

    @PostMapping("/save")
    public Object save(@RequestBody Vegetable_profile_request vegetable_profile_request){
        APIResponse res = new APIResponse();
        String id = UUID.randomUUID().toString(); // gen id ที่อยู่ในรูปแบบ UUID
        Boolean db = vegetableRepository.existsByName(vegetable_profile_request.getName());  // ตรวจสอบข้อมูลใน DB ว่าเป็นจริงหรือเท็จ
        if (!db) {
            res.setStatus(1);
            res.setMessage("save success");
            VegetableProfile profile = new VegetableProfile();
            profile.setId(id);
            profile.setName(vegetable_profile_request.getName());
            profile.setRuntime(vegetable_profile_request.getRuntime());
            profile.setTem(vegetable_profile_request.getTem());
            profile.setHum(vegetable_profile_request.getHum());
            profile.setLight(vegetable_profile_request.getLight());
            profile.setPh(vegetable_profile_request.getPh());
            profile.setTime(vegetable_profile_request.getTime());
            vegetableRepository.save(profile);
            res.setDataValues(profile);
        } else {
            res.setStatus(0);
            res.setMessage("name exist");
        }
        return res;
    }


    @PostMapping("/edit")
    public Object edit(@RequestBody Vegetable_profile_request vegetable_profile_request){
        APIResponse res = new APIResponse();
        String id = vegetableRepository.findByName(vegetable_profile_request.getName()).getId();
        if(vegetableRepository.existsByName(vegetable_profile_request.getName())){
            res.setStatus(0);
            res.setMessage("edit success");
            VegetableProfile profile = new VegetableProfile();
            profile.setId(id);
            profile.setName(vegetable_profile_request.getName());
            profile.setRuntime(vegetable_profile_request.getRuntime());
            profile.setTem(vegetable_profile_request.getTem());
            profile.setHum(vegetable_profile_request.getHum());
            profile.setLight(vegetable_profile_request.getLight());
            profile.setPh(vegetable_profile_request.getPh());
            profile.setTime(vegetable_profile_request.getTime());
            vegetableRepository.save(profile);
            res.setDataValues(profile);
        }
        else {
            res.setStatus(1);
            res.setMessage("name not exist");
        }
        return res;

//        if (db == null) {
//            res.setStatus(1);
//            res.setMessage("Error");
//        } else {
//            res.setStatus(0);
//            res.setMessage("edit success");
//            vegetableRepository.deleteByName(vegetableProfile.getName());
//            vegetableRepository.save(vegetableProfile);
//            res.setDataValues(vegetableProfile);
//        }
//        return res;
    }

    @PostMapping("/show")
    public Object show (){
        APIResponse res = new APIResponse();
        List<VegetableProfile> dbshow = vegetableRepository.findAll();
        res.setDataValues(dbshow);
        return res;
    }

    @PostMapping("/search")
    public Object search(@RequestBody String name) {
        APIResponse res = new APIResponse();
        VegetableProfile db = vegetableRepository.findByName(name);

        if (db == null) {
            res.setStatus(0);
            res.setMessage("No");
        }else {
            res.setStatus(1);
            res.setDataValues(db);
        }
        return res;
    }


    @PostMapping("/update")
    public  Object update(@RequestBody VegetableProfile vegetableProfile){
        APIResponse res = new APIResponse();
        VegetableProfile db = vegetableRepository.findByName(vegetableProfile.getName());
        if (db == null){
            res.setStatus(0);
            res.setMessage("No data");
        } else {
            db.setTime(vegetableProfile.getTime());
            vegetableRepository.save(db);
            res.setStatus(1);
            res.setDataValues(db);
        }
        return res;
    }

    @PostMapping("/delete")
    public Object delete(@RequestBody VegetableProfile vegetableProfile) {
        APIResponse res = new APIResponse();
        VegetableProfile dbDelete = vegetableRepository.findByName(vegetableProfile.getName());
        if (dbDelete == null) {
            res.setStatus(0);
            res.setMessage("No data");
        } else {
            vegetableRepository.deleteByName(vegetableProfile.getName());
            res.setStatus(1);
            res.setMessage("Delete success");
        }
        return res;
    }



}
