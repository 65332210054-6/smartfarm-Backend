package ECP.R.tables;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("PumpAndValve")
public class PumpAndValveProfile {
    @Id
    @NotBlank
    private String id;
    private Boolean pump;
    private Boolean valve;
    private Boolean fan;
    private Boolean valve_fertilizer;
    private Boolean valve_pHup;
    private Boolean valve_pHDown;
    private Boolean valve_cycle;
    private Boolean valve_tree;
    @NotBlank
    private String name;

    public PumpAndValveProfile(String id,String name,Boolean pump,Boolean valve,Boolean fan,Boolean valve_fertilizer
    ,Boolean valve_pHup, Boolean valve_pHDown, Boolean valve_cycle, Boolean valve_tree){
        this.id = id;
        this.name = name;
        this.pump = pump;
        this.valve = valve;
        this.fan = fan;
        this.valve_fertilizer = valve_fertilizer;
        this.valve_pHup = valve_pHup;
        this.valve_pHDown = valve_pHDown;
        this.valve_cycle = valve_cycle;
        this.valve_tree = valve_tree;
    }
}
