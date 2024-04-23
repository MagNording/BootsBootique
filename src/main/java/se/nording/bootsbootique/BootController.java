package se.nording.bootsbootique;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boots")
public class BootController {

    private final BootService bootService;

    public BootController(BootService bootService) {
        this.bootService = bootService;
    }

    @GetMapping("/")
    public Iterable<Boot> getAllBoots() {
        return bootService.findAllBoots();
    }

    @GetMapping("/types")
    public List<BootType> getBootTypes() {
        return bootService.getBootTypes();
    }

    @PostMapping("/")
    public Boot addBoot(@RequestBody Boot boot) {
        return bootService.addBoot(boot);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoot(@PathVariable("id") Integer id) {
        return bootService.deleteBoot(id) ?
                ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}/quantity/increment")
    public ResponseEntity<Boot> incrementQuantity(@PathVariable("id") Integer id) {
        return bootService.incrementQuantity(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}/quantity/decrement")
    public ResponseEntity<Boot> decrementQuantity(@PathVariable("id") Integer id) {
        return bootService.decrementQuantity(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}