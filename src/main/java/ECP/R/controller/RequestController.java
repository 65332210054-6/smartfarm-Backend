package ECP.R.controller;

import ECP.R.services.PumpAndValveRepository;
import ECP.R.tables.PumpAndValveProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.StyledEditorKit;

@RestController
@RequestMapping("PumpAndValveProfile")
@CrossOrigin("*")
public class RequestController {
    @Autowired
    private PumpAndValveRepository pumpAndValveRepository;
    public PumpAndValveProfile createPumpAndValveProfile(PumpAndValveProfile pumpAndValveProfile) {
        return new PumpAndValveProfile(
                pumpAndValveProfile.getId(),    //id 1
                pumpAndValveProfile.getName(),  //ch1

                pumpAndValveProfile.getPump(),  //ปั้มน้ำรดน้ำต้นไม้
                pumpAndValveProfile.getValve(), //วาล์วน้ำประปา
                pumpAndValveProfile.getFan(),  //พัดลมระบายอากาศ
                //วาล์ว ปรับค่า pH
                pumpAndValveProfile.getValve_fertilizer(),  // วาล์วน้ำยา ปุ๋ย
                pumpAndValveProfile.getValve_pHup(),    // วาล์วน้ำยา pH DOWN
                pumpAndValveProfile.getValve_pHDown(),  // วาล์วน้ำยา pH UP

                pumpAndValveProfile.getValve_cycle(),   // วาล์วน้ำวน
                pumpAndValveProfile.getValve_tree()     // วาล์วน้ำรดต้นไม้
        );
    }

    @PostMapping("/pump")  //รับ parameter จากหน้าเว็บ
    public Object pump(@RequestBody PumpAndValveProfile pumpAndValveProfile) {
        APIResponse res = new APIResponse();
        PumpAndValveProfile db = pumpAndValveRepository.findByName(pumpAndValveProfile.getName());

        if (db != null){
            Boolean pump =  db.getPump();
            // สลับสถานะ ปั้ม
            db.setPump(!pump.equals(true));
            pumpAndValveRepository.save(db);
            res.setStatus(1);
            res.setMessage("Switch pump success");
            res.setDataValues(db.getPump());
        } else {
            PumpAndValveProfile profile = createPumpAndValveProfile(pumpAndValveProfile);
            pumpAndValveRepository.save(profile);
            res.setMessage("Save new data success");
            res.setDataValues(pumpAndValveProfile);
            res.setStatus(0);
        }
        return res;
    }
    @PostMapping("/valve")
    public Object valve(@RequestBody PumpAndValveProfile pumpAndValveProfile ) {
        APIResponse res = new APIResponse();
        PumpAndValveProfile db = pumpAndValveRepository.findByName(pumpAndValveProfile.getName());

        if (db != null){
            Boolean valve =  db.getValve();
            // สลับสถานะ ปั้ม
            db.setValve(!valve.equals(true));
            pumpAndValveRepository.save(db);
            res.setStatus(1);
            res.setMessage("Switch valve success");
            res.setDataValues(db.getValve());
        } else {
            PumpAndValveProfile profile = createPumpAndValveProfile(pumpAndValveProfile);
            pumpAndValveRepository.save(profile);
            res.setMessage("Save new data success");
            res.setDataValues(pumpAndValveProfile);
            res.setStatus(0);
        }
        return res;
    }

    @PostMapping("/valve_fertilizer")
    public Object valve_fertilizer(@RequestBody PumpAndValveProfile pumpAndValveProfile ) {
        APIResponse res = new APIResponse();
        PumpAndValveProfile db = pumpAndValveRepository.findByName(pumpAndValveProfile.getName());

        if (db != null){
            Boolean valve_fertilizer =  db.getValve_fertilizer();
            // สลับสถานะ ปั้ม
            db.setValve_fertilizer(!valve_fertilizer.equals(true));
            pumpAndValveRepository.save(db);
            res.setStatus(1);
            res.setMessage("Switch valve success");
            res.setDataValues(db.getValve_fertilizer());
        } else {
            PumpAndValveProfile profile = createPumpAndValveProfile(pumpAndValveProfile);
            pumpAndValveRepository.save(profile);
            res.setMessage("Save new data success");
            res.setDataValues(pumpAndValveProfile);
            res.setStatus(0);
        }
        return res;
    }

    @PostMapping("/valve_pHup")
    public Object valve_pHup(@RequestBody PumpAndValveProfile pumpAndValveProfile ) {
        APIResponse res = new APIResponse();
        PumpAndValveProfile db = pumpAndValveRepository.findByName(pumpAndValveProfile.getName());

        if (db != null){
            Boolean valve_pHup =  db.getValve_pHup();
            // สลับสถานะ ปั้ม
            db.setValve_pHup(!valve_pHup.equals(true));
            pumpAndValveRepository.save(db);
            res.setStatus(1);
            res.setMessage("Switch valve success");
            res.setDataValues(db.getValve_pHup());
        } else {
            PumpAndValveProfile profile = createPumpAndValveProfile(pumpAndValveProfile);
            pumpAndValveRepository.save(profile);
            res.setMessage("Save new data success");
            res.setDataValues(pumpAndValveProfile);
            res.setStatus(0);
        }
        return res;
    }


    @PostMapping("/valve_pHDown")
    public Object valve_pHDown(@RequestBody PumpAndValveProfile pumpAndValveProfile ) {
        APIResponse res = new APIResponse();
        PumpAndValveProfile db = pumpAndValveRepository.findByName(pumpAndValveProfile.getName());

        if (db != null){
            Boolean valve_pHDown =  db.getValve_pHDown();
            // สลับสถานะ ปั้ม
            db.setValve_pHDown(!valve_pHDown.equals(true));
            pumpAndValveRepository.save(db);
            res.setStatus(1);
            res.setMessage("Switch valve success");
            res.setDataValues(db.getValve_pHDown());
        } else {
            PumpAndValveProfile profile = createPumpAndValveProfile(pumpAndValveProfile);
            pumpAndValveRepository.save(profile);
            res.setMessage("Save new data success");
            res.setDataValues(pumpAndValveProfile);
            res.setStatus(0);
        }
        return res;
    }


    @PostMapping("/valve_cycle")
    public Object valve_cycle(@RequestBody PumpAndValveProfile pumpAndValveProfile ) {
        APIResponse res = new APIResponse();
        PumpAndValveProfile db = pumpAndValveRepository.findByName(pumpAndValveProfile.getName());

        if (db != null){
            Boolean valve_cycle =  db.getValve_cycle();
            // สลับสถานะ ปั้ม
            db.setValve_cycle(!valve_cycle.equals(true));
            pumpAndValveRepository.save(db);
            res.setStatus(1);
            res.setMessage("Switch valve success");
            res.setDataValues(db.getValve_cycle());
        } else {
            PumpAndValveProfile profile = createPumpAndValveProfile(pumpAndValveProfile);
            pumpAndValveRepository.save(profile);
            res.setMessage("Save new data success");
            res.setDataValues(pumpAndValveProfile);
            res.setStatus(0);
        }
        return res;
    }

    @PostMapping("/valve_tree")
    public Object valve_tree(@RequestBody PumpAndValveProfile pumpAndValveProfile ) {
        APIResponse res = new APIResponse();
        PumpAndValveProfile db = pumpAndValveRepository.findByName(pumpAndValveProfile.getName());

        if (db != null){
            Boolean valve_tree =  db.getValve_tree();
            // สลับสถานะ ปั้ม
            db.setValve_tree(!valve_tree.equals(true));
            pumpAndValveRepository.save(db);
            res.setStatus(1);
            res.setMessage("Switch valve success");
            res.setDataValues(db.getValve_cycle());
        } else {
            PumpAndValveProfile profile = createPumpAndValveProfile(pumpAndValveProfile);
            pumpAndValveRepository.save(profile);
            res.setMessage("Save new data success");
            res.setDataValues(pumpAndValveProfile);
            res.setStatus(0);
        }
        return res;
    }


    @PostMapping("/fan")
    public Object fan(@RequestBody PumpAndValveProfile pumpAndValveProfile ) {
        APIResponse res = new APIResponse();
        PumpAndValveProfile db = pumpAndValveRepository.findByName(pumpAndValveProfile.getName());

        if (db != null){
            Boolean fan =  db.getFan();
            // สลับสถานะ ปั้ม
            db.setFan(!fan.equals(true));
            pumpAndValveRepository.save(db);
            res.setStatus(1);
            res.setMessage("Switch fan success");
            res.setDataValues(db.getFan());
        } else {
            PumpAndValveProfile profile = createPumpAndValveProfile(pumpAndValveProfile);
            pumpAndValveRepository.save(profile);
            res.setMessage("Save new data success");
            res.setDataValues(pumpAndValveProfile);
            res.setStatus(0);
        }
        return res;
    }

    @PostMapping("/request")  // request all status  from data
    public Object request (@RequestBody  String name){
        APIResponse res = new APIResponse();
        PumpAndValveProfile db = pumpAndValveRepository.findByName(name);
        if (db != null) {
            res.setStatus(1);
            res.setMessage("Status on");
            res.setDataValues(db);
        }else {
            res.setStatus(0);
            res.setMessage("No data");
        }
        return res;
    }

}
