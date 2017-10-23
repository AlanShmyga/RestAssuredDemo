package dataObjects;

import lombok.Getter;

@Getter
public class Photo {
    Integer id;
    Integer sol;
    Camera camera;
    String img_src;
    String earth_date;
    Rover rover;
}
