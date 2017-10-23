package dataObjects;

import lombok.Getter;
import java.math.BigInteger;

@Getter
class Rover {
    Integer id;
    String name;
    String landing_date;
    String launch_date;
    String status;
    Integer max_sol;
    String max_date;
    BigInteger total_photos;
    Camera[] cameras;
}
