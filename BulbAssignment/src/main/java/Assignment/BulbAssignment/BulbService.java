package Assignment.BulbAssignment;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BulbService {
    private List<Bulb> bulbs;

    public BulbService() {
        initializeBulbs();
    }

    private void initializeBulbs() {
        bulbs = new ArrayList<>();
        // Initialize 100 bulbs with the specified order (green, red, blue)
        for (int i = 0; i < 200; i++) {
            bulbs.add(new Bulb(i % 3 == 0 ? "Green" : i % 3 == 1 ? "Red" : "Blue"));
        }
    }

    public List<Bulb> getAllBulbs() {
        return bulbs;
    }

    public List<Bulb> getBulbsInOrder() {
        List<Bulb> orderedBulbs = new ArrayList<>();
        for (int i = 0; i < bulbs.size(); i += 3) {
            if (i < bulbs.size()) {
                bulbs.get(i).setOn(true); // Turn on all Greens
                orderedBulbs.add(bulbs.get(i)); // Add all Greens
            }
        }
        for (int i = 1; i < bulbs.size(); i += 3) {
            if (i < bulbs.size()) {
                bulbs.get(i).setOn(true); // Turn on all Reds
                orderedBulbs.add(bulbs.get(i)); // Add all Reds
            }
        }
        for (int i = 2; i < bulbs.size(); i += 3) {
            if (i < bulbs.size()) {
                bulbs.get(i).setOn(true); // Turn on all Blues
                orderedBulbs.add(bulbs.get(i)); // Add all Blues
            }
        }
        return orderedBulbs;
    }
}
