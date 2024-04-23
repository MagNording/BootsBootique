package se.nording.bootsbootique;

import io.micrometer.observation.ObservationFilter;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BootService {

    private final BootRepository bootRepository;

    public BootService(BootRepository bootRepository) {
        this.bootRepository = bootRepository;
    }

    public Iterable<Boot> findAllBoots() {
        return bootRepository.findAll();
    }

    public List<BootType> getBootTypes() {
        return Arrays.asList(BootType.values());
    }

    public Boot addBoot(Boot boot) {
        // Add any business logic or validation here
        return bootRepository.save(boot);
    }

    public boolean deleteBoot(Integer id) {
        if (!bootRepository.existsById(id)) {
            return false;
        }
        bootRepository.deleteById(id);
        return true;
    }

    public Optional<Boot> incrementQuantity(Integer id) {
        return bootRepository.findById(id).map(boot -> {
            boot.setQuantity(boot.getQuantity() + 1);
            return bootRepository.save(boot);
        });
    }

    public Optional<Boot> decrementQuantity(Integer id) {
        return bootRepository.findById(id).map(boot -> {
            boot.setQuantity(boot.getQuantity() - 1);
            return bootRepository.save(boot);
        });
    }
}

