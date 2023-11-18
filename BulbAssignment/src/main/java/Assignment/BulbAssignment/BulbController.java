package Assignment.BulbAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bulbs")
@CrossOrigin(origins = "http://localhost:3000") // Add your React app's URL
public class BulbController {

    @Autowired
    private BulbService bulbService;

    @GetMapping
    public List<Bulb> getAllBulbs() {
        return bulbService.getAllBulbs();
    }
}
